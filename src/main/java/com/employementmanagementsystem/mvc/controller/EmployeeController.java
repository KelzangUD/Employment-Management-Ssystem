package com.employementmanagementsystem.mvc.controller;

import com.employementmanagementsystem.mvc.dto.DepartmentDto;
import com.employementmanagementsystem.mvc.dto.EmployeeDto;
import com.employementmanagementsystem.mvc.service.DepartmentService;
import com.employementmanagementsystem.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/2/2022.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
    public String addNewEmployee(EmployeeDto employeeDto, HttpServletRequest request, ModelMap map){
        String newEmployee = employeeService.addNewEmployee(employeeDto);
        if(newEmployee.equalsIgnoreCase("SUCCESS")){
            List<EmployeeDto> EmployeeList = employeeService.getEmployeeList(employeeDto);
            map.addAttribute("EmployeeList", (EmployeeList.isEmpty()?"emptyList":EmployeeList));
            return "employee";
        }
        else{
            return "404page";
        }
    }
    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam ("id") Integer id, HttpServletRequest request){
//        System.out.println(id);
        request.setAttribute("employeeDetail", employeeService.getEmployeeDetail(id));
        DepartmentDto departmentDto = new DepartmentDto();
        List<DepartmentDto> departmentList = departmentService.getDepartmentList(departmentDto);
        request.setAttribute("departmentList", departmentList);
        return "editEmployeee";
    }
    @RequestMapping(value = "/edtiEmployeeDetail", method = RequestMethod.POST)
    public String edtiEmployeeDetail(EmployeeDto employeeDto, ModelMap map){
        String page="";
        String editEmployeeDetail = employeeService.editDetails(employeeDto);
        if(editEmployeeDetail.equalsIgnoreCase("SUCCESS")){
            List<EmployeeDto> EmployeeList = employeeService.getEmployeeList(employeeDto);
            map.addAttribute("EmployeeList", (EmployeeList.isEmpty()?"emptyList":EmployeeList));
            page = "employee";
        }
        else{
            page = "404page";
        }
        return page;
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam ("id") int id, ModelMap map, EmployeeDto employeeDto){
        String deleteEmployee = employeeService.deleteEmployee(id);
        List<EmployeeDto> EmployeeList = employeeService.getEmployeeList(employeeDto);
        map.addAttribute("EmployeeList", (EmployeeList.isEmpty()?"emptyList":EmployeeList));
        return (deleteEmployee.equalsIgnoreCase("SUCCESS"))?"employee":"404page";
    }
}
