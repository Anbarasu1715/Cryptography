/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptography_lab;

import java.util.Scanner;

/**
 *
 * @author anbarasu
 */
public class Vigenere_Cipher {
    Scanner in=new Scanner(System.in);
    
    public void Encrypt(String text,String keyword,int Tlen,int Klen){
        StringBuilder plainText = new StringBuilder();
        for (int i = 0, j = 0; i < Tlen; i++) {
        char c = text.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            plainText.append((char) ((c + keyword.charAt(j) + 26) % 26 + 'A'));
            j = (j + 1) % Klen;
        }
    }
        System.out.println(plainText.toString());
        System.out.println("\n");
    }
    
    public void Decrypt(String text,String keyword,int Tlen,int Klen){
        StringBuilder plainText = new StringBuilder();
        for (int i = 0, j = 0; i < Tlen; i++) {
        char c = text.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            plainText.append((char) ((c - keyword.charAt(j) + 26) % 26 + 'A'));
            j = (j + 1) % Klen;
        }
    }
        System.out.println(plainText.toString());
        System.out.println("\n");
}
        
    
    
    
    public void input(int flag){
        in.nextLine();
        System.out.println("-----Enter the Text-----");
        String text=in.nextLine();
        if(text.matches(".*\\d.*")){
            System.out.println("\nSorry,input must be a word.....\n");
        }
        else{
            System.out.println("-----Enter the Keyword-----");
            String keyword=in.nextLine();
            if(keyword.matches(".*\\d.*")){
                System.out.println("\nSorry,input must be a word.....\n");
            }
            else{
                int Tlen=text.length();
                System.out.print("Keyword:");
                keyword=keyword.replaceAll("\\s", "");
                System.out.println(keyword=keyword.toUpperCase());
                System.out.print("PlainText:");
                text=text.replaceAll("\\s", "");
                System.out.println((text=text.toUpperCase())+"\n");
                int Klen=keyword.length();
                if(flag==1)
                    Encrypt(text,keyword,Tlen,Klen);
                else
                    Decrypt(text,keyword,Tlen,Klen); 
                
            }
        }
    }
    
    
    
    public void main(){
        int choice,flag=0;
        boolean shouldbreak=false;
        do{
        System.out.println("\nEnter the choice...\n1.Encryption\n2.Decryption\n3.Exit\n");
        choice=in.nextInt();
        switch(choice){
            case 1 -> {
                System.out.println("----------ENCRYPTION-------------");
                flag=1;
                input(flag);
                break;
            }
            case 2 -> {
                System.out.println("----------DECRYPTION-------------");
                flag=0;
                input(flag);
                break;
            }
            default -> {
                System.out.println("Bye.....");
                shouldbreak=true;
            }
        }
        if(shouldbreak)
            break;
        }while(choice<3);
    }
}
