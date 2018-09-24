package lesson_15.dao;

import lesson_15.connection.ConnectionDb;
import lesson_15.connection.ConnectionDbInterface;
import lesson_15.pojo.City;
import lesson_15.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface {
    private static ConnectionDbInterface connectionDb = ConnectionDb.getInstance();

    @Override
    public boolean addStudent(Student student, City city) {
        Connection connection = connectionDb.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)")
        ) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getFamilyName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getContact());
            statement.setInt(5, city.getId());
            statement.setString(6, student.getGroupName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        Connection connection = connectionDb.getConnection();
        Student student = null;
        CityDaoInterface cityDao = new CityDao();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from students WHERE id = ?")
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("family_name"),
                            resultSet.getInt("age"),
                            resultSet.getString("contact"),
                            cityDao.getCityById(resultSet.getInt("city")),
                            resultSet.getString("group_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    @Override
    public int getStudentId(Student student) {
        Connection connection = connectionDb.getConnection();
        int id = 0;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from students WHERE name = ? AND family_name = ?")
        ) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getFamilyName());
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return id;
    }

    @Override
    public boolean update(Student student, int id) {
        student.setId(id);
        if (student.getId() != 0) {
            Connection connection = connectionDb.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET name=?, family_name=?, age=?, contact=?, city=?, group_name=? WHERE id=?")
            ) {
                statement.setString(1, student.getName());
                statement.setString(2, student.getFamilyName());
                statement.setInt(3, student.getAge());
                statement.setString(4, student.getContact());
                statement.setInt(5, student.getCity().getId());
                statement.setString(6, student.getGroupName());
                statement.setInt(7, student.getId());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(int id) {
        Connection connection = connectionDb.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM students WHERE id=?")
        ) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteStudentByName(Student student) {
        Connection connection = connectionDb.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM students WHERE name=? and family_name=?")
        ) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getFamilyName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
