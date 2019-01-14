package cn.lovehao.service.impl;

import cn.lovehao.dao.StudentDao;
import cn.lovehao.entity.Student;
import cn.lovehao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }


}
