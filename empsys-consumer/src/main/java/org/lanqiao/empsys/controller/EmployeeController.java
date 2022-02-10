package org.lanqiao.empsys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.lanqiao.empsys.domain.Employee;
import org.lanqiao.empsys.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        PageInfo<Employee> pageInfo = employeeService.selectBySelective(employee, pageNum, 5);
        System.out.println("))))))))))))))))))控制层数据"+pageInfo.getPages());
        System.out.println("))))))))))))))))))控制层数据"+pageInfo.getPageSize());
        System.out.println("))))))))))))))))))控制层数据"+pageInfo.getPageNum());
        List<Employee>  employeeList = pageInfo.getList();
        employeeList.forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++");

        //employeeList.forEach(System.out::println);
        //保存数据请请求作用域
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("pageInfo",pageInfo);
        return "employee/list";  //forward to employee/list.html
    }

    @GetMapping("/employees/{empno}")
    public String selectByNo(@PathVariable("empno") Integer empno, Model model) {
        Employee employee = this.employeeService.selectByPrimaryKey(empno);
        model.addAttribute("emp",employee);
        return "employee/updateForm";
    }

    @GetMapping("/employees/delete/{empno}")
    @ResponseBody
    public String delete(@PathVariable("empno") Integer empno){
        System.out.println(empno);
        int flag = employeeService.deleteByPrimaryKey(empno);
        if (flag!=1){
            return "删除失败!!";
        }
        return "删除成功!!";
    }

    @PostMapping("/employees/update")
    public String update(Employee employee,Model model){
        int flag = employeeService.updateByPrimaryKeySelective(employee);
        if (flag==0){
            model.addAttribute("msg","更新失败!!");
        }else {
            model.addAttribute("msg", "更新成功!!");
        }
        return "redirect:/employees/query";
    }
}
