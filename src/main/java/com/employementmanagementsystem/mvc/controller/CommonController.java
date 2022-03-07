package com.employementmanagementsystem.mvc.controller;

import com.employementmanagementsystem.mvc.dto.*;
import com.employementmanagementsystem.mvc.dto.weather.CurrentWeatherDto;
import com.employementmanagementsystem.mvc.service.CommonService;
import com.employementmanagementsystem.mvc.service.DepartmentService;
import com.employementmanagementsystem.mvc.service.EmployeeService;
import com.employementmanagementsystem.mvc.service.WeatherService;
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
    CommonService commonService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    WeatherService weatherService;
    String location ="thimphu";
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String printWelcome() {
		return "login";
	}

    @RequestMapping(value = "/validate",method = {RequestMethod.POST,RequestMethod.GET})
    public String home(@RequestParam ("userId") String userId, @RequestParam ("password") String password, HttpServletRequest request){
//        System.out.println(userId);
//        System.out.println(password);
        UserDto userDto = new UserDto();
        String actionForward="";
        String user="";
        try{
            ApiDto apiDto = new ApiDto();
            userDto.setUserId(userId);
            userDto.setPassword(password);
            String role = commonService.validateUser(userDto);
            apiDto = weatherService.getCurrentWeatherCondition(location);
            Integer employeeCount = employeeService.getCount();
            request.setAttribute("employeeCount", employeeCount);
            request.setAttribute("weather",apiDto);
            actionForward = (role.equalsIgnoreCase("Invalid User"))?"redirect:/":"home";
        }
        catch (Exception ex){
            System.out.print(ex);
        }
        return actionForward;
    }
    @RequestMapping(value = "/loadPage", method = RequestMethod.GET)
    public String loadPage(@RequestParam ("page") String page, EmployeeDto employeeDto, ModelMap map, HttpServletRequest request){
        if(page.equalsIgnoreCase("employee")){
            List<EmployeeDto> EmployeeList = employeeService.getEmployeeList(employeeDto);
            map.addAttribute("EmployeeList", (EmployeeList.isEmpty()?"emptyList":EmployeeList));

        }
        else if(page.equalsIgnoreCase("addNewEmployee")){
            DepartmentDto departmentDto = new DepartmentDto();
            List<DepartmentDto> departmentList = departmentService.getDepartmentList(departmentDto);
            request.setAttribute("departmentList", departmentList);
        }
        return "/"+page;
    }
}