package com.platform.web.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 企信通短信接口
 * @author wwlai 
 */
public class SendMessage {
	String 	msg=java.net.URLEncoder.encode("测试短信息：xxxx？");
	
	String  mob = "18310251056";//电话号码  1322222222,1326666666
private static final String addr="http://114.113.155.149:8888/sms.aspx";
private static final String userid ="669"; //
private static final String account="saohuo_benmu";//hysaohuo子账户saohuo_benmu
private static final String pwd="000999";

public static int send(String msg,String mobile,String sendTime) throws Exception{
	System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	int nRet = 0;
	
	String straddr = addr +"?action=send&userid="+userid+"&account="+account+
			"&password="+pwd+"&mobile="+mobile+"&sendTime="+java.net.URLEncoder.encode(sendTime)+"&extno=&content="+msg;
	StringBuffer sb = new StringBuffer(straddr);

	System.out.println(straddr);

	// 
	//sb.append("&content="+URLEncoder.encode(msg, "UTF-8"));
    
	//
	URL url = new URL( sb.toString());

	//URL  url = new URL(URLEncoder.encode(sb.toString(),"UTF-8") );
	
	
	// 
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	//
	connection.setRequestMethod("POST");

	// 
	BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

	// 
	String inputline = in.readLine();

	//
	System.out.println(inputline);

	//if(! inputline.equals("100"))
	//   nRet = 1;
	
	return nRet;
}
public static void main(String args[]){
	//15718841064  2014-07-10 19:00
	//http://114.113.155.149:8888/sms.aspx?action=send&userid=360&account=hysaohuo&password=000999&mobile=18310251056,15718841064&sendTime=2014-10-24 20:05:00&extno=&content=测试多人定时  2014-07-10 19:00
	try {
		int a=send("验证码:1234","18500290063","");
		System.out.println(a);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
