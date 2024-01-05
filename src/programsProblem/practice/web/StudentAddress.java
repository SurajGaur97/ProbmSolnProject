package programsProblem.practice.web;

public class StudentAddress extends Student {
    int id;
    String district;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "id=" + id +
                ", district='" + district + '\'' +
                '}';
    }
}
