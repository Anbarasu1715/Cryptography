/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptography_lab;

import java.util.*;

/**
 *
 * @author anbarasu
 */
public class RailFence_Cipher {
    Scanner in=new Scanner(System.in);
    
    public void Encrypt(String text,int depth,int Tlen){
        List<StringBuilder> cipher=new ArrayList<>();
        for(int i=0;i<depth;i++){
            cipher.add(new StringBuilder());
        }
        int row=0;
        boolean checkrow=true;
        for(char c:text.toCharArray()){
            cipher.get(row).append(c);
            if(row==0){
                checkrow=true;
            }
            else if(row==depth-1){
                checkrow=false;
            }
            row+=checkrow?1:-1;
        }
        String CipherText="";
        for(StringBuilder ch:cipher){
           CipherText+=ch;
        }
        System.out.println("Cipher Text:"+CipherText);
    }
    
    protected void print(String text,int key,int flag){
        if(flag==1)
            System.out.println("The plain Text : "+text);
        else
            System.out.println("The Cipher Text : "+text);
        System.out.println("Key : "+key);
    }
    
    protected void Decrypt(String text,int depth,int Tlen){
        List<StringBuilder> sub=new ArrayList<>();
        for(int i=0;i<depth;i++){
            sub.add(new StringBuilder());
        }
        int row=0;
        boolean checkrow=true;
        int length[]=new int[depth];
        for(int i=0;i<Tlen;i++){
            length[row]++;
            if(row==0){
                checkrow=true;
            }
            else if(row==depth-1){
                checkrow=false;
            }
            row+=checkrow?1:-1;
        }
        int index=0;
        for(int i=0;i<depth;i++){
            sub.set(i,new StringBuilder(text.substring(index,index+length[i])));
            index+=length[i];
        }
        StringBuilder plaintext=new StringBuilder();
        int[] indexes=new int[depth];
        row=0;
        checkrow=true;
        for(int i=0;i<Tlen;i++){
            plaintext.append(sub.get(row).charAt(indexes[row]));
            indexes[row]++;
            if(row==0){
                checkrow=true;
            }
            else if(row==depth-1){
                checkrow=false;
            }
            row+=checkrow?1:-1;
        }
        System.out.println("PlainText:"+plaintext);
    }
    
    public void input(int flag){
        in.nextLine();
        if(flag==1)
            System.out.println("\n-----Enter the Plain Text-----");
        else
            System.out.println("-----Enter the Cipher Text-----");
        String text=in.nextLine();
        text=text.toUpperCase();
        if(text.matches(".*\\d.*"))
            System.out.println("\nSorry,input must be a word.....\n");
        else{
            
            System.out.println("-----Enter the Depth-----");
            try{
            String keyword=in.nextLine();
            /*if(keyword.matches("[a-zA-Z]+"))
                System.out.println("\nSorry,input must be a positive number\n");
            else{*/
                int key=Integer.parseInt(keyword);
                if(key<0){
                    System.out.println("\nSorry,input must be a positive number\n");
                }
                else{
                    int Tlen=text.length();
                    print(text,key,flag);
                    if(flag==1)
                        Encrypt(text,key,Tlen);
                    else
                        Decrypt(text,key,Tlen);
                }
            }
            catch(NumberFormatException e){
                System.out.println("\nSorry,input must be a positive number\n");
            }
        }
    }
    
    public void main(){
        int choice,flag;
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