package lesson_15.pojo;

public class Student {
    private int id;
    private String name;
    private String familyName;
    private int age;
    private String contact;
    private City city;
    private String groupName;

    public Student() {
    }

    public Student(int id, String name, String familyName, int age, String contact, City city, String groupName) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.contact = contact;
        this.city = city;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", city=" + city +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
