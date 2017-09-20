/*
This program is used to make new records for students 
It asks user about the address and name of each student
It assigns ID and login ID to each student
User can add courses and their credits to each student profile 
In the end it displays all the record of the student to the user 
All the display is done with the help of dialog boxes from library JOptionPane


ASSUMPTIONS
1 User does not press cancel or exit button when entering the value in JOptionPane
2 User enters the value in correct format
3 Correct format are 
	ADDRESS should be string 
	NAME should be string with first name and last name 
	CREDITS should be double or int
	GRADES should be double or int 
	
Author- Harmanjit Randhawa
*/
import javax.swing.JOptionPane;


public class StudentTester {
	public static void main ( String[] args){
		
		Student student1 = makeStudentRecord();//makes an instance of Student class 
		addCourse( student1 );//adding courses to the instance s1
		addCourse( student1 );//adding courses to the instance s1
		to_Screen( student1 );//printing all the information about s1
		
		Student student2 = makeStudentRecord();//makes an instance of Student class
		addCourse( student2 );//adding courses to the instance s2
		addCourse( student2);//adding courses to the instance s2
		to_Screen( student2 );//printing all the information about s2
		
		
	}
	/**
	 * This method asks user for address and name and then assigns that name'
	 *  and address to the instance of the Student class 
	 * @return Returns instance of Student class. 
	 */
	public static Student makeStudentRecord(){
		String address = getUserInput( " Please enter the address of the student " );//asks user to enter the address of the student 
		String name = getUserInput( " Please enter the name of the student " );//asks user to enter the name of the student 
		Student s1 = new Student ( address, name );//making an instance of student class
		return s1;
	}
	/**
	 * This method prints all the information about student.
	 * It calls all the methods in the student class to fetch the data fields of the object
	 * @param student This is the student about whom all the information is printed.
	 */
	public static void to_Screen(Student student){
		JOptionPane.showMessageDialog(null, "Name -> " + student.getName() + 
		 "\nAddress -> " + student.getAddress() + 
		 "\nStudent Number -> " + student.getStudentNum() + 
		 "\nLogin ID -> " + student.getLoginID() + 
		 "\nGPA -> " + student.getGPA() );
	}
	/**
	 * This method asks user to enter a field of the student 
	 * @return Returns the filed entered of the student by the user. It could be used to assign any filed of the student class.
	 * @param value It could be any field for student object. 
	 */
	public static String getUserInput( String value ){
		return JOptionPane.showInputDialog(null, value  , " DO NOT PRESS CANCEL!!!!!!!!!!!!!!!!!!!!!!!! ", JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * This method adds course grade and course credits to each students profile.
	 * It asks user about the grade received and credits of the course. 
	 * User can enter any value from 0 - 4.33 as grade received.
	 * User can enter any value from 0 - 5 as credit received 
	 * @param student This is the student to whose profile the course will be added
	 */
	public static void addCourse ( Student student ){
		String credit = getUserInput(" Please enter credits of this course ");
		String grade = getUserInput(" Please enter the grade of this course ");
		student.addCourse(Double.parseDouble(credit), Double.parseDouble(grade));
	}
}
