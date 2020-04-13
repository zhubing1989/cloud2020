package com.zhubing.springcloud.dao;

import com.zhubing.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao
{
    public int create(Payment entity);

    public Payment getPaymentById(@Param("id") Long id);
}
