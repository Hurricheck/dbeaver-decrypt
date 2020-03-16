package decrypt;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;
import java.util.Arrays;

public class Decrypter {
    private static final byte[] PASSWORD_ENCRYPTION_KEY = "sdf@!#$verf^wv%6Fwe%$$#FFGwfsdefwfe135s$^H)dg".getBytes();
    private static final String CHARSET = "UTF8";

    private void xorStringByKey(byte[] plainBytes) throws UnsupportedEncodingException {
        int keyOffset = 0;

        for(int i = 0; i < plainBytes.length; ++i) {
            byte keyChar = PASSWORD_ENCRYPTION_KEY[keyOffset];
            ++keyOffset;
            if(keyOffset >= PASSWORD_ENCRYPTION_KEY.length) {
                keyOffset = 0;
            }

            plainBytes[i] ^= keyChar;
        }

    }

    public String decrypt(String encryptedString) throws Exception {
        if(encryptedString != null && encryptedString.trim().length() > 0) {
            try {
                byte[] e = Base64.decode(encryptedString);
                this.xorStringByKey(e);
                if(e[e.length - 2] == 0 && e[e.length - 1] == -127) {
                    return new String(e, 0, e.length - 2, "UTF8");
                } else {
                    throw new Exception("Invalid encrypted string");
                }
            } catch (Exception var3) {
                throw new Exception(var3);
            }
        } else {
            throw new IllegalArgumentException("Empty encrypted string");
        }
    }
}
