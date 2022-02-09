package org.lanqiao.empsys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements Serializable {
    private static final long serialVersionUID = 3713075044297154304L;
    private Integer empno;

    private String ename;
    private String mname;
    private String dname;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Double sal;

    private Double comm;

    private Integer deptno;


}