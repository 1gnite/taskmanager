package com.artsk.taskmgr.controller.formobject;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by 1gnite.
 */
public class UserForm {

    @Size(min = 3, max = 20, message = "Допустимая длина логина от 3 до 20 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Допустимы алфавитные буквы без пробелов")
    private String login;

    @Size(min = 4, max = 20, message = "Допустимая длина пароля от 4 до 20 символов")
    private String password;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Недопустимый email адрес")
    private String email;

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
}
