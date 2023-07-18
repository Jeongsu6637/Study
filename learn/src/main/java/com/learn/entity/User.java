package com.learn.entity;

public class User {
    private int seq;
    private String id;
    private String password;
    private String name;
    private String birth_date;
    private String phone;
    private String address;
    private String email;
    private int deposit;

    public User(int seq, String id, String password, String name, String birth_date, String phone, String address, String email, int deposit) {
        this.seq = seq;
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.deposit = deposit;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
}
