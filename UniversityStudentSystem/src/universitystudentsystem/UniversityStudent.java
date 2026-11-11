
package universitystudentsystem;
import java.util.Arrays;

abstract class UniversityStudent {
    private String firstName;
    private String lastName;
    private String indexNo;
    private final static int MAX_NUM_SUBJECT = 10;
    private String[] listOfCourses = new String[MAX_NUM_SUBJECT];
    private double[] listOfMarks = new double[MAX_NUM_SUBJECT];
    private double[] listOfCourseCredits = new double[MAX_NUM_SUBJECT];
    private int courseCounter = 0;
    private double totalCredits;
    private double gpa;
    private String grade;
    
    public UniversityStudent(String firstName, String lastName, String indexNo)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setIndexNo(indexNo);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public void setListOfCourses(String[] listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    public void setListOfMarks(double[] listOfMarks) {
        this.listOfMarks = listOfMarks;
    }

    public void setListOfCourseCredits(double[] listOfCourseCredits) {
        this.listOfCourseCredits = listOfCourseCredits;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public static int getMAX_NUM_SUBJECT() {
        return MAX_NUM_SUBJECT;
    }

    public String[] getListOfCourses() {
        return listOfCourses;
    }

    public double[] getListOfMarks() {
        return listOfMarks;
    }

    public double[] getListOfCourseCredits() {
        return listOfCourseCredits;
    }

    public int getCourseCounter() {
        return courseCounter;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return 
                "\nfirstName : " + firstName +
                "\nlastName : " + lastName + 
                "\ngpa : " + gpa + 
                "\ngrade : " + grade;
    }
    
    public double calculateGpa()
    {
        if( totalCredits == 0 )
        {
            System.out.println("No courses added yet!");
            gpa = 0;
            return gpa;
        }

        double weightedSum = 0;
        for(int index=0; index<courseCounter; index++)
        {
            weightedSum += listOfMarks[index] * listOfCourseCredits[index] ;
        }
        gpa = weightedSum / totalCredits;
        return gpa;
    }
    
    public void addCourseDetails(String courseCode, double marks, double courseCredits)
    {
        if( courseCounter<MAX_NUM_SUBJECT )
        {
        listOfMarks[courseCounter] = marks;
        listOfCourseCredits[courseCounter] = courseCredits;
        listOfCourses[courseCounter] = courseCode;
        totalCredits += courseCredits;
        courseCounter++;
        }
        else
        {
            System.out.println("Maxium number of course added!");
        }
    }
    public abstract void evaluateGrade();
    
}
