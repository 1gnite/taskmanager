package com.artsk.taskmgr.controller;

import com.artsk.taskmgr.entity.User;
import com.artsk.taskmgr.security.UserRole;
import com.artsk.taskmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by 1gnite.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/users"})
    public String adminPage(Model model) {
        List<User> userList = userService.getAll();
        model.asMap().put("userList", userList);

        return "/admin/home";
    }

    @RequestMapping(value = "/users/{login}")
    public String removeUser(@PathVariable("login") String login,
                             @RequestParam Map<String, String> allRequestParams) {
        if (allRequestParams.containsKey("delete") && userService.getByLogin(login).getRole() != UserRole.ADMIN) {
            userService.removeByLogin(login);
        }
        return "redirect:/admin/";
    }
}
