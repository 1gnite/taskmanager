package com.artsk.taskmgr.controller;

import com.artsk.taskmgr.entity.Category;
import com.artsk.taskmgr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * Created by 1gnite.
 */
@Controller
@RequestMapping(value = {"/tasks"})
public class TasksController {

    private static final int ROOT_CATEGORY_ID = 0;

    private CategoryService categoryService;

    @Autowired
    public TasksController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String managerPage(Principal userPrincipal, Model model) {
        String login = userPrincipal.getName();
        List<Category> categoryList = categoryService.getRootCategories(login);
        model.asMap().put("categoryList", categoryList);
        return "tasks/home";
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.GET)
    public String newCategory(@RequestParam(value = "id", required = false) Long parentId, Model model, Principal userPrincipal) {
        if (parentId != null && categoryService.userHasCategory(parentId, userPrincipal.getName())) {
            model.asMap().put("parentCategory", categoryService.getById(parentId));
        }
        return "tasks/newcategory";
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.POST)
    public String newCategoryProcess(@RequestParam("parentId") Long parentId,
                                     @RequestParam("categoryName") String categoryName,
                                     Principal userPrincipal) {
        String login = userPrincipal.getName();
        if (parentId == ROOT_CATEGORY_ID) {
            categoryService.createRootCategory(login, categoryName);
        } else {
            categoryService.createCategoryOf(parentId, categoryName);
        }
        return "redirect:/tasks";
    }
}
