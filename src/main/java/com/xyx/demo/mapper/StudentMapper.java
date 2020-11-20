package com.xyx.demo.mapper;

import com.xyx.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xyx
 * @since 2020-11-16
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> findByTeaId(String teaId);
}
