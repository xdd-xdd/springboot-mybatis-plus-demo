package com.xyx.demo.controller;


import com.xyx.demo.entity.Teacher;
import com.xyx.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xyx
 * @since 2020-11-17
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/")
    @ResponseBody
    public boolean add(Teacher teacher){
        int i = teacherMapper.insert(teacher);
        return i > 0;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Teacher> list(){
        return teacherMapper.selectList(null);
    }
}

