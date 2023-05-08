package Crypto;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import javax.crypto.*;
/**
 *
 * @author anbarasu
 */
public class SHA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Message:");
        String input=in.nextLine();
        MessageDigest md=MessageDigest.getInstance("SHA-1");
        byte[] mdigest=md.digest(input.getBytes());
        BigInteger bi=new BigInteger(1,mdigest);
        String hash=bi.toString(16);
        while(hash.length()<32){
            hash='0'+hash;
        }
        System.out.println("The Hash value for the given messahe "+input+" is "+hash);
    }
    
}
