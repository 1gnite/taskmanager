package com.artsk.taskmgr.dao;

import com.artsk.taskmgr.entity.User;

import java.util.List;

/**
 * Created by 1gnite.
 */
public interface UserDAO extends LongIdBasedCrudDAO<User> {
    User getByLogin(String login);
    User removeByLogin(String login);
    List<User> getAll();
}
