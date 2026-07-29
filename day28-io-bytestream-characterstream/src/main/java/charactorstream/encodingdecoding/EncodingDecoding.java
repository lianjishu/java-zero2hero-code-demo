package charactorstream.encodingdecoding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Java中编码的方法
 * public byte[] getBytes()    使用默认方式进行编码
 * public byte[] getBytes(String charsetName)    使用指定方式进行编码
 * <p>
 * Java中解码的方法
 * String(byte[] bytes)    使用默认方式进行解码
 * String(byte[] bytes, String charsetName)    使用指定方式进行解码
 */
public class EncodingDecoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "舒文杰";
        byte[] s1Encoded = s1.getBytes("UTF-8");
        System.out.println(s1 + " 使用" + "UTF-8编码规则, " + "编码为" + Arrays.toString(s1Encoded));
        String s1Decoded = new String(s1Encoded, "UTF-8");
        System.out.println("解码  " + s1Decoded);
    }
}
