package com.saohuobang.web.common.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;

public class XMLUtils {

    public static void readStringXml(String xml) {
        Document doc = null;
        try {

            // 读取并解析XML文档
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
            // 
            // SAXReader reader = new SAXReader(); //User.hbm.xml表示你要解析的xml文档
            // Document document = reader.read(new File("User.hbm.xml"));
            // 下面的是通过解析xml字符串的
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML

            Element rootElt = doc.getRootElement(); // 获取根节点
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称

            Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head

            // 遍历head节点
            while (iter.hasNext()) {

                Element recordEle = (Element) iter.next();
                String title = recordEle.elementTextTrim("title"); // 拿到head节点下的子节点title值
                System.out.println("title:" + title);

                Iterator iters = recordEle.elementIterator("script"); // 获取子节点head下的子节点script

                // 遍历Header节点下的Response节点
                while (iters.hasNext()) {

                    Element itemEle = (Element) iters.next();

                    String username = itemEle.elementTextTrim("username"); // 拿到head下的子节点script下的字节点username的值
                    String password = itemEle.elementTextTrim("password");

                    System.out.println("username:" + username);
                    System.out.println("password:" + password);
                }
            }
            Iterator iterss = rootElt.elementIterator("body"); ///获取根节点下的子节点body
            // 遍历body节点
            while (iterss.hasNext()) {

                Element recordEless = (Element) iterss.next();
                String result = recordEless.elementTextTrim("result"); // 拿到body节点下的子节点result值
                System.out.println("result:" + result);

                Iterator itersElIterator = recordEless.elementIterator("form"); // 获取子节点body下的子节点form
                // 遍历Header节点下的Response节点
                while (itersElIterator.hasNext()) {

                    Element itemEle = (Element) itersElIterator.next();

                    String banlce = itemEle.elementTextTrim("banlce"); // 拿到body下的子节点form下的字节点banlce的值
                    String subID = itemEle.elementTextTrim("subID");

                    System.out.println("banlce:" + banlce);
                    System.out.println("subID:" + subID);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    /** 
	* @Title: xml2map 
	* @Description: 从xml解析出来的内容放在map中
	* @author yuexr
	* @param @param xml
	* @param @return 
	* @return Map<String,String> 
	* @throws 
	*/ 
    public static Map<String,String> xml2map(String xml){
		Map<String, String> m = new HashMap<String, String>() ;
		try {
			Document doc = XMLUtils.string2Doc(xml);
			Element rootElement = doc.getRootElement();
			List elements = rootElement.elements();
			for(Iterator iterator = elements.iterator();iterator.hasNext();){
				Element element = (Element) iterator.next();
				m.put(element.getName(), element.getTextTrim());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */
    public static Map<String, String> readStringXmlOut(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        Document doc = null;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml); 
            // 获取根节点
            Element rootElt = doc.getRootElement(); 
            // 拿到根节点的名称
            System.out.println("根节点：" + rootElt.getName()); 

            // 获取根节点下的子节点head
            Iterator<Element> iter = rootElt.elementIterator("head"); 
            // 遍历head节点
            while (iter.hasNext()) {

                Element recordEle = (Element) iter.next();
                // 拿到head节点下的子节点title值
                String title = recordEle.elementTextTrim("title"); 
                System.out.println("title:" + title);
                map.put("title", title);
                // 获取子节点head下的子节点script
                Iterator<Element> iters = recordEle.elementIterator("script"); 
                // 遍历Header节点下的Response节点
                while (iters.hasNext()) {
                    Element itemEle = (Element) iters.next();
                    // 拿到head下的子节点script下的字节点username的值
                    String username = itemEle.elementTextTrim("username"); 
                    String password = itemEle.elementTextTrim("password");

                    System.out.println("username:" + username);
                    System.out.println("password:" + password);
                    map.put("username", username);
                    map.put("password", password);
                }
            }

            //获取根节点下的子节点body
            Iterator<Element> iterss = rootElt.elementIterator("body"); 
            // 遍历body节点
            while (iterss.hasNext()) {
                Element recordEless = (Element) iterss.next();
                // 拿到body节点下的子节点result值
                String result = recordEless.elementTextTrim("result"); 
                System.out.println("result:" + result);
                // 获取子节点body下的子节点form
                Iterator<Element> itersElIterator = recordEless.elementIterator("form"); 
                // 遍历Header节点下的Response节点
                while (itersElIterator.hasNext()) {
                    Element itemEle = (Element) itersElIterator.next();
                    // 拿到body下的子节点form下的字节点banlce的值
                    String banlce = itemEle.elementTextTrim("banlce"); 
                    String subID = itemEle.elementTextTrim("subID");

                    System.out.println("banlce:" + banlce);
                    System.out.println("subID:" + subID);
                    map.put("result", result);
                    map.put("banlce", banlce);
                    map.put("subID", subID);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    
    public static Document string2Doc(String xmlStr) throws DocumentException,Exception {
        return new SAXReader().read(new StringReader(xmlStr));
    }
    
    /**
     * 功能: 从文档中获取String  并且清除格式化缩进
     * 
     * @param document
     * @return
     * @throws Exception 
     */
    public static String doc2String(Document document) throws Exception {
        String returnStr = "";
        ByteArrayOutputStream bytesStream = new ByteArrayOutputStream();
        BufferedOutputStream outer = new BufferedOutputStream(bytesStream);

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = tFactory.newTransformer();
            transformer.setOutputProperty("encoding", "utf-8");
            transformer.setOutputProperty("indent", "false");
            transformer.transform(new DocumentSource(document), new StreamResult(outer));
            returnStr = bytesStream.toString("UTF-8");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            throw new Exception(e);
        } catch (TransformerException e) {
            e.printStackTrace();
            throw new Exception(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return returnStr;
    }
    
    public static void main(String[] args) {

//        // 下面是需要解析的xml字符串例子
//        String xmlString = "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
//                + "<script>" + "<username>yangrong</username>"
//                + "<password>123456</password>" + "</script>" + "</head>"
//                + "<body>" + "<result>0</result>" + "<form>"
//                + "<banlce>1000</banlce>" + "<subID>36242519880716</subID>"
//                + "</form>" + "</body>" + "</html>";
//
//        /*
//         * Test2 test = new Test2(); test.readStringXml(xmlString);
//         */
//        Map<String, String> map = readStringXmlOut(xmlString);
//        Iterator<String> iters = map.keySet().iterator();
//        while (iters.hasNext()) {
//            String key = iters.next().toString(); // 拿到键
//            String val = map.get(key).toString(); // 拿到值
//            System.out.println(key + "=" + val);
//        }
    	
    	/**
    	 * Test doc2String
    	 */
    	String xmlString = null;
    	Document doc = DocumentHelper.createDocument();
		Element books = doc.addElement("books");
		Element book = books.addElement("book")
		.addAttribute("type", "科幻");
		Element name = book.addElement("name");
		Element price = book.addElement("price");
		Element memo = book.addElement("memo");
		name.setText("哈里波特");
		price.setText("10.00");
		memo.setText("这是一本很好看的书。");
		
		Element book2 = books.addElement("book")
				.addAttribute("type", "技术");
				Element name2 = book2.addElement("name");
				Element price2 = book2.addElement("price");
				Element memo2 = book2.addElement("memo");
				name2.setText("算法导论");
				price2.setText("50.00");
				memo2.setText("这是一本算法的书。");
		 try {
			 xmlString = XMLUtils.doc2String(doc);
			System.out.println(xmlString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		 /**
		  * Test string2Doc
		  */
//		String xmlString="<?xml version=\"1.0\" encoding=\"utf-8\"?><books><book type=\"科幻\"><name>哈里波特</name><price>10.00</price><memo>这是一本很好看的书。</memo></book></books>";
		 try {
			Document docBooks = XMLUtils.string2Doc(xmlString);
//			String bookname = docBooks.valueOf("/books/book/name");
//			String type = docBooks.valueOf("/books/book/@type");
//			String bookprice = docBooks.valueOf("/books/book/price");
//			String bookmemo = docBooks.valueOf("/books/book/memo");
//			System.out.println(bookname);
//			System.out.println(type);
//			System.out.println(bookprice);
//			System.out.println(bookmemo);
			
			 Element rootElt = docBooks.getRootElement(); // 获取根节点
	            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
	            Iterator<Element> iterator = rootElt.elementIterator("book"); // 获取根节点下的子节点book
	            // 遍历book节点
	            while (iterator.hasNext()) {
	                Element recordEle = (Element) iterator.next();
	                
	                String bookname = recordEle.elementTextTrim("name"); 
	                System.out.println("name:" + bookname);
	                
	                String booktype = recordEle.attributeValue("type");
	                System.out.println("type:" + booktype);
	                
	                String bookprice = recordEle.elementTextTrim("price");
	                System.out.println("price:" + bookprice);
	                
	                String bookmemo = recordEle.elementTextTrim("memo");
	                System.out.println("memo:" + bookmemo);
	            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
    }

}