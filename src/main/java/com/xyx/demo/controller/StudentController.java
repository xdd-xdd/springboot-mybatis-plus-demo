package com.xyx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyx.demo.entity.Student;
import com.xyx.demo.mapper.StudentMapper;
import com.xyx.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xyx
 * @since 2020-11-16
 */
@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    private StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/")
    @ResponseBody
    public boolean add(Student student){
        student.setId(UUID.randomUUID().toString());
        return studentService.save(student);
    }

    @GetMapping("saveAll")
    @ResponseBody
    public boolean saveAll(){
        List<Student> list = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Student student = new Student();
            student.setId(UUID.randomUUID().toString());
            student.setAge(22+i);
            student.setName("xyx"+i);
            list.add(student);
        }
        log.info("循环添加用时{}",System.currentTimeMillis()-start1);
        long start2 = System.currentTimeMillis();
        boolean b = studentService.saveBatch(list);
        log.info("添加结果：{}，用时：{}",b,System.currentTimeMillis() - start2);
        return b;
    }

    @GetMapping("page")
    @ResponseBody
    public IPage<Student> findPage(Integer pageNum,Integer pageSize){
        return studentService.page(new Page<>(pageNum,pageSize),new QueryWrapper<Student>().orderByDesc("age"));
    }

    @GetMapping("pageBy")
    @ResponseBody
    public IPage<Student> findPageBy(Integer pageNum,Integer pageSize,Integer age){
        return studentService.page(new Page<>(pageNum,pageSize),
                new QueryWrapper<Student>().gt("age",age).orderByAsc("age"));
    }

    @DeleteMapping("/")
    @ResponseBody
    public boolean del(){
        int i = studentMapper.delete(new QueryWrapper<Student>().gt("age", 100));
        return i > 0;
    }

    @RequestMapping("findByName")
    @ResponseBody
    public List<Student> findByName(){
        return studentService.list(new QueryWrapper<Student>().lambda().like(Student::getName,"xyx").eq(Student::getAge,"20"));
    }

    @RequestMapping("getOne")
    @ResponseBody
    public Student getOne(String id){
       return studentMapper.selectById(id);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Student> list(){
        return studentMapper.selectList(null);
    }

    @RequestMapping("findByMap")
    @ResponseBody
    public List<Student> findByMap(Integer age,String teaId){
        Map<String, Object> map = new HashMap<>();
        map.put("age",age);
        map.put("teaId",teaId);
        return studentMapper.selectByMap(map);
    }
}

