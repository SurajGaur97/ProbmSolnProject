package programsProblem.practice.web;

public class Student {
    int id;
    String name;
    StudentAddress address;

    public Student() {

    }

    public Student(int id, String name, StudentAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
