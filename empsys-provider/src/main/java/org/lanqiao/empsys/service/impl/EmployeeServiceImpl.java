package org.lanqiao.empsys.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import org.lanqiao.empsys.dao.EmployeeMapper;
import org.lanqiao.empsys.domain.Employee;
import org.lanqiao.empsys.service.EmployeeService;
import org.lanqiao.empsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(interfaceClass = EmployeeService.class,version = "1.0" ,timeout = 50000)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectBySelective(Employee record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return employeeMapper.selectBySelective(record,pageNum,pageSize);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }
}
