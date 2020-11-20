package com.xyx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "STUDENT",resultMap = "baseResult")
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Integer age;

    @TableField("TEAID")
    private String teaId;

    @TableField(exist = false)
    private List<Teacher> teachers;
}
