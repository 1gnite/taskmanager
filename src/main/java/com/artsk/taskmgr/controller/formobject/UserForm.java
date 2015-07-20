package com.artsk.taskmgr.controller.formobject;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by 1gnite.
 */
public class UserForm {

    @Size(min = 3, max = 20, message = "���������� ����� ������ �� 3 �� 20 ��������")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "��������� ���������� ����� ��� ��������")
    private String login;

    @Size(min = 4, max = 20, message = "���������� ����� ������ �� 4 �� 20 ��������")
    private String password;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "������������ email �����")
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
