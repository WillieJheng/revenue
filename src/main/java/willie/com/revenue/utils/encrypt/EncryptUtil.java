package willie.com.revenue.utils.encrypt;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

   public final static Integer hashIterations =168;

    public static String urlEncode(String data) {
        String result = "";
        try {
            result = URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        return result;
    }

    public static String urlDecode(String data) {
        String result = "";
        try {
            result = URLDecoder.decode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        return result;
    }

    public final static String hash(byte data[], String mode) {
        MessageDigest md = null;
        try {
            if (mode == "MD5") {
                md = MessageDigest.getInstance("MD5");
            } else if (mode == "SHA-256") {
                md = MessageDigest.getInstance("SHA-256");
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return bytesToHex(md.digest(data));
    }

    public final static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexToBytes(String hexString) {
        char[] hex = hexString.toCharArray();
        //轉rawData長度減半
        int length = hex.length / 2;
        byte[] rawData = new byte[length];
        for (int i = 0; i < length; i++) {
            //先將hex資料轉10進位數值
            int high = Character.digit(hex[i * 2], 16);
            int low = Character.digit(hex[i * 2 + 1], 16);
            //將第一個值的二進位值左平移4位,ex: 00001000 => 10000000 (8=>128)
            //然後與第二個值的二進位值作聯集ex: 10000000 | 00001100 => 10001100 (137)
            int value = (high << 4) | low;
            //與FFFFFFFF作補集
            if (value > 127)
                value -= 256;
            //最後轉回byte就OK
            rawData [i] = (byte) value;
        }
        return rawData ;
    }

    public static String encryptUserPassword(String memberId, String password) {
        return new Md5Hash(password, memberId, hashIterations).toHex();
    }
}
