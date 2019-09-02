package com.car.controller;

import com.car.common.BaseResponse;
import com.car.common.CodeConstant;
import com.car.domain.User;
import com.car.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/9/2 11:22
 * @Modified By：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/read")
    public BaseResponse read(@RequestParam("userNum") Integer userNum){
        User user = userService.read(userNum);
        BaseResponse baseResponse = new BaseResponse(CodeConstant.SUCCESS);
        baseResponse.setData(user);
        return baseResponse;
    }
}
