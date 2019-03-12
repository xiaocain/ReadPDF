package com.jcex.test.web;

import com.jcex.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@Api(value = "用户测试信息", tags = {"用户测试相关接口"})//swagger控制器说明注解
public class jcextest {
    private static final Logger logger=Logger.getLogger(jcextest.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @ApiOperation(value = "getUser接口",notes = "根据name来获取customerreferencenumber")
    @ApiImplicitParam(value = "姓名",name = "name",required = true,dataType = "String")
    @RequestMapping(value = "/user/{name}",method = RequestMethod.GET)
    public String getUserInfo(@PathVariable(name = "name")String name, ModelMap modelMap){
//        User user= userService.getUser(name);
        logger.info("输入参数...."+name);
        String selectcustomerreferencenumber = userService.selectcustomerreferencenumber(name);
        return selectcustomerreferencenumber.toString();
    }
    @RequestMapping(value = "/cut/{name}",method = RequestMethod.GET)
    public String getreferenceNumber(@PathVariable(name = "name")String name, ModelMap modelMap){
//        User user= userService.getUser(name);
        logger.info("输入参数...."+name);
        String selectcustomerid = userService.selectcustomerid(name);
        logger.info("发s参数...."+name);
        return selectcustomerid.toString();

        
    }

   
}
