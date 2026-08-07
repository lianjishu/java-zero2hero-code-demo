package io.github.lianjishu.xml.taste.dom4j.tryoutXPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;

import java.io.File;
import java.util.List;

public class TryOutXPath {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day36-log-classloader-xml-unittest-annotaion\\src\\main\\java\\io\\github\\lianjishu\\xml\\taste\\dom4j\\bookstore.xml"));

//         创建 XPath 对象
        XPath xpath = new DefaultXPath("//book[@id='1']");
        // 获取单个节点
        Node book = xpath.selectSingleNode(doc);
        // 获取多个节点
        List<Node> books = xpath.selectNodes(doc);
        System.out.println(books);

//
//        List<Node> nodes = doc.selectNodes("/bookstore/book/title");
//        System.out.println(nodes.size());
    }
}
