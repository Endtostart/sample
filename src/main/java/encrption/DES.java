package encrption;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DES {
    private static Cipher cipher;
    private static SecretKey generateKey;
    public static final String KEY_DES = "DES";

    /**
     * 加密
     * @param src
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encode(String src) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_DES);
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keys = secretKey.getEncoded();

        DESKeySpec desKeySpec = new DESKeySpec(keys);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(KEY_DES);
        generateKey = secretKeyFactory.generateSecret(desKeySpec);
        cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,generateKey);
        byte[] results = cipher.doFinal(src.getBytes());
        return Hex.encodeHexString(results);
    }

    /**
     * 解密
     * @param src
     * @return
     */
    public static String decode(String src){
        try {
            cipher.init(Cipher.ENCRYPT_MODE,generateKey);
            byte[] result = Hex.decodeHex(src.toCharArray());
            return new String(cipher.doFinal(result));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        String str = "Md5123132121544";
        System.out.println("=========Before Entryption==========");
        System.out.println(str);
        String result = encode(str);
        System.out.println("=========After Entryption===========");
        System.out.println(result);
    }
}
