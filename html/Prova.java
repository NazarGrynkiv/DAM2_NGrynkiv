package prova;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Prova {
	public static void main(String[] args) {
		
		SecretKey sKey = keygenKeyGeneration(256);
		String clau = Base64.getEncoder().encodeToString(sKey.getEncoded());
		System.out.println(clau);
		
	}
	
	public static SecretKey keygenKeyGeneration(int keySize) {
		
		SecretKey sKey = null;
		if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				kgen.init(keySize);
				sKey = kgen.generateKey();
			}catch (NoSuchAlgorithmException ex){
				
				System.out.println("Generador no disponible");
				
			}
		}
		return sKey;
		
	}
}