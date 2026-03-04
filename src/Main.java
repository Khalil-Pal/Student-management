import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("====Students management system====");

        int numberOfstudents;
        //Number of students
        while (true){
            System.out.println("How many student you want to add ? ");
            try{
                numberOfstudents = scanner.nextInt();
                scanner.nextLine();

                if (numberOfstudents < 0){
                    System.out.println("The number of students should be positive!");
                    continue;
                }
                break;
            }
            catch (InputMismatchException e){
                System.out.print("Enter a valid number : ");
                scanner.nextLine();
            }
        }
        StudentFactory factory = new StudentFactory();
        //Entering students data
        for (int i = 0 ; i < numberOfstudents ; i++){
            System.out.println("Entering information of Student #"+(i+1)+" :");
            Student student =factory.createStudent();
            students.add(student);
        }
        System.out.println("All students added successfully!");

        //Operations(add, delete , replace , view , exit)

        while (true){
            System.out.println("Choose the operation you want by entering the number of it : ");
            System.out.println("""
                1-Add a new student
                2-delete student from the table\
                
                3-replace student
                4-Show all students info
                5-Exit""");
            System.out.print("Operation number : ");
            int opNumber = scanner.nextInt();
            if (opNumber ==5){
                System.out.println("See you later !");
                break;
            }
            switch (opNumber){
                //adding new students
                case 1 :

                    int numberNewstudents;

                    while (true){
                        try{
                            System.out.print("How many students you want to add ?: ");
                            numberNewstudents = scanner.nextInt();
                            scanner.nextLine();
                            if (numberNewstudents < 0){
                                System.out.println("It should be positive ! :");
                                continue;
                            }
                            break;
                        }catch (InputMismatchException e){
                            System.out.print("Enter a valid number : ");
                            scanner.nextLine();
                        }
                    }
                    for (int i = 0 ; i < numberNewstudents ; i++){
                        System.out.println("Entering information of Student #"+(i+1)+" :");
                        Student student =factory.createStudent();
                        students.add(student);
                    }
                    System.out.println("All new students added successfully!");
                    break;
                //deleting students
                case 2:

                    int idDelete;
                    int index;

                    while (true){
                        try {
                            System.out.print("Enter the student ID to delete:");
                            idDelete = scanner.nextInt();
                            scanner.nextLine();

                        }catch (InputMismatchException e){
                            System.out.print("It should be numbers ! Try again:");
                            scanner.nextLine();
                            continue;
                        }
                        index = -1;
                        for (int i= 0 ;i < students.size() ; i++){
                            if (idDelete == students.get(i).id){
                                index = i;
                                break;
                            }
                        }
                        if (index!=-1){
                            students.remove(index);
                            System.out.println("Student removed successfully!");
                            break;
                        }else System.out.println("No student with this ID number found! TRy again :");

                    }
                    break;
                case 3 :
                    int idReplace;
                    int index1;

                    while(true){
                        try{
                            System.out.print("Enter the student's id to replace him : ");
                            idReplace = scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.print("ID should be numbers ! Try again :");
                            scanner.nextLine();
                            continue;
                        }
                        index1 = -1;
                        for (int i = 0; i < students.size(); i++) {
                            if (idReplace == students.get(i).id){
                                index1 = i;
                                break;
                            }
                        }
                        if (index1!=-1){
                            students.remove(index1);
                            System.out.println("Student removed successfully!");
                            System.out.println("Entering information of new student :");
                            Student student =factory.createStudent();
                            students.add(student);
                            break;
                        }else System.out.println("No student with this ID number found! TRy again :");
                    }
                    break;
                case 4 :
                    for (Student student : students){
                        student.showStudents();
                    }
                    break;

                default:

                    System.out.println("Invalid operation number");

                    break;

            }
        }
    }
}
