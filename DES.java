package Crypto;
import javax.crypto.*;
import java.util.*;
/**
 *
 * @author anbarasu
 */
public class DES {
    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        KeyGenerator kg=KeyGenerator.getInstance("DES");
        System.out.println("Enter the msg...");
        String input=in.nextLine();
        if(input.length()>=8){
            SecretKey key=kg.generateKey();
            Cipher cipher=Cipher.getInstance("DES");
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
