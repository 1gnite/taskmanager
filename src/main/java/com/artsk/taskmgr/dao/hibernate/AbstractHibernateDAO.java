package com.artsk.taskmgr.dao.hibernate;

import com.artsk.taskmgr.dao.LongIdBasedCrudDAO;
import com.artsk.taskmgr.entity.IdEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by 1gnite.
 */
public abstract class AbstractHibernateDAO<T extends IdEntity> implements LongIdBasedCrudDAO<T> {

    private SessionFactory sessionFactory;
    Class<T> classType;

    public AbstractHibernateDAO(SessionFactory sessionFactory, Class<T> classType) {
        this.sessionFactory = sessionFactory;
        this.classType = classType;
    }

    public boolean save(T entity) {
        if (getSession().save(entity) != null) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T getById(Long id) {
        return (T)getSession().get(classType, id);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void remove(T entity) {
        getSession().delete(entity);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
