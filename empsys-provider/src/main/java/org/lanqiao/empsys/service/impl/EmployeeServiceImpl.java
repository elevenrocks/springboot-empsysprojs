package org.lanqiao.empsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.lanqiao.empsys.dao.EmployeeMapper;
import org.lanqiao.empsys.domain.Employee;
import org.lanqiao.empsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

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
    @Cacheable(value = "PageInfo",key = "{#result,#record,#pageNum,#pageSize}")
    public PageInfo<Employee> selectBySelective(Employee record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> employees = employeeMapper.selectBySelective(record);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        System.out.println("------------业务层分页"+pageInfo.getPageNum());
        System.out.println("------------业务层分页"+pageInfo.getPageSize());
        System.out.println("------------业务层分页"+pageInfo.getPages());
        return pageInfo;
    }

    @Override
    @CacheEvict(value = "PageInfo",beforeInvocation = true)
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }
}
