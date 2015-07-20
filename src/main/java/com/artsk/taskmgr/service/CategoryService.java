package com.artsk.taskmgr.service;

import com.artsk.taskmgr.entity.Category;

import java.util.List;

/**
 * Created by 1gnite.
 */
public interface CategoryService {
    boolean createRootCategory(String login, String categoryName);
    boolean createCategoryOf(Long parentId, String categoryName);
    Category getById(Long id);
    boolean userHasCategory(Long categoryId, String login);
    List<Category> getRootCategories(String login);
}
