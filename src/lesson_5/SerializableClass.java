package lesson_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableClass {
    File file = new File("DataOutFile.dat");
    List<Employee> listEmployee = new ArrayList<>();

    public boolean DataToFile(List<Employee> list) {
        try {
            if (file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWr = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWr);
            for (int i = 0; i <= list.size() - 1; i++) {
                bufferedWriter.write(list.get(i).getName());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write((list.get(i).getAge()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(list.get(i).getJob());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write((list.get(i).getSalary()));
                bufferedWriter.write(System.lineSeparator());
            }
            bufferedWriter.close();
            System.out.println("Файл записан!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public List<Employee> fileToData() {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileStream = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileStream);
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                list.add(strLine);
            }
        } catch (IOException ex) {
            System.out.println("Файл не найден!");
            ex.printStackTrace();
        }
        for (int i = 0; i <= list.size() - 1; ) {
            Employee employee = new Employee();
            employee.setName(list.get(i++));
            employee.setAge(list.get(i++));
            employee.setJob(list.get(i++));
            employee.setSalary(list.get(i++));
            listEmployee.add(employee);
            System.out.println(listEmployee);
        }
        System.out.println(listEmployee);
        return listEmployee;
    }
}