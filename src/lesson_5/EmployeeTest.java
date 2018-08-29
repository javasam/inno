package lesson_5;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void whenAddNewEmployeeThenCreateNewFileOnDisk() {
        DataBase dataBase = new DataBase();
        Employee employee = new Employee("Mark", 25, 60000, "tester");
        boolean expected = dataBase.save(employee);
        assertThat(true, is(expected));
    }

    @Test
    public void whenDeleteEmployeeThenEmployeeDeletedFromFile() {
        DataBase dataBase = new DataBase();
        Employee employee = new Employee("Mark", 25, 60000, "tester");
        dataBase.save(employee);
        boolean expected = dataBase.delete(employee);
        assertThat(true, is(expected));
    }

    @Test
    public void whenStartGetByNameMethodThenGetEmployee() {
        DataBase dataBase = new DataBase();
        Employee employee = new Employee("Mark", 25, 60000, "tester");
        dataBase.save(employee);
        Employee expected;
        expected = dataBase.getByName("Mark");
        assertThat(employee, is(expected));
    }

    @Test
    public void whenStartGetByJobMethodThenGetEmployee() {
        DataBase dataBase = new DataBase();
        List<Employee> expected = new LinkedList<>();
        Employee mark = new Employee("Mark", 25, 60000, "tester");
        Employee egor = new Employee("Egor", 27, 50000, "tester");
        Employee petr = new Employee("Petr", 27, 50000, "programmer");
        dataBase.save(mark);
        dataBase.save(egor);
        dataBase.save(petr);
        expected.add(mark);
        expected.add(egor);
        assertThat(dataBase.getByJob("tester"), is(expected));
    }

    @Test
    public void whenStartSaveOrUpdateMethodThenEmployeeUpdateToFile() {
        DataBase dataBase = new DataBase();
        Employee mark = new Employee("Mark", 25, 60000, "tester");
        Employee egor = new Employee("Egor", 27, 50000, "tester");
        Employee petr = new Employee("Petr", 27, 50000, "programmer");
        dataBase.save(mark);
        dataBase.save(egor);
        dataBase.save(petr);
        Employee betterMark = new Employee("Mark", 25, 60000, "programmer");
        assertThat(dataBase.saveOrUpdate(betterMark), is(true));
    }

    @Test
    public void whenStartSaveOrUpdateMethodThenEmployeeSaveToFile() {
        DataBase dataBase = new DataBase();
        Employee mark = new Employee("Mark", 25, 60000, "tester");
        Employee egor = new Employee("Egor", 27, 50000, "tester");
        Employee petr = new Employee("Petr", 27, 50000, "programmer");
        dataBase.save(mark);
        dataBase.save(egor);
        assertThat(dataBase.saveOrUpdate(petr), is(true));
    }

    @Test
    public void whenStartChangeAllWorkMethodThenAllWorkChanged() {
        DataBase dataBase = new DataBase();
        Employee mark = new Employee("Mark", 25, 60000, "tester");
        Employee egor = new Employee("Egor", 27, 50000, "tester");
        Employee petr = new Employee("Petr", 27, 50000, "programmer");
        dataBase.save(mark);
        dataBase.save(egor);
        dataBase.save(petr);
        assertThat(dataBase.changeAllWork("programmer", "developer"), is(true));
    }
}