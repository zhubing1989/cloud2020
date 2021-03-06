package com.zhubing.springcloud.controller;

import com.zhubing.springcloud.entities.CommonResult;
import com.zhubing.springcloud.entities.Payment;
import com.zhubing.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController
{

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment)
    {
        int result=paymentService.create(payment);
        log.info("*************插入结果"+result);
        if (result>0)
        {
            return new CommonResult(200,"插入结果成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment result=paymentService.getPaymentById(id);
        log.info("*************获取结果"+result);
        if (result!=null)
        {
            return new CommonResult(200,"从数据库获取Payment成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"从数据库获取Payment失败");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for (String service:services)
        {
            log.info("**********service:"+service);
        }
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances)
        {
            log.info("serviceId:"+instance.getServiceId()+"\t"+"HostName:"+instance.getHost()+"\t"+"Port:"+instance.getPort()+"\t"+"Uri:"+instance.getUri());
        }
        return discoveryClient;
    }
}
