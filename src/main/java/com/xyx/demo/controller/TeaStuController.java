package com.xyx.demo.controller;


import com.xyx.demo.entity.TeaStu;
import com.xyx.demo.mapper.TeaStuMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-11-19
 */
@Controller
@RequestMapping("/teaStu")
public class TeaStuController {
    @Autowired
    private TeaStuMapper teaStuMapper;

    @RequestMapping("list")
    @ResponseBody
    public List<TeaStu> findAll(){
        return teaStuMapper.selectList(null);
    }
}

