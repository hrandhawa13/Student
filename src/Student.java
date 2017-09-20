public class Student{
    private static int ID_COUNTER = 7776;//7777 would be the first student number 
	private  int studentNum ;
    private  String firstName ;
    private  String lastName ;
    private  String address;
    private  String loginID;
    private  double numCredits;
    private  double totalGradePoints;
   
    /**
     * Default constructor with no arguments
     */
    public  Student(){//default constructor 
        ID_COUNTER++;
        studentNum = ID_COUNTER;
        firstName = "";
        lastName = "";
        address = "";
        loginID = "";
        numCredits = 0;
        totalGradePoints = 0;
    }
    /**
     * Constructor with 2 arguments. It creates an object and assigns name and address as entered by the test class
     * @param address It is the address of the student 
     * @param name  It is the full name of the student 
     */
    public Student( String address , String name ){//constructor with arguments 
    	ID_COUNTER++;
    	studentNum = ID_COUNTER;
        getFirstAndLastName( name );
        this.address = address ;
        loginID = makeLoginID() ;
        numCredits = 0;
        totalGradePoints = 0;
    }
    /**
     * This method returns the student number of the student object
     * @return Returns student number
     */
    public int getStudentNum(){//return student Number
    	return studentNum;
    }
    /**
     * It is used to assign first name and last name to the object. Name entered can be in unorderly format. This
     * method splits the name into first and last name and assign it to the student object.
     * @param name as entered by the test class 
     */
    public void getFirstAndLastName( String name ){//
        String nameNew = name.trim();
        String[] arr = nameNew.split("\\s");
        firstName = arr[0];
        lastName = arr[1];
    }/**
     * This method returns first and last name as a string. 
     * @return Returns first and last name of the student  
     */
    public String getName (){
        return firstName + " " + lastName;
    }
    /**
     * This method returns the address of the student object
     * @return Returns the address of the student  
     */
    public String getAddress(){
        return address;
    }
    /**
     *This method doesn't return anything. It just adds grade points and credits to the student profile.
     * @param grade this is the grade received in a course
     * @param credits this is the credits for that course
     */
    public void addCourse( double grade, double credits ){
        totalGradePoints += grade*credits ;
        numCredits += credits;
    }
    /**
     * This method returns the GPA of the student.
     * @return Returns float GPA of student  
     */
    public double getGPA(){
    	if ( numCredits == 0 ){
    		System.out.println( " Student has not earned any credit yet ");
    		return 0 ;
    	}
        double GPA = totalGradePoints/numCredits;
        GPA *= 100;
        GPA = Math.round(GPA);
    	GPA /= 100;
    	return GPA;
    }
    /**
     * This method returns the Login ID of the student.
     * @return Returns login ID
     */
    public String getLoginID(){
        return loginID;
    }
   /**
    * This method makes the login ID of the student as per rules described to make the login ID.
    *@return Returns string login id for a student
    */
    public String makeLoginID(){
        int firstAlphabet = firstName.charAt(0);
        if ( firstAlphabet <= 'Z' && firstAlphabet >= 'A' ){//user entered first alphabet of the first name as capital letter 
        	firstAlphabet = firstAlphabet - 'A' + 'a';
        }
        String temp = ""+ (char)( firstAlphabet ) ;//add first alphabet of the first name to the string 
        temp += getLastNameForID();
        temp += digitalRoot();
        return temp;
    }
/**
 *@return Returns string which is the first 3 characters of last name. If last name is less than 3 characters
 *then it just returns whatever the last name is. 
 */
    public String getLastNameForID(){
        String temp = "" ;
        char x;
        int len = lastName.length();
        if ( len < 3 ){//last name is less than 3 characters
            for ( int i =0; i< len; i++ ){
                 x = lastName.charAt( i );
                 temp += x;//adds characters to temp
            }
            return temp.toLowerCase();
        }
        for ( int i =0; i < len; i++ ){//gets the first 3 characters of last name
            temp += lastName.charAt( i );
        }
        return temp.toLowerCase();
    }
/** 
*@return Returns the digital root of the ID 
 */
    public int digitalRoot(){
        String temp = "" + studentNum;
        int value = 0;
        int len = temp.length();
        while ( len > 1 ){
            for ( int i =0; i < len; i++ ){
                value += temp.charAt( i ) - '0' ;
            }
            temp = "" + value ;
            value = 0;
            len = temp.length();
        }
        return Integer.parseInt( temp );
    }
}
 