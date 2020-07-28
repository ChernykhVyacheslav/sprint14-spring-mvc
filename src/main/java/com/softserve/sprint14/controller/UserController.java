package com.softserve.sprint14.controller;

import com.softserve.sprint14.entity.Marathon;
import com.softserve.sprint14.entity.User;
import com.softserve.sprint14.service.MarathonService;
import com.softserve.sprint14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class UserController {

    private MarathonService marathonService;

    private UserService userService;

    @Autowired
    public UserController(MarathonService marathonService, UserService userService) {
        this.marathonService = marathonService;
        this.userService = userService;
    }

    @GetMapping("/{marathonId}/add")
    public String addUsersForm(@RequestParam("marathonId") Long theId,
                               Model theModel, @PathVariable Long marathonId) {

        Marathon theMarathon = marathonService.getMarathonById(marathonId);

        theModel.addAttribute("marathon", theMarathon);

        theModel.addAttribute("users", userService.getAll());

        return "marathons/add-students-form";
    }

    @PostMapping("/save")
    public String addUserToMarathon(
            @ModelAttribute("user") @Valid User user, Marathon marathon,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "students/students-form";
        } else {
            userService.addUserToMarathon(user, marathon);
            return "redirect:/students";
        }
    }
}
