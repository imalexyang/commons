package com.platform.web.common.mp;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.platform.web.common.logging.UnifyLogger;
import com.platform.web.common.pro.Pro;

public class LogCollection {
	
	//mq配置
	private static String host= Pro.getString("mq.url");
	private static String alarmQueue = Pro.getString("mq.queue");
//	private static String alarmErrorId = "mq";
	private static String ENVIRONMENT_FORMAL = "prod";
	private static String ENVIRONMENT_TEST = "test";
	private static String ENVIRONMENT_DEV = "dev";
	
	/**
	 * 收集日志并通知告警模块
	 * @param errorId
	 * @param msg
	 */
	public static void alarm(String errorId,String msg){
		
		//通知告警模块
		ActiveMQConnectionFactory connectionFactory= new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, host);
		Connection connection= null;
		Session session= null;
		MessageProducer producer;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			
			session= connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(alarmQueue);
			
			producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			
			//消息包含errorCode
			MapMessage mapMessage = session.createMapMessage();
	        //设置错误编码
			mapMessage.setString("errorCode", errorId);
			//设置环境
			if(Integer.parseInt(Pro.getString("log.enviro"))==1)
				mapMessage.setString("enviro", ENVIRONMENT_FORMAL);
			if(Integer.parseInt(Pro.getString("log.enviro"))==2)
				mapMessage.setString("enviro", ENVIRONMENT_TEST);
			if(Integer.parseInt(Pro.getString("log.enviro"))==3)
				mapMessage.setString("enviro", ENVIRONMENT_DEV);
			
			//设置异常详情
			mapMessage.setString("msg", msg);
			
			producer.send(mapMessage);
		} catch (JMSException e) {
			UnifyLogger.info("shiro_mq_error", e.getMessage());
		} finally {
			try {
				if(session != null){
					session.commit();
					session.close();
				}
				if(connection != null)
					connection.close();
			} catch (JMSException e) {
				UnifyLogger.info("shiro_mq_error", e.getMessage());
			}
		}
	}

}
