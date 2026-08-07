package io.github.lianjishu.xml.taste.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class SaxReaderExample {
    public static void main(String[] args) throws DocumentException {
        //1.创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2.利用解析器去读取xml文件, 并且返回文档对象
        File f = new File("E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day36-log-classloader-xml-unittest-annotaion\\src\\main\\java\\io\\github\\lianjishu\\xml\\taste\\dom4j\\bookstore.xml");
        Document document = saxReader.read(f);
        //拿到了document表示我已经拿到了xml文件的整体

        //层层获取信息
        //根标签: bookstore
        Element rootElement = document.getRootElement();
        //遍历每一个book标签
        List<Element> bookList = rootElement.elements("book");
        for (Element book : bookList) {
            System.out.println("book" + book.attribute("id").getValue());
            //title标签 author标签 price标签 published标签
            List<Element> elements = book.elements();
            for (Element e : elements) {
                System.out.println(e.getName()+": "+e.getText());
            }
            System.out.println("============================");
        }

    }
}
