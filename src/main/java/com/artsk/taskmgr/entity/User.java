package com.artsk.taskmgr.entity;

import com.artsk.taskmgr.security.UserRole;

import javax.persistence.*;

/**
 * Created by 1gnite.
 */
@Entity
@Table(name = "users")
public class User extends IdEntity {

    @Column(unique = true, length = 32, nullable = false)
    private String login;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(unique = true, length = 255, nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "ENUM('USER', 'ADMIN') DEFAULT 'USER'")
    private UserRole role;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role=" + getRole() +
                '}';
    }
}
