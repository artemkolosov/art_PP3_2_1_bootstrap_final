package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showMainAdminPage(Model model, Principal principal) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roleUser", roleService.getRoleByName("ROLE_USER"));
        model.addAttribute("roleAdmin", roleService.getRoleByName("ROLE_ADMIN"));
        model.addAttribute("currentUser", userService.getUserByName(principal.getName()));
        return "main";
    }

    @GetMapping("/{id}")
    public String showUserInfoPage(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roleUser", roleService.getRoleByName("ROLE_USER"));
        model.addAttribute("roleAdmin", roleService.getRoleByName("ROLE_ADMIN"));
        model.addAttribute("currentUser", userService.getUserByName(principal.getName()));
        return "user";
    }

    @GetMapping("/createUser")
    public String showCreateUserPage(Model model, Principal principal) {
        model.addAttribute("user", new User());
        model.addAttribute("currentUser", userService.getUserByName(principal.getName()));
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roleUser", roleService.getRoleByName("ROLE_USER"));
        model.addAttribute("roleAdmin", roleService.getRoleByName("ROLE_ADMIN"));

        return "createUser";
    }

    @GetMapping("/{id}/edit")
    public String showEditUserPage(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roleUser", roleService.getRoleByName("ROLE_USER"));
        model.addAttribute("roleAdmin", roleService.getRoleByName("ROLE_ADMIN"));
        model.addAttribute("currentUser", userService.getUserByName(principal.getName()));
        model.addAttribute("userList", userService.getAllUsers());

        return "editUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUserById(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}