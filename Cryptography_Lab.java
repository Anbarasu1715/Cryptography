package cryptography_lab;
import java.util.*;
/**
 *
 * @author anbarasu
 */
public class Cryptography_Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Scanner in=new Scanner(System.in);
        
                System.out.println("""
                                   '*******************************************************
                                        IT1681 - Cryptography and  Networks Security Laboratory
                                   
                                   \tRoll Number : 20UIT012
                                   \tName        : Anbarasu.M
                                   \tLaboratory  : Cryptography
                                   *******************************************************
                                   
                                   \t------- ------- --------
                                   '""");
        int no_of_Exercise=7;
        do{
        System.out.println("\nEnter the Exercise Number.....\n\n1.Caeser_Cipher\n2.Shift_Cipher\n3.PlayFair_Cipher\n4.Vigenere_Cipher\n5.Hill_Cipher\n6.RowColumnar_Transformation\n7.RailFence_Cipher\n8.Exit");
        choice=in.nextInt();
            switch(choice){
                case 1 -> {
                    System.out.println("\n-----Caeser_Cipher-----\n");
                    Caeser_Cipher cc=new Caeser_Cipher();
                    cc.caeser();
                }
                case 2 -> {
                    System.out.println("\n-----Shift_Cipher-----\n");
                    Shift_Cipher sh=new Shift_Cipher();
                    sh.Shift();
                }
                case 3 -> {
                    System.out.println("\n-----Playfair_Cipher-----\n");
                    PlayFair_Cipher pc=new PlayFair_Cipher();
                    pc.main();
                }
                case 4 -> {
                    System.out.println("\n-----Vigenere_Cipher-----\n");
                    Vigenere_Cipher vc=new Vigenere_Cipher();
                    vc.main();
                }
                case 5 -> {
                    System.out.println("\n-----Hill_Cipher-----\n");
                    Hill_Cipher hc=new Hill_Cipher();
                    hc.main();
                }
                case 6 -> {
                    System.out.println("\n-----RowColumnar_Transformation-----\n");
                    RowColumnar rc=new RowColumnar();
                    rc.main();
                }
                case 7 -> {
                    System.out.println("\n-----RailFence_Cipher-----\n");
                    RailFence_Cipher rf=new RailFence_Cipher();
                    rf.main();
                }
            default -> {
                System.out.println("Bye.....");
                System.exit(0);
                }
                }
        }while(choice<no_of_Exercise+1);
    }
    
}
