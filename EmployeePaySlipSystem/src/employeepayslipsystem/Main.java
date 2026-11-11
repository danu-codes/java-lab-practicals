
package employeepayslipsystem;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        EmployedPerson pe = new PermanentEmployee("Danushan", "PE1234", "IT", 'P', 65000.00, 30);
        EmployedPerson te = new TemporalyEmployee("Deluxan", "TE1234", "IT", 'T', 25);
        
        printPaySlip(pe);
        System.out.println("\n");
        printPaySlip(te);
        
        //readEmployeeDeatils();
    }
    
    public static void printPaySlip(EmployedPerson emp)
    {
        emp.calGrossSalary();
        emp.calNetSalary();
        System.out.println(emp.toString());
        
    }
    
    public static EmployedPerson readEmployeeDeatils()
    {
        EmployedPerson newEmployee;
        
        System.out.print("\nEnter Name : ");
        String name = input.nextLine();
        
        System.out.print("Enter Employee Number : ");
        String number = input.nextLine();
        
        System.out.print("Enter Department : ");
        String department = input.nextLine();
        
        System.out.print("Enter Employee type, Permanent ('p') or Temporary('T') : ");
        char type = input.next().charAt(0);
        
        //switch(type)
        //{
            //case 'P':
            //case 'p':
            if( type == 'P' || type == 'p'){
                System.out.print("Enter Basic Salary : ");
                double basicSalary = input.nextDouble();
                input.nextLine();
                System.out.print("Enter Number of Overtime Hourse : ");
                int overTimeHours = input.nextInt();
                
                 newEmployee = new PermanentEmployee(name, number, department, type, basicSalary, overTimeHours);
                
                //break;
            }
            else if( type == 'T' || type == 't'){
            //case 'T':
            //case 't':
                System.out.print("Enter Number of Dates worked : ");
                int numberOfDatesWorked = input.nextInt();
                
                newEmployee = new  TemporalyEmployee(name, number, department, type, numberOfDatesWorked);
            }//break;
            //default:
            else{
                System.out.println("\nInvalid Employee Type!");
                return null;
                //break;}
        }
            printPaySlip( newEmployee );
        return newEmployee;
    }
}
