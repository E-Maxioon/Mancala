package sample;

import java.io.Serializable;
import java.util.Date;

public abstract class User implements Serializable {

    protected static final long serialVersionUID = 1L;
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected Date lastLogin;
    protected String profilePic = "avatar1.png";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
