package com.zhubing.springcloud.service;

import com.zhubing.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService
{
    public int create(Payment entity);

    public Payment getPaymentById(Long id);
}
