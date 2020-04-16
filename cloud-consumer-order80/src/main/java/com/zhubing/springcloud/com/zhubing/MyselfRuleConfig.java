package com.zhubing.springcloud.com.zhubing;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRuleConfig {
    @Bean
    public IRule getRule()
    {
        return new RandomRule();
    }
}
