package com.tingyun.controller;

import com.tingyun.entity.Emp;
import com.tingyun.service.MySQL.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MySQLController {

    @Autowired
    @Qualifier("mySQLDbcpServiceImpl")
    private MySQLService mySQLDbcpService;

    @Autowired
    @Qualifier("mySQLHikariServiceImpl")
    private MySQLService mySQLHikariService;

    @Autowired
    @Qualifier("mySQLC3p0ServiceImpl")
    private MySQLService mySQLC3p0Service;


    @RequestMapping("/mySQLTest")
    @ResponseBody
    public String mySQLTest(){

        Emp empDbcp = new Emp();
        empDbcp.setName("Dbcp"+new Date().getTime());
        mySQLDbcpService.addEmp(empDbcp);

        Emp empHikari = new Emp();
        empHikari.setName("Hikari"+new Date().getTime());
        mySQLHikariService.addEmp(empHikari);

        Emp empC3p0 = new Emp();
        empC3p0.setName("C3p0"+new Date().getTime());
        mySQLC3p0Service.addEmp(empC3p0);

        mySQLDbcpService.findAllEmp();
        mySQLHikariService.findAllEmp();
        mySQLC3p0Service.findAllEmp();

        mySQLDbcpService.updateEmp();
        mySQLHikariService.updateEmp();
        mySQLC3p0Service.updateEmp();

        mySQLDbcpService.deleteEmp();
        mySQLHikariService.deleteEmp();
        mySQLC3p0Service.deleteEmp();

        return "mySQLTest"+"success";
    }





}
