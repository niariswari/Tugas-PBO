import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student age: ");
        int studentAge = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        Student student = new Student(studentName, studentAge, grade);
        student.display();
        student.study();

        System.out.print("\nEnter teacher name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Enter teacher age: ");
        int teacherAge = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter subject taught: ");
        String subject = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName, teacherAge, subject);
        teacher.display();
        teacher.teach();

        System.out.print("\nEnter staff name: ");
        String staffName = scanner.nextLine();
        System.out.print("Enter staff age: ");
        int staffAge = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        Staff staff = new Staff(staffName, staffAge, role);
        staff.display();
        staff.manage();

        scanner.close();
    }
}
