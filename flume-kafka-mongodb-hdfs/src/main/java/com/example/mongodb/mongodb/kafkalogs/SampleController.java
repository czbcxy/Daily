package com.example.mongodb.mongodb.kafkalogs;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Controller
public class SampleController  {
    public static Logger LOG = LoggerFactory.getLogger(SampleController.class);

    public static String topic = "test";
    public static String key = "key";

    @Autowired
    private KafkaTemplate<String, String> template;

    /**
     * 生产者
     *
     * @param topic
     * @param key
     * @param data
     */
    public void kafkaProducer(String topic, String key, String data) {
        template.send(topic, key, data);
    }

    public void kafkaProducer(String data) {
        template.send(topic, key, data);
    }

    /**
     * 消费者
     *
     * @param data
     */
    @KafkaListener(topics={"test"})
    public void onMessage(ConsumerRecord<String, String> data) {
        LOG.info("=============kafkaConsumer开始消费=============");
        String topic = data.topic();
        String key = data.key();
        String value = data.value();
        long offset = data.offset();
        int partition = data.partition();
        LOG.info("-------------topic:" + topic);
        LOG.info("-------------value:" + value);
        LOG.info("-------------key:" + key);
        LOG.info("-------------offset:" + offset);
        LOG.info("-------------partition:" + partition);
        LOG.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }
}
