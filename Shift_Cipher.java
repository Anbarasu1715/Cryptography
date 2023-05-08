package cryptography_lab;

import java.util.*;

public class Shift_Cipher{
    
    Scanner in=new Scanner(System.in);
    static String msg;
    int k;
    public String input(){
        System.out.println("Enter the Message to Encrypt.....");
        String val=in.nextLine();
        return val;
    }
    
    public void Encrypt(String msg){
        System.out.print("Enter the Key value:");
        k=in.nextInt();
        System.out.print("Encrypted message:");
        for(int i: msg.toCharArray()){
            i=i-65;
            char c=(char) ((i+k)%26+65);
            System.out.print(c);
        }
    }
    
    public void Decrypt(String msg){
        msg=msg.toUpperCase();
        System.out.print("Enter the Key value:");
        k=in.nextInt();
        System.out.print("Decrypted Message:");
        for(int i:msg.toCharArray()){
            i=i-65;
            int temp=(i-k)<0?26+(i-k)+97:((i-k)%26)+97;
            System.out.print((char)temp);
        }
    }
    
    
    public void Shift(){
        Shift_Cipher sc=new Shift_Cipher();
        int choice;
        boolean shouldbreak=false;
        do{
        System.out.println("\nEnter your choice...\n1.ENCRYPTION\n2.DECRYPTION\n3.Exit");
        choice=in.nextInt();
            switch(choice){
                case 1:
                    msg=sc.input();
                    msg=msg.toUpperCase();
                    sc.Encrypt(msg);
                    System.out.println("");
                    break;

                case 2:
                    msg=sc.input();
                    sc.Decrypt(msg);
                    System.out.println("");
                    break;
                    
                default:
                    System.out.println("Bye.....");
                    shouldbreak=true;
            }
            if(shouldbreak)
                break;
            }while(choice<3);
    }    
}