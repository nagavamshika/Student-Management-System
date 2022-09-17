package studentManagmentSystem;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {//Student cls must serialized to write objects to the file
//it is related to each student
	private String firstName;
	private String lastName;
	private int year;
	private String studentID;
	private String courses="";
	private static int costOfCourse=600;
	private int tutionBalance=0;
	private static int id=1000; 
	
	//constructor prompts user to enter student's name and year
	
	public Student() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter student first name: ");
		firstName=sc.nextLine();
		
		System.out.print("Enter student last name: ");
		lastName=sc.nextLine();
		
		System.out.print("1 - FirstYear\n2 - Second Year\n3 - ThirdYear\n4 - FourthYear\nEnter student year: ");
		year=sc.nextInt();
		
		//generate an id for each student
		setStudentID();
	}
		
	
	 private void setStudentID() {
		 //creating an id need not be displayed to the user.
		 //so the func is static
		 
		 //the studentId is combination of year + id;
		 id++;
		 studentID = year +""+ id;
		 
	 }
	
	 
	//enroll in courses
	
	 public void enroll() {
		 
		 //get inside a loop , user hits Q when they want to exit
		
		 do {
		 System.out.print("Enter couse to enroll (Q to quit): ");
		 Scanner sc=new Scanner(System.in);
		 String course=sc.nextLine();
		 if(!course.equals("Q")) {
			 
			 //the new course is added to the list of already enrolled courses
			 courses = courses +"\n " + course;
			 
			 //for each enrolled course tutionBalance is updated
			 tutionBalance = tutionBalance + costOfCourse;
		 }
		 else {
			 break;
		 }
		 }while(true);
		
	 }
	 
	 
	//view balance fee
	
	 public void viewBalance() {
		 System.out.println("Your balance is : Rs."+tutionBalance);
		 
	 }
	 
	 
	//pay tution fee
	
	 
	 public void payFee() {
		 viewBalance();
		 System.out.print("Enter your payment: ");
		 Scanner sc=new Scanner(System.in);
		 int payment=sc.nextInt();
		 tutionBalance -= payment;
		 System.out.println("Thank you for your payment of Rs."+payment);
		 viewBalance();
	     //same student object will also call viewBalance method
	 }
	 
	//print status of each student
	 
	 public String showInfo() {
		 return ("Name: "+firstName+" "+lastName+"\nYear: "+year+"\nStudent ID: "+studentID+"\nCourses enrolled: "+courses+"\nBalance fee: Rs."+tutionBalance);
	 }
}
