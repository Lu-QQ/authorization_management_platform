package com.rouyi.authorization.service;


import com.msun.sm.SM2Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author luqianqi
 * @title: SmService
 * @projectName authorization_management_platform
 * @description: 国密加解密服务
 * @date 2024/9/2510:39
 */
@Component
public class SmService {
    private static final Logger log = LoggerFactory.getLogger(SmService.class);

    /**
     * SM2加密
     */
    public String sm2Encrypt(String plainText, String publicKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        return SM2Util.encode(plainText, publicKey);
    }
    /**
     * SM2解密
     * @return byte[]
     */
    public byte[] sm2Decrypt(String cipherText, String privateKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        return SM2Util.decoder(cipherText, privateKey);
    }
    /**
     * SM2签名
     */
    public String sm2Sign(String plainText, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        return SM2Util.sign(plainText, privateKey);
    }
    /**
     * SM2验签
     */
    public boolean sm2Verify(String plainText, String sign, String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        return SM2Util.verify(plainText, sign, publicKey);
    }
}
