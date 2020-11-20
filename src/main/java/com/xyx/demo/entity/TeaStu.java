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
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "TEA_STU",resultMap = "BaseResult")
public class TeaStu implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("ID")
    private String id;

    @TableField("TEAID")
    private String teaId;

    @TableField("STUID")
    private String stuId;

    @TableField(exist = false)
    private List<Teacher> teachers;

    @TableField(exist = false)
    private List<Student> students;

}
