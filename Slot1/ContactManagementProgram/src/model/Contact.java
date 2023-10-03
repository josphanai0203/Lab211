package model;

public class Contact {

    private int id;
    private String fullname;
    private String group;
    private String address;
    private String phone;
    private String lastname;
    private String firstname;

    public Contact() {

    }

    public Contact(int id, String fullname, String group, String address, String phone, String lastname, String firstname) {
        this.id = id;
        this.fullname = fullname;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    this.getId(), this.getFullname(),
                    this.getFirstname(), this.getLastname(),
                    this.getGroup(), this.getAddress(), this.getPhone());}
    
}
