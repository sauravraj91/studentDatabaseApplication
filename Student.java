package studentdatabaseapp;

import java.util.Scanner;

import sun.awt.SunHints.Value;

public class Student {

	private String firstName;
	private String lastName;
	private String gradeYear;
	private String studentID;
	private String courses= "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int ID = 1000;

	// constructor : prompts students to enter name and year

	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first name of the student :");
		this.firstName = in.nextLine();

		System.out.println("Enter the last name of the student :");
		this.lastName = in.nextLine();

		this.gradeYear = setGradeYear();
		setStudentID();
		
		//System.out.println("NAME OF THE STUDENT : " + firstName + " " + lastName + "\nGrade Year is :"
			//+ this.gradeYear.substring(1) + "\nStudent ID IS : " + studentID);

	}

	private String setGradeYear() {
		System.out.println("Select the grade year of the student from below :");
		System.out.println("1 - FRESHER\n2 - Second year\n3 - Third year\n4 - Final year\n Enter your choice : ");
		Scanner in = new Scanner(System.in);
		int gradeYear = in.nextInt();
		if (gradeYear == 1) {
			return "1FRESHER";
		} else if (gradeYear == 2) {
			return "2Second year";
		} else if (gradeYear == 3) {
			return "3Third Year";
		} else {
			return "4Final Year";
		}
	}

	// create a 5 digit unique Id with the first number being their grade level

	private void setStudentID() {
		// gradeYear+ID
		ID++;
		this.studentID = gradeYear.substring(0, 1) + "" + ID;

	}

	// enrolling students to courses

	public void enroll() {
		do {
			System.out.println("Enter course to enroll : " + "[PRESS Q/q to quit]");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if ((!course.equalsIgnoreCase("Q"))) {
				courses = courses + "\n" + course;
				tuitionBalance = costOfCourse + tuitionBalance;
			} else {
                break;
			}
		} while (1 != 0);
           System.out.println("Enrolled in :" + courses);
           System.out.println("CURRENT TUITION BALANCE FOR COURSES ENROLLED IS : " +tuitionBalance );
	}

	// view the balance
	
	public void viewBalance() {
		System.out.println("Your remaining balance after payment is :" + tuitionBalance + "$" );
	}

	// pay tuition
	
	public void payTuition() {
		System.out.println("Enter your payment : $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thankyou for your payment :" + payment + "$");
		viewBalance();
		showInfo();
	}

	// show their info
	
	public void showInfo() {
		System.out.println("NAME OF THE STUDENT : " + firstName  + lastName + "\nGrade Year is :" + 
				this.gradeYear.substring(1) + " \nStudent ID IS :" + studentID);
	}
	

}
