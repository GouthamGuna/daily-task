package main.controller;


import main.repo.Staff;
import main.repo.Student;

public class SchoolController implements Staff, Student {
    @Override
    public void staffBaseDetails() {
        int staffId1 = Staff.staffId;
        System.out.println( "staffId1 = " + (++staffId1) );
    }

    @Override
    public void studentBaseDetails() {
        int studentId1 = Student.studentId;
        System.out.println( "studentId1 = " + (++studentId1) );

    }

    public static void main(String[] args) {

        SchoolController controller =
                new SchoolController();

        controller.staffBaseDetails();
        controller.studentBaseDetails();
    }
}
