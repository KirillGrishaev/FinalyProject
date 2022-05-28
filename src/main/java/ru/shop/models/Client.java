package ru.shop.models;

public class Client {
    private int id;
    private String surName;
    private String name;
    private String login;
    private String password;
    public Client(){}
    public Client (int id, String surName, String name, String login, String password){
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.login = login;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
