package com.artsk.taskmgr.dao.hibernate;

import com.artsk.taskmgr.dao.CategoryDAO;
import com.artsk.taskmgr.dao.UserDAO;
import com.artsk.taskmgr.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1gnite.
 */
@Repository
public class HibernateCategoryDAO extends AbstractHibernateDAO<Category> implements CategoryDAO {

    private UserDAO userDAO;

    @Autowired
    public HibernateCategoryDAO(SessionFactory sessionFactory, UserDAO userDAO) {
        super(sessionFactory, Category.class);
        this.userDAO = userDAO;
    }

    @SuppressWarnings("unchecked")
    public List<Category> getRootCategories(String login) {
        return getSession().createQuery("from Category c where c.owner.login = :login and c.parent is null").setParameter("login", login).list();
    }
}
