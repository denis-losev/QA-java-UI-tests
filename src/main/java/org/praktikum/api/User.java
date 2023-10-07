package org.praktikum.api;

public class User {
    private String email = "123666098te57-u5er69@yan4ex.ru",
            password = "p@sSw0Rd",
            name = "123666098te57-u5er69";

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User() {
        setEmail(email);
        setPassword(password);
        setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
