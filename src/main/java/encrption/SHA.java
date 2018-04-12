package encrption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    public static final String KEY_SHA = "SHA";

    public static String getResult(String input) throws NoSuchAlgorithmException {
        System.out.println("========Befor Encryption========");
        System.out.println(input);

        MessageDigest md = MessageDigest.getInstance(KEY_SHA);
        md.update(input.getBytes());
        BigInteger big = new BigInteger(md.digest());
        System.out.println("=========After Entryption");
        System.out.println(big.toString(16));
        return big.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "Md5123132121544";
        getResult(str);
    }
}
