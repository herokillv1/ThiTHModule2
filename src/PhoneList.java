import java.io.Serializable;

public class PhoneList implements Serializable {
    private String number;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String Email;

    public PhoneList(){
    }

    public PhoneList(String number, String group, String name, String gender, String address, String dob, String email) {
        this.number = number;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        Email = email;
    }

    public PhoneList(String number, String group, String name, String gender, String address) {
        this.number = number;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
