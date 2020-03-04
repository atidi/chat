package com.company.controller.admin;

import com.company.dto.RoleDto;
import com.company.dto.UserDto;
import com.company.enums.Role;
import com.company.mapper.impl.UserMapper;
import com.company.service.ImageService;
import com.company.service.UserService;
import com.company.validator.UserDtoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class UserManagementController {

    private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    //TODO impl loging for all app

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserDtoValidator dtoValidator;

    @Autowired
    private UserMapper mapper;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(dtoValidator);
    }

    @GetMapping("/listUser")
    public String listUser(Model model) {
        model.addAttribute("users",mapper.toDtos(userService.list()));
        return "user-list";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user")@Validated UserDto userDto,
                             BindingResult result,
                             @RequestParam("file") MultipartFile file) {
        if(result.hasErrors())
            return "user-manage";
        userDto.setImagePath(imageService.uploadImage(file));
        userService.save(mapper.toEntity(userDto));
        return "redirect:/admin/listUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user")@Validated UserDto userDto,
                             BindingResult result,
                             @RequestParam("file") MultipartFile file) {
        //TODO implement
        userService.save(mapper.toEntity(userDto));
        return "redirect:/admin/listUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/listUser";
    }


    @GetMapping("/createUser")
    public String showCreatePage(Model model) {
        model.addAttribute("user",new UserDto());
        model.addAttribute("allRoles", Arrays.stream(Role.values()).map(RoleDto::new).collect(Collectors.toList()));
        return "user-manage";
    }

    @GetMapping("/updateUser/{id}")
    public String showUpdatePage(@PathVariable("id") Long id,Model model) {
        model.addAttribute("user",mapper.toDto(userService.getById(id)));
        model.addAttribute("allRoles", Arrays.stream(Role.values()).map(RoleDto::new).collect(Collectors.toList()));
        return "user-manage";
    }

}

