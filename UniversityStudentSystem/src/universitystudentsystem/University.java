//AS2023908
package universitystudentsystem;

import java.util.Scanner;

public class University {

    private static Scanner input = new Scanner(System.in);
    public final static int MAX_STUDENT = 100;
    private static UniversityStudent[] studentArray = new UniversityStudent[MAX_STUDENT];
    private static int studentCount = 0;

    public static void main(String[] args) {
        printMenu();
    }

    public static void printMenu() {
        int choice;

        do {
            System.out.println("\nWelcome to University System Menu");
            System.out.println("1 - Register Students");
            System.out.println("2 - Search");
            System.out.println("3 - Add Marks");
            System.out.println("4 - Calculate GPA");
            System.out.println("5 - Evaluate Grade");
            System.out.println("6 - Print Student Details");
            System.out.println("7 - Exit");

            System.out.print("Enter your choice [1-7] : ");
            choice = input.nextInt();

            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n===  Register Student ===");
                    registerStudents();
                    break;
                case 2:

                    searchStudent();

                    break;
                case 3:
                    System.out.println("\n=== Add Marks ===");
                    System.out.print("Enter Student index no : ");
                    String indexNo = input.nextLine();
                    addMarks(indexNo);
                    break;
                case 4:
                    System.out.println("\n=== Calculate GPA ===");
                    System.out.print("Enter Student index no : ");
                    indexNo = input.nextLine();
                    calculateGPA(indexNo);
                    break;
                case 5:
                    System.out.println("\n=== Evaluate Grade ===");
                    System.out.print("Enter Student index no : ");
                    indexNo = input.nextLine();
                    evaluateGrade(indexNo);
                    break;
                case 6:
                    System.out.println("\n=== Print Student Details ===");
                    printStudentDetails();
                    break;
                case 7:
                    System.out.println("\nSystem terminated!");
                    return;
                default:
                    System.out.println("\nInvalid choice !");
                    System.out.println("Choose between [1-7] !");
                    break;
            }
        } while (choice != 7);
    }

    public static void registerStudents() {

        double zScore;
        double entranceMarks;

        if (studentCount >= MAX_STUDENT) {
            System.out.println("Student list is full!");
            return;
        }

        if (studentCount < MAX_STUDENT) {
            System.out.print("\nEnter student first name : ");
            String fname = input.nextLine();

            System.out.print("Enter student last name : ");
            String lname = input.nextLine();

            System.out.print("Enter student index number : ");
            String indexNo = input.nextLine();

            if (search(indexNo) != null) {
                System.out.println("A student with this index number already exists!");
                return;
            }

            System.out.print("Enter student faculty ( 1:Undergraduate 2:Postgraduate ) : ");
            int faculty = input.nextInt();

            input.nextLine();

            //boolean variables
            boolean zscoreCheck = false;
            boolean entranceMarkCheck = false;

            switch (faculty) {
                case 1:

                    do {
                        System.out.print("Enter student z-score : ");
                        zScore = input.nextDouble();
                        if (zScore < 0) {
                            System.out.println("Enter valid zscore!");
                            zscoreCheck = false;
                        } else if (zScore < 1.2) {
                            System.out.println("your zscore lessthan 1.2 so can't register!");
                            return;
                        } else {
                            zscoreCheck = true;
                        }
                    } while (!zscoreCheck);

                    input.nextLine();

                    System.out.print("Enter student combination ( 1 -S01, 2 -S02, 3 -S03, 4 -S04 ) : ");
                    int combinationNo = input.nextInt();

                    //create an object for Subcombination
                    SubCombination combination;

                    switch (combinationNo) {
                        case 1:
                            combination = SubCombination.S01;
                            break;
                        case 2:
                            combination = SubCombination.S02;
                            break;
                        case 3:
                            combination = SubCombination.S03;
                            break;
                        case 4:
                            combination = SubCombination.S04;
                            break;
                        default:
                            System.out.println("\nInvalid combination!");
                            return;
                    }

                    studentArray[studentCount++] = new PhysicalStudent(fname, lname, indexNo, zScore, combination);
                    break;
                case 2:
                    do {
                        System.out.print("Enter student entrance exam marks : ");
                        entranceMarks = input.nextDouble();

                        if (entranceMarks < 0) {
                            System.out.println("Enter valid entrance marks!");
                            entranceMarkCheck = false;
                        } else if (entranceMarks < 30) {
                            System.out.println("your entrance marks lessthan 30 so can't register!");
                            return;
                        } else {
                            entranceMarkCheck = true;
                        }
                    } while (!entranceMarkCheck);

                    input.nextLine();

                    System.out.print("Enter student postgraduate course ( 1:MSc, 2:MPhil, 3:Phd ) : ");
                    int postgraduateCourseNum = input.nextInt();
                    input.nextLine();

                    //create an object for postcategory
                    PostCategory postGategory;

                    switch (postgraduateCourseNum) {
                        case 1:
                            postGategory = PostCategory.MSC;
                            break;
                        case 2:
                            postGategory = PostCategory.MPHIL;
                            break;
                        case 3:
                            postGategory = PostCategory.PHD;
                            break;
                        default:
                            System.out.println("\nInvalid postgraduate course selection!");
                            return;
                    }
                    System.out.print("Enter supervisor name : ");
                    String supervisor = input.nextLine();
                    studentArray[studentCount++] = new PostgraduateStudent(fname, lname, indexNo, supervisor, entranceMarks, postGategory);
                    break;

                default:
                    System.out.println("\nInvalid Faculty!");
                    break;
            }

        }
    }

    public static UniversityStudent search(String indexNo) {
        for (int index = 0; index < studentCount; index++) {
            if (indexNo.equalsIgnoreCase(studentArray[index].getIndexNo())) {
                return studentArray[index];
            }
        }
        return null;
    }

    public static void searchStudent() {
        System.out.println("\n=== Search Student ===");
        System.out.print("Enter Student index no : ");
        String indexNo = input.nextLine();

        if (search(indexNo) != null) {
            System.out.println("Student Name : " + search(indexNo).getFirstName() + " " + search(indexNo).getLastName());
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void addMarks(String indexNo) {

        boolean marksCheck = false;
        boolean courseCreditCheck = false;
        boolean ResearchGradecheck = false;

        String courseCode;
        double marks;
        double courseCredit;
        double ResearchGrade;

        UniversityStudent student = search(indexNo);

        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.print("Enter course code : ");
            courseCode = input.nextLine();

            do {
                System.out.print("Enter course credits ( 1.0/1.5/2.0 ) : ");
                courseCredit = input.nextDouble();

                if (courseCredit != 1.0 && courseCredit != 1.5 && courseCredit != 2.0) {
                    courseCreditCheck = false;
                    System.out.println("\n Enter valid course credit!");
                } else {
                    courseCreditCheck = true;
                }
            } while (!courseCreditCheck);

            do {

                System.out.print("Enter marks ( 1.0/1.5/2.0/2.5/3.0/3.5/4.0/4.5 ) : ");
                marks = input.nextDouble();

                if (marks < 1.0 || marks > 4.5) {
                    marksCheck = false;
                    System.out.println("\n Enter valid marks!");
                } else {
                    marksCheck = true;
                }
            } while (!marksCheck);

            if (student instanceof PostgraduateStudent) {

                do {
                    System.out.print("Enter Research Grade ( 1.0/1.5/2.0/2.5/3.0/3.5/4.0/4.5 ) : ");
                    ResearchGrade = input.nextDouble();
                    if (ResearchGrade >= 1.0 && ResearchGrade <= 4.5) {
                        ResearchGradecheck = true;
                        ((PostgraduateStudent) student).setResearchGrade(ResearchGrade);
                    } else {
                        ResearchGradecheck = false;
                        System.out.println("\nInvalid research grade!");
                    }
                } while (!ResearchGradecheck);
            }
            student.addCourseDetails(courseCode, marks, courseCredit);
        }
    }

    public static void calculateGPA(String indexNo) {
        UniversityStudent student = search(indexNo);

        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("\nStudent Name  : " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student indexNo : " + student.getIndexNo());
            System.out.println("GPA : " + student.calculateGpa());
        }
    }

    public static void evaluateGrade(String indexNo) {
        UniversityStudent student = search(indexNo);

        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("\nStudent Name  : " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student indexNo : " + student.getIndexNo());
            student.calculateGpa();
            student.evaluateGrade();
            System.out.println("Grade : " + student.getGrade());
        }
    }

    public static void printStudentDetails() {
        if (studentCount != 0) {
            System.out.println("\n|Index No\t|Name\t|GPA\t|Grade");
            for (int index = 0; index < studentCount; index++) {
                UniversityStudent student = studentArray[index];
                System.out.printf("%s\t\t%s\t%.1f\t%s\n",
                        student.getIndexNo(),
                        student.getFirstName(),
                        student.getGpa(),
                        student.getGrade());
            }
        } else {
            System.out.println("No students details!");
        }
    }
}
