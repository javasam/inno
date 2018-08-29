package lesson_5;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private static String FILE_NAME = "dataBase.dat";
    private List<Employee> listEmployee = new ArrayList<>();

    public void writeToFile(List<Employee> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(list);
            System.out.println("Записано в файл: " + FILE_NAME);
        } catch (IOException ex) {
            System.out.println("Запись в файл не удалась!");
            ex.printStackTrace();
        }
    }

    public List<Employee> readFromFile() {
        listEmployee.clear();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listEmployee = (ArrayList<Employee>) objectInputStream.readObject();
            System.out.println("Прочитано из файла: " + FILE_NAME);
        } catch (IOException ex) {
            System.out.println("Чтение из файла не удалось!");
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } catch (ClassCastException ce) {
            System.out.println("Невозможно преобразовать данные из файла!");
        }
        return listEmployee;
    }

    public boolean save(Employee employee) {
        listEmployee.add(employee);
        writeToFile(listEmployee);
        return true;
    }

    public boolean delete(Employee employee) {
        listEmployee.remove(employee);
        writeToFile(listEmployee);
        return true;
    }

    public Employee getByName(String name) {
        Employee employee = null;
        for (Employee list : readFromFile()) {
            if (name != null && list.getName().equals(name)) {
                employee = list;
            }
        }
        return employee;
    }

    public List<Employee> getByJob(String job) {
        List<Employee> listByJob = new LinkedList<>();
        for (Employee list : readFromFile()) {
            if (job != null && list.getJob().equals(job)) {
                listByJob.add(list);
            }
        }
        return listByJob;
    }

    public boolean saveOrUpdate(Employee employee) {
        int count = -1;
        List<Employee> listForUpdate = new ArrayList<>();
        listForUpdate.addAll(readFromFile());
        for (Employee list : listForUpdate) {
            count++;
            if (!getByName(list.name).name.isEmpty()) {
                listForUpdate.set(count, employee);
                writeToFile(listForUpdate);
            } else {
                save(employee);
            }
        }
        return true;
    }

    public boolean changeAllWork(String jobOld, String jobNew) {
        int count = -1;
        List<Employee> listForUpdate = new ArrayList<>();
        listForUpdate.addAll(readFromFile());
        for (Employee list : listForUpdate) {
            count++;
            if (list.getJob().equals(jobOld)) {
                list.setJob(jobNew);
                listForUpdate.set(count, list);
                writeToFile(listForUpdate);
            }
        }
        return true;
    }
}
