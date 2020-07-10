package com.example.demo.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMqProducer {

    public static void main(String[] args) throws Exception {
        testMQProducerQueue();
    }
    public static  void testMQProducerQueue() throws Exception{
        Session session = MqUtil.getSession();
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //8、发送消息
        producer.send(textMessage);
        //9、关闭资源
        producer.close();
        session.close();
    }
}
