package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.exception.MismatchException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping
@Validated
@CrossOrigin
public class controller {

    private final UserService userService;

    public controller(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) throws UserExistException {
        userService.register(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("username")  @NotNull(message = "username illegal")
                          @Size(min=5,max = 12,message = "username illegal") String username,
                      @RequestParam("password") @Pattern(regexp = "^[0-9a-zA-Z_]{5,12}",message = "password illegal") String password)
                        throws MismatchException {
        return userService.login(username,password);
    }


}
