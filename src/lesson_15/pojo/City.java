package lesson_15.pojo;

public class City {
    private int id;
    private String city;
    private int citizens;

    public City(int id, String city, int citizens) {
        this.id = id;
        this.city = city;
        this.citizens = citizens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", citizens=" + citizens +
                '}';
    }
}
