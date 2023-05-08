/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptography_lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anbarasu
 */
public class RowColumnar {
    Scanner in=new Scanner(System.in);
    
    //Method to convert String into 2d array
    protected char[][] matrix(String text,int klen,int Tlen,int flag){
        char[] alp={'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int Olen=Tlen,in=0;
        if(text.length()%klen!=0){
            do{
                text=text+alp[in];
                in++;
            }while(text.length()%klen!=0);
        }
        int k=0;
        Tlen=text.length();
        char[][] word=new char[Tlen/klen][klen];
        for(int i=0;i<((flag==0)?klen:(Tlen/klen));i++){
            for(int j=0;j<((flag==0)?(Tlen/klen):klen);j++){
                word[((flag==0)?j:i)][((flag==0)?i:j)]=text.charAt(k);
                k++;
            }
        }
        return word;
    }
    
    //Method to encrypt the plaintext into cipher text
    protected void Encrypt(String text,int[] key,int klen,int Tlen,int flag){
        char[][] remix=matrix(text,klen,Tlen,flag);
        int[] ok=new int[klen];
        System.arraycopy(key, 0, ok, 0, klen);
        Arrays.sort(key);
        int c=0,index=0;
        String ans="";
        for(int i=0;i<klen;i++){
            for(int k=0;k<ok.length;k++){
                if(key[i]==ok[k]){
                    index=k;
                }
            }
            for(int j=0;j<remix.length;j++){
                ans=ans+""+remix[j][index];
            }
        }
        System.out.print("Encrypted Text:"+ans+"\n");
    }
    
    //Method to decrypt the Cipher text into plain text
    protected void Decrypt(String text,int[] key,int klen,int Tlen,int flag){
        char[][] remix=matrix(text,klen,Tlen,flag);
        int[] ok=new int[klen];
        System.arraycopy(key, 0, ok, 0, klen);
        Arrays.sort(key);
        int c=0,index=0,n=0;
        String ans="";
        for(int i=0;i<remix.length;i++){
            while(ans.length()<(i+1)*klen){
                for(int k=0;k<ok.length;k++){
                    if(ok[n]==key[k]){
                        index=k;
                        n++;
                        break;
                    }
                }
                ans=ans+""+remix[i][index];
                if(n>=klen){
                    n=0;
                }
            }
        }
        String pattern = "AB|ABC|ABCD|ABCDE|ABCDEF|ABCDEFG|ABCDEFGH|ABCDEFGHI";
        String replacement = "";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(ans);
        String result = m.replaceAll(replacement);
        System.out.println("Decrypted Text::"+result);
    }
    
    
    //Get the input required inputs from the user
    public void input(int flag){
        in.nextLine();
        if(flag==1)
            System.out.println("\n-----Enter the Plain Text-----");
        else
            System.out.println("-----Enter the Cipher Text-----");
        String text=in.nextLine();
        text=text.toUpperCase();
        if(text.matches(".*\\d.*"))//method to find whether the integer is prest in the string
            System.out.println("\nSorry,input must be a word.....\n");
        else{
            System.out.println("-----Enter the Keyword-----");
            String keyword=in.nextLine();
            if(keyword.matches(".*\\d.*")){
                System.out.println("\nSorry,input must be a word.....\n");
            }
            else{
                int len=text.length();
                System.out.print("Keyword:");
                keyword=keyword.replaceAll("\\s", "");
                System.out.println(keyword=keyword.toUpperCase());
                System.out.print("PlainText:");
                text=text.replaceAll("\\s", "");//method to replace the space between
                                                                //the String into ""(empty).
                //text=text.replaceAll(".", "");
                System.out.println((text=text.toUpperCase())+"\n");
                int klen=keyword.length();
                int[] key=new int[klen];
                for(int i=0;i<klen;i++){
                    key[i]=(int)(keyword.charAt(i)-65);
                }
                if(flag==1){
                    Encrypt(text,key,klen,len,flag);
                }
                else{
                    Decrypt(text,key,klen,len,flag);
                }
                    
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
