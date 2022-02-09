package org.lanqiao.empsys.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.lanqiao.empsys.domain.Employee;
import org.lanqiao.empsys.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

    @DubboReference(interfaceClass = EmployeeService.class,version = "1.0")
    private EmployeeService employeeService;

    @GetMapping("/employees/query")
    public String queryAll(Employee employee, Integer pageNum, Model model, HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
            //保留查询条件
            session.setAttribute("selective",employee);
        } else {
            employee = (Employee) session.getAttribute("selective");
        }
        //查询
        List<Employee> employeeList = employeeService.selectBySelective(employee, pageNum, 5);
        System.out.println("++++++++++++++++++++++++++++++");
        employeeList.forEach(System.out::println);
        //保存数据请请求作用域
        model.addAttribute("employeeList", employeeList);
        return "employee/list";  //forward to employee/list.html
    }

    @GetMapping("/employees/{empno}")
    public String selectByNo(@PathVariable("empno") Integer empno, Model model) {
        Employee employee = this.employeeService.selectByPrimaryKey(empno);
        model.addAttribute("emp",employee);
        return "employee/updateForm";
    }
}
