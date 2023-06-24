package main.java.dto;

import java.io.Serializable;

public class Student implements Serializable {
    private String _user;
    private String _pass;
    private Boolean status;
    private Boolean firstLogin;

    public Student() {
    }

    public Student(String _user, String _pass, Boolean status, Boolean firstLogin) {
        this._user = _user;
        this._pass = _pass;
        this.status = status;
        this.firstLogin = firstLogin;
    }
    public Student(String _user, String _pass, Boolean status) {
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

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getFirstLogin() {
        return this.firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public String toString() {
        return
                "User: '" + getUser() + "'" + "," + "\n" +
                        "Password: '" + getPass() + "'" + "," + "\n" +
                        "Status: '" + getStatus() + "'" + "," + "\n" +
                        "FirstLogin: '" + getFirstLogin() + "'" + "," + "\n";
    }

}