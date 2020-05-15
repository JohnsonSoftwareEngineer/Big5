package com.johnsondev.big5.dbModels;

public class User {

    private String name;
    private String email;
    private String password;
    private String phone;
    private int block_1;
    private int block_2;
    private int block_3;
    private int block_4;
    private int block_5;


    public User(String name, String email, String password, String phone, int block_1, int block_2, int block_3, int block_4, int block_5) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.block_1 = block_1;
        this.block_2 = block_2;
        this.block_3 = block_3;
        this.block_4 = block_4;
        this.block_5 = block_5;
    }

    public User(String name, String email, String password, String phone, int block_1, int block_2) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.block_1 = block_1;
        this.block_2 = block_2;
    }


    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBlock_1() {
        return block_1;
    }

    public void setBlock_1(int block_1) {
        this.block_1 = block_1;
    }

    public int getBlock_2() {
        return block_2;
    }

    public void setBlock_2(int block_2) {
        this.block_2 = block_2;
    }

    public int getBlock_3() {
        return block_3;
    }

    public void setBlock_3(int block_3) {
        this.block_3 = block_3;
    }

    public int getBlock_4() {
        return block_4;
    }

    public void setBlock_4(int block_4) {
        this.block_4 = block_4;
    }

    public int getBlock_5() {
        return block_5;
    }

    public void setBlock_5(int block_5) {
        this.block_5 = block_5;
    }
}
