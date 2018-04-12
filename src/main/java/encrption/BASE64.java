package encrption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class BASE64 {
    /**
     * 解密
     * @param key
     * @return
     * @throws IOException
     */
    public static byte[] decrypBASE64(String key) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * 加密
     * @param key
     * @return
     */
    public static String encrypBASE64(byte[] key){
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) throws IOException {
        String str = "123456";
        String encryp = encrypBASE64(str.getBytes());
        System.out.println("===========加密数据==========");
        System.out.println(encryp);
        byte[] decryp = decrypBASE64(encryp);
        System.out.println("===========解密数据===========");
        System.out.println(new String(decryp));
    }


}
