package lesson_15;

import lesson_15.dao.StudentDao;
import lesson_15.dao.StudentDaoInterface;
import lesson_15.pojo.City;
import lesson_15.pojo.Student;

public class Main {
    public static void main(String[] args) {
        StudentDaoInterface studentDao = new StudentDao();
        Student student = new Student();

        City city = new City(1, "Moscow", 15000000);
        student.setName("Egor");
        student.setFamilyName("Smolyakov");
        student.setAge(32);
        student.setContact("+ 7 123 456 78 99");
        student.setCity(city);
        student.setGroupName("testers");
        studentDao.addStudent(student, city);

        studentDao.getStudentById(1);
        System.out.println(student);

        student.setContact("+ 7 123 456 79 00");
        studentDao.update(student, studentDao.getStudentId(student));

        studentDao.deleteStudentById(studentDao.getStudentId(student)); //delete student!


    }
}
