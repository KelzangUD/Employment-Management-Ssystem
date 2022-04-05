package com.employementmanagementsystem.mvc.controller;


import com.employementmanagementsystem.mvc.dto.RegistDto;
import com.employementmanagementsystem.mvc.dto.UserDto;
import com.employementmanagementsystem.mvc.service.RegistrationService;
import com.employementmanagementsystem.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class CommonController {
    @Autowired
    UserService userService;
    @Autowired
    RegistrationService registrationService;

	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String printWelcome() {
		return "login";
	}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(UserDto userDto){
//        System.out.println(userDto.getUserId());
//        System.out.println(userDto.getPassword());
//        String userId = userDto.getUserId();
//        String password = userDto.getPassword();
        String userType = userService.getUserDetail(userDto);
        String page = userType.equalsIgnoreCase("Valid")?"home":"404page";
        return page;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(RegistDto registDto) {
        String registrationType = registrationService.getRegistration(registDto);
        String page = registrationType.equalsIgnoreCase("Valid") ? "employee" : "404page";
        return page;
    }

}