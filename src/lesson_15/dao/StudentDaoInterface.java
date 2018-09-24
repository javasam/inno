package lesson_15.dao;

import lesson_15.pojo.City;
import lesson_15.pojo.Student;

public interface StudentDaoInterface {

    boolean addStudent(Student student, City city);

    Student getStudentById(int id);

    int getStudentId(Student student);

    boolean update(Student student, int id);

    boolean deleteStudentById(int id);

    boolean deleteStudentByName(Student student);
}
