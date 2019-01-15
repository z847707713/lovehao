package utils;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomTest {

    @Test
    public void test(){
        createXml();
    }

    public static void createXml(){
        try{

            //创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();

            //不显示standalone = "no"
            document.setXmlStandalone(true);
            Element bookstore = document.createElement("bookstore");
            //向bookstore 根节点点添加子节点book
            Element book = document.createElement("book");
            Element name = document.createElement("name");
            name.setTextContent("雷神");
            book.appendChild(name);

            book.setAttribute("id","1");
            bookstore.appendChild(book);
            document.appendChild(bookstore);


            //创建TransformerFactory
            TransformerFactory tff = TransformerFactory.newInstance();
            //创建Transformer对象
            Transformer tf = tff.newTransformer();

            //输出内容是否换行
            tf.setOutputProperty(OutputKeys.INDENT,"yes");
            tf.transform(new DOMSource(document), new StreamResult(new File("D:/book1.xml")));
            System.out.println("生成book1.xml成功");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


}
