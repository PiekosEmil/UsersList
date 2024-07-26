package com.emilpiekos.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
    private UsersList usersList;

    public UsersController(UsersList usersList) {
        this.usersList = usersList;
    }

    @RequestMapping("/users.html")
    @ResponseBody
    public String getUsers() {
        String result = "";
        for (User user : usersList.getUsers()) {
            result += user.toString() + "<br/>";
        }
        return result + "<p><a href=\"/\" Dodaj kolejnego użytkownika>Dodaj kolejnego użytkownika</a></p>";
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam(name = "imie") String firstName, @RequestParam(name = "nazwisko") String lastName, @RequestParam(name = "wiek", required = false, defaultValue = "0") Integer age) {
        if (!firstName.isEmpty()) {
            User user = new User(firstName, lastName, age);
            usersList.add(user);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}
