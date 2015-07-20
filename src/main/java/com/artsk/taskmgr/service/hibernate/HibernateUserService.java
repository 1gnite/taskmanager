package com.artsk.taskmgr.service.hibernate;

import com.artsk.taskmgr.dao.UserDAO;
import com.artsk.taskmgr.entity.User;
import com.artsk.taskmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 1gnite.
 */
@Service
@Transactional
public class HibernateUserService implements UserService {

    private UserDAO userDAO;

    @Autowired
    public HibernateUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean saveUser(User user) {
        if (user.getId() == null) {
            userDAO.save(user);
        }
        return false;
    }

    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User removeByLogin(String login) {
        return userDAO.removeByLogin(login);
    }
}
