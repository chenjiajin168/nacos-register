package com.chenjiajin.service.impl;

import com.chenjiajin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    // 1.注入DiscoveryClient对象
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public void get() {

        // 当使用了Nacos之后,本地服务会在Nacos种获取一份配置实例的信息
        // 调用getInstances方法 获取本地的那份实例信息,可能同名的服务有多个(集群) 返回的是集合
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        ServiceInstance serviceInstance = instances.get(0);

        // 可以手动弄负载均衡
        //int count = new Random().nextInt(instances.size());
        //ServiceInstance serviceInstance = instances.get(count);

        // 3.实例包含服务的信息,包括url和端口 发起http请求
        String returnStr = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/get?id=" + 1, String.class);


        // 使用Ribbon之后
        //String returnStr = restTemplate.getForObject("http://product-service/get?id=" + 1, String.class);

    }


}

