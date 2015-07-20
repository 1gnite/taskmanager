package com.artsk.taskmgr.controller;

import com.artsk.taskmgr.controller.formobject.UserForm;
import com.artsk.taskmgr.entity.User;
import com.artsk.taskmgr.security.UserRole;
import com.artsk.taskmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by 1gnite.
 */
@Controller
public class AccountController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute(new UserForm());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerProcess(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }
        if (userService.getByLogin(userForm.getLogin()) != null) {
            bindingResult.addError(new ObjectError("alreadyExistError", "Имя аккаунта '" + userForm.getLogin() + "' уже занято"));
            return "/register";
        }
        //TODO Email check: if (userService.getByEmail(user.getEmail()))
        User user = prepareFromForm(userForm);
        userService.saveUser(user);
        return "redirect:/tasks/";
    }

    private User prepareFromForm(UserForm userForm) {
         User user = new User(
                userForm.getLogin(),
                passwordEncoder.encode(userForm.getPassword()),
                userForm.getEmail()
        );
        user.setRole(UserRole.ADMIN);
        return user;
    }
}
