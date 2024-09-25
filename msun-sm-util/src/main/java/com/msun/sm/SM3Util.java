package com.msun.sm;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

/**
 * SM3工具类
 * @author luqianqi
 */
public class SM3Util {
    /**
     * 编码方式 UTF-8
     * 加载项
     */
    private static final String ENCODING = "UTF-8";
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    public static String encrypt(String paramStr){
        String resultHexString = "";
        try {
            byte[] srcData = paramStr.getBytes(ENCODING);
            byte[] resultHash = hash(srcData);
            resultHexString = Base64.getEncoder().encodeToString(resultHash);
            //ByteUtils.toHexString(resultHash);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultHexString;
    }
    public static byte[] hash(byte[] srcData) {
        SM3Digest digest = new SM3Digest();
        digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        return hash;
    }

    public static boolean verify(String srcStr, String sm3HexString) {
        boolean flag = false;
        try {
            byte[] srcData = srcStr.getBytes(ENCODING);
            byte[] sm3Hash = Base64.getDecoder().decode(sm3HexString);
            byte[] newHash = hash(srcData);
            if (Arrays.equals(newHash, sm3Hash)){
                flag = true;

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
