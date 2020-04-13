package com.zhubing.springcloud.impl;

import com.zhubing.springcloud.dao.PaymentDao;
import com.zhubing.springcloud.entities.Payment;
import com.zhubing.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment entity)
    {
        return paymentDao.create(entity);
    }

    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
