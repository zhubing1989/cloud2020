package com.zhubing.springcloud.controller;

import com.zhubing.springcloud.entities.CommonResult;
import com.zhubing.springcloud.entities.Payment;
import com.zhubing.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment)
    {
        int result=paymentService.create(payment);
        log.info("*************插入结果"+result);
        if (result>0)
        {
            return new CommonResult(200,"插入结果成功");
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment result=paymentService.getPaymentById(id);
        log.info("*************插入结果"+result);
        if (result!=null)
        {
            return new CommonResult(200,"从数据库获取Payment成功",result);
        }else {
            return new CommonResult(444,"从数据库获取Payment失败");
        }
    }
}
