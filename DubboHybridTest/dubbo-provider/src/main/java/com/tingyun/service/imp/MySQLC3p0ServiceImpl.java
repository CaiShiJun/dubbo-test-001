package com.tingyun.service.imp;

import com.tingyun.dao.MySQLMapper;
import com.tingyun.entity.Emp;
import com.tingyun.service.MySQL.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLC3p0ServiceImpl implements MySQLService {

    @Autowired
    private MySQLMapper mySQLMapper;

    @Override
    public int addEmp(Emp emp) {
        return mySQLMapper.addEmp(emp);
    }

    @Override
    public int deleteEmp() {
        return mySQLMapper.deleteEmp();
    }

    @Override
    public int updateEmp() {
        return mySQLMapper.updateEmp();
    }

    @Override
    public List<Emp> findAllEmp() {
        return mySQLMapper.findAllEmp();
    }
}
