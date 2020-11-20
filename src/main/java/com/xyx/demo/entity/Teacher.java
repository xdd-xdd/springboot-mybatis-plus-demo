package com.xyx.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xyx
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "TEACHER",resultMap = "baseResult")
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("CLASS")
    private String _class;

    @TableField(exist = false)
    private List<Student> students;

}
