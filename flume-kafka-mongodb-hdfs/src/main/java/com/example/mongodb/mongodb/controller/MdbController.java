package com.example.mongodb.mongodb.controller;

import com.example.mongodb.mongodb.dao.CustomerRepository;
import com.example.mongodb.mongodb.dto.Customer;
import com.example.mongodb.mongodb.kafkalogs.SampleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@RestController
@EnableAutoConfiguration
public class MdbController {

    public static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleController kafka;


    @Autowired
    private CustomerRepository repository;


    @RequestMapping(value="/send", method = RequestMethod.GET ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String mongodb() {


        repository.deleteAll();

        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

//        System.out.println("=================================");
        List<Customer> all = repository.findAll();
        for (Customer customer : all) {
            logger.info("调度开启");
            kafka.kafkaProducer(customer.toString());
            logger.info("调度结束");
//            System.out.println(customer);
        }

        return "success";
    }

}