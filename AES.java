package Crypto;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author anbarasu
 */
public class AES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        KeyGenerator kg=KeyGenerator.getInstance("AES");
        System.out.println("Enter the msg...");
        String input=in.nextLine();
        if(input.length()>8){
            SecretKey key=kg.generateKey();
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] na=input.getBytes();
            byte[] obj=cipher.doFinal(na);
            System.out.println("Encrypted Msg="+new String(obj));
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] obj1=cipher.doFinal(obj);
            System.out.println("Decrypted msg="+new String(obj1));
        }
        else
            System.out.println("Invalid Password");
    }
    
}
