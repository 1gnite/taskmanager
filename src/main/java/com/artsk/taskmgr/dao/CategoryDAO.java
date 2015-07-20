package com.artsk.taskmgr.dao;

import com.artsk.taskmgr.entity.Category;

import java.util.List;

/**
 * Created by 1gnite.
 */
public interface CategoryDAO extends LongIdBasedCrudDAO<Category> {
    List<Category> getRootCategories(String login);
}
