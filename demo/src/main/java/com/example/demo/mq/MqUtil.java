package com.example.demo.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

public class MqUtil {

    public static Session getSession(){
        ConnectionFactory connectionFactory = null;
        Session session = null;
        try {
            //1、创建工厂连接对象，需要制定ip和端口号
            connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            //2、使用连接工厂创建一个连接对象
            Connection connection = null;

            connection = connectionFactory.createConnection();

            //3、开启连接
            connection.start();
            //4、使用连接对象创建会话（session）对象
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return session;
    }
}
