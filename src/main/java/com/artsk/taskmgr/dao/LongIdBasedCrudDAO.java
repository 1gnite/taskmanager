package com.artsk.taskmgr.dao;

import com.artsk.taskmgr.entity.IdEntity;

/**
 * Created by 1gnite.
 */
public interface LongIdBasedCrudDAO<T extends IdEntity> {
    boolean save(T entity);
    T getById(Long id);
    void update(T entity);
    void remove(T entity);
}
