import java.util.InputMismatchException;

import java.util.Scanner;

public class StudentFactory {

    private Scanner scanner = new Scanner(System.in);
    public Student createStudent(){

        int age;
        int id;
        String name;

        while (true){
            System.out.print("Enter the student name :");
            name = scanner.nextLine();
            if(StudentValidator.isValidName(name))break;
            System.out.println("Invalid name!");
        }
        while (true){
            try{
                System.out.print("Enter the student age :");
                age = scanner.nextInt();
                if(StudentValidator.isValidAge(age))break;
                System.out.print("Age must be positive ! ");
            }catch (InputMismatchException e){
                System.out.print("Age must be a numebr !:");
                scanner.nextLine();
            }
        }
        while(true){
            try{
                System.out.print("Enter student's ID :");
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            }catch (InputMismatchException e){
                System.out.print("ID should be a number !");
                scanner.nextLine();
            }
        }
        return new Student(name,age,id);
    }
}
