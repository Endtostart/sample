package encrption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static final String KEY_MD5 = "MD5";
    public static String getResult(String input) throws NoSuchAlgorithmException {
        System.out.println("========Before Entryption=========");
        System.out.println(input);

        BigInteger big = null;
        MessageDigest md = MessageDigest.getInstance(KEY_MD5);
        md.update(input.getBytes());

        big = new BigInteger(md.digest());
        System.out.println("========After Entryption=======");
        System.out.println(big.toString(16));

        return  big.toString(16);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "Md5123132121544";
        getResult(str);
    }
}
