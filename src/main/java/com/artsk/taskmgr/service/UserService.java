package com.artsk.taskmgr.service;

import com.artsk.taskmgr.entity.User;

import java.util.List;

/**
 * Created by 1gnite.
 */
public interface UserService {
    //TODO Impl
    boolean saveUser(User user);
    User getByLogin(String login);
    User removeByLogin(String login);
    List<User> getAll();
}
