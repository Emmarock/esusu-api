package com.emmarock.model;




import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by babajide.apata on 1/31/2017.
 */
public class SecurityUser {
    private String id;
    private String username;
    private String password;

    public SecurityUser() {
    }

    public SecurityUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityUser that = (SecurityUser) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
