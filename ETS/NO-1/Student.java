public class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void study() {
        System.out.println(name + " is studying in " + grade + "th grade.");
    }
}
