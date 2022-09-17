package studentManagmentSystem;

import java.util.*;
import java.io.*;

public class studentManagament {
//this is the main class
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//Ask how many new students you want to add
		System.out.print("Enter number of new students to enroll: ");
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		
		//create n number of new students
		
		//but creating a seperate object for each student and calling enroll(),payFee() and showInfo() for each object is inefficient and leads to wastage of memory
		//so create an array of objects of Student class
		
		Student[] students = new Student[num];
		
		//create a file to store student info
		FileOutputStream f=new FileOutputStream(new File("student_info.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(f);
		
		for(int i=0;i<num;i++) {
			students[i]=new Student();
			students[i].enroll();
			students[i].payFee();
			oos.writeObject(students[i]);
		}
        oos.close();
        f.close();
        
		//read content of the file
		
        FileInputStream fi =new FileInputStream(new File("student_info.txt"));
        ObjectInputStream ois = new ObjectInputStream(fi);
		for(int i=0;i<num;i++) {
		Student s=(Student)ois.readObject();  
	        //readObject() returns the object that is read as type "Object class"
		// so casting the return type of object that is read into Student object
		System.out.println(s.showInfo());
		}
		ois.close();
		fi.close();
		}

}
