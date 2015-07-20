package com.artsk.taskmgr.service.hibernate;

import com.artsk.taskmgr.dao.CategoryDAO;
import com.artsk.taskmgr.entity.Category;
import com.artsk.taskmgr.entity.User;
import com.artsk.taskmgr.service.CategoryService;
import com.artsk.taskmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by 1gnite.
 */
@Service
@Transactional
public class HibernateCategoryService implements CategoryService {

    private CategoryDAO categoryDAO;

    private UserService userService;

    @Autowired
    public HibernateCategoryService(CategoryDAO categoryDAO, UserService userService) {
        this.categoryDAO = categoryDAO;
        this.userService = userService;
    }

    public List<Category> getRootCategories(String login) {
        return categoryDAO.getRootCategories(login);
    }

    public boolean createRootCategory(String login, String categoryName) {
        User user = userService.getByLogin(login);
        if (user == null) {
            return false;
        }
        List<Category> categories = getRootCategories(login);
        for (Category c : categories) {
            if (c.getTitle().equalsIgnoreCase(categoryName)) {
                return false;
            }
        }
        Category category = new Category(user, categoryName, null);
        categoryDAO.save(category);
        return true;
    }

    public boolean createCategoryOf(Long parentId, String categoryName) {
        Category parent = categoryDAO.getById(parentId);
        if (parent == null) {
            return false;
        }
        List<Category> childs = parent.getChilds();
        if (containsName(childs, categoryName)) {
            return false;
        }
        Category newCategory = new Category(parent.getOwner(), categoryName, parent);
        return categoryDAO.save(newCategory);
    }

    public Category getById(Long id) {
        return categoryDAO.getById(id);
    }

    public boolean userHasCategory(Long categoryId, String login) {
        Category category = getById(categoryId);
        return Objects.equals(category.getOwner().getLogin(), login);
    }

    private boolean containsName(Collection<Category> categories, String name) {
        for (Category c : categories) {
            if (c.getTitle().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
