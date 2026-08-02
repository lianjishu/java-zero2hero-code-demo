package webcrawler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Crawler {
    public static String getHtml(String tar) throws IOException {
        //定义一个StringBuilder接受爬取到的数据
        StringBuilder sb = new StringBuilder();
        //创建URL实例
        URL url = new URL(tar);
        //建立连接
        URLConnection conn = url.openConnection();
        //读取数据
        //使用转换流 将字节流换成字符流 不然乱码  //conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int len;
        char[] buffer = new char[8192];
        while ((len = isr.read(buffer)) != -1) {
            sb.append(buffer, 0, len);
        }
        isr.close();
        //返回读取数据
        return sb.toString();
    }
}
