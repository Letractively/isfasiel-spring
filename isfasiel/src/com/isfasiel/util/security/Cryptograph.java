package com.isfasiel.util.security;

import sun.misc.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;

import org.springframework.stereotype.Component;

@Component
public class Cryptograph {
	private String algorithm = "DESede";
	private String PADDING = "DESede/ECB/PKCS5Padding";
	private Key key = null;
	private Cipher cipher = null;
	private String keyFileName;

	public Key getKey() {
		return key;
	}
	
	public void init(String keyFileName) {
		this.keyFileName = keyFileName.replaceAll("\\\\", "/");
		loadKey();
	}

	private void loadKey() {
		try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(keyFileName));
            key = (Key)in.readObject();
            in.close();
        } catch (FileNotFoundException fnote) {
        	setKey();
            
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
		}
	}
	
	private void setKey() {
		try {
			// Key 파일이 없으면 실행된다.
	        // 알고리즘 대칭키 알고리즘을 정의해서 키 제너레이터를 생성한다.
	        KeyGenerator keygenerator = KeyGenerator.getInstance(algorithm);
	        // 랜덤 함수로 초기화한다.
	        keygenerator.init(new SecureRandom());
	        // 키를 생성한다.
	        key = keygenerator.generateKey();
	        File dir = new File(keyFileName.substring(0,keyFileName.lastIndexOf("/")) );
	        
			if( !dir.exists() ) {
				dir.mkdirs();
			}
	        dir = null;
	        // 생성된 키 객체를 파일로 저장한다.
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(keyFileName));
	        out.writeObject(key);
	        out.close();
	        out = null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String decode(String text) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] encryptedByte = decoder.decodeBuffer(text);
		
		cipher = Cipher.getInstance(PADDING);
		cipher.init(Cipher.DECRYPT_MODE, key);
	    byte[] decrypted = cipher.doFinal(encryptedByte);
	    return new String(decrypted);
	}

	public String encode(String plainText) throws Exception {
		byte[] messageBytes = plainText.getBytes();
		
	   cipher = Cipher.getInstance(PADDING);

	   cipher.init(Cipher.ENCRYPT_MODE, key);
	   byte[] ciphertext = cipher.doFinal(messageBytes);
       BASE64Encoder encoder = new BASE64Encoder();
       return encoder.encode(ciphertext);
    }
	
}
