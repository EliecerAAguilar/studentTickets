package main.java.dto;

import java.io.Serializable;

public class Student implements Serializable {
    private String _user;
    private String _pass;
    private boolean status;
    private boolean firstLogin;

    public Student() {
    }

    public Student(String _user, String _pass, boolean status, boolean firstLogin) {
        this._user = _user;
        this._pass = _pass;
        this.status = status;
        this.firstLogin = firstLogin;
    }
    public Student(String _user, String _pass, boolean status) {
        this._user = _user;
        this._pass = _pass;
        this.status = status;
        this.firstLogin = true;
    }

    public String getUser() {
        return this._user;
    }

    public void setUser(String _user) {
        this._user = _user;
    }

    public String getPass() {
        return this._pass;
    }

    public void setPass(String _pass) {
        this._pass = _pass;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getFirstLogin() {
        return this.firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public String toString() {
        return "Username: " + getUser() + "\n"
                + "Password: " + getPass() + "\n"
                + "Status: " + getStatus() + "\n"
                + "First Login: " + getFirstLogin() + "\n";
    }


}