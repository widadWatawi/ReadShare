package com.example.readshare;

import java.util.Date;

public class User {
    private String id;

    private Date TIMESTAMP;
    private String name;

    private String lastName;

    private String email;

    private String login;

    private String password;

    private Boolean IS_ACTIF;

    private Boolean IS_ROOT;

    private Date LAST_PASS_CHANGED_DATE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getIS_ACTIF() {
        return IS_ACTIF;
    }

    public void setIS_ACTIF(Boolean IS_ACTIF) {
        this.IS_ACTIF = IS_ACTIF;
    }

    public Boolean getIS_ROOT() {
        return IS_ROOT;
    }

    public void setIS_ROOT(Boolean IS_ROOT) {
        this.IS_ROOT = IS_ROOT;
    }

    public Date getLAST_PASS_CHANGED_DATE() {
        return LAST_PASS_CHANGED_DATE;
    }

    public void setLAST_PASS_CHANGED_DATE(Date LAST_PASS_CHANGED_DATE) {
        this.LAST_PASS_CHANGED_DATE = LAST_PASS_CHANGED_DATE;
    }
}
