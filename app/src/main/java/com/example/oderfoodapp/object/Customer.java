package com.example.oderfoodapp.object;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String address;
    private String phonenumber;
    private int linkimg;

    public Customer(int id, String email, String password, String address, String phonenumber, int linkimg) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.linkimg = linkimg;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(int linkimg) {
        this.linkimg = linkimg;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", linkimg=" + linkimg +
                '}';
    }
}
