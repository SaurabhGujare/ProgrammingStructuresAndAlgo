package TsysStudentClass;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */

class Student{

    private String name;
    private int enrollmentNumber;
    private static int count = 0;

    Student(String name){
        this.name = name;
        this.enrollmentNumber = (count+=1);

    }

    @Override
    public String toString() {
        return this.enrollmentNumber+": "+this.name;
    }
}

public class Solution {

    public static void main(String[] args){
        Student student = new Student("pat");
        Student student1 = new Student("chris");

        System.out.println(student.toString());
        System.out.println(student1.toString());
    }


}
