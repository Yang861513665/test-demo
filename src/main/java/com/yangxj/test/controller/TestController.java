package com.yangxj.test.controller;

import com.yangxj.test.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangxj
 * @date 2019-08-23 14:20
 */
@Controller
public class TestController {
    @RequestMapping("receive")
    public Person receive(Person person){
        return person;
    }
    @RequestMapping("index")
    public String index(ModelMap modelMap,String name)
    {
        modelMap.put("name",name);
        return "index";
    }
    @RequestMapping("index2")
    public String index2(ModelMap modelMap,String name)
    {
        modelMap.put("name",name);
        return "index2";
    }
}
