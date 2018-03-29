package sample;

public class Student {
    private int ID;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public Student(int ID, String name, String surname, String phone, String email) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
