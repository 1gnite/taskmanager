package com.artsk.taskmgr.dao.hibernate;

import com.artsk.taskmgr.dao.UserDAO;
import com.artsk.taskmgr.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1gnite.
 */
@Repository
public class HibernateUserDAO extends AbstractHibernateDAO<User> implements UserDAO {

    @Autowired
    public HibernateUserDAO(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    public User getByLogin(String login) {
        return (User)getSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    public User removeByLogin(String login) {
        User user = getByLogin(login);
        if (user != null) {
            getSession().delete(user);
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>)getSession().createQuery("from User").list();
    }
}
