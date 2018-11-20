package com.home.demo.com.home.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


// RestController注释使项目支持REST请求
@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
class UserController
{
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);


    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    //通过RequestMethod.POST表示请求需要时POST方式
    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value="userName") String userName)
    {
        return "Hello" + userName;
    }

    //在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体，
    //目前主流的请求报文也都是JSON格式了，使用该注解就能够获取整个JSON报文体作为入参，使用JSON解析工具解析后获取具体参数

    @RequestMapping(value = "/getUserByJson",method = RequestMethod.POST)
    String getUserByJSON(@RequestBody String data)
    {
        logger.info("info Json is "+ data);
        logger.error("error Json is "+ data);
        return "Json is " + data;
    }


}
