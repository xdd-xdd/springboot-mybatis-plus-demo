package com.xyx.demo.service.impl;

import com.xyx.demo.entity.Student;
import com.xyx.demo.mapper.StudentMapper;
import com.xyx.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyx
 * @since 2020-11-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
