package Crypto;
import java.util.*;
/**
 *
 * @author anbarasu
 */
public class Deffie_Helman {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the Prime value:");
        double p=in.nextDouble();
        System.out.print("Enter the Alpha:");
        double alpha=in.nextDouble();
        if(alpha>p)
            System.out.println("Alpha is greater than Prime");
        else{
            System.out.print("Enter the Private key of Person A:");
            double pa=in.nextDouble();
            System.out.print("Enter the Private key of Person B:");
            double pb=in.nextDouble();
            if(pa>p || pb>p)
                System.out.println("Private key of Person A or B is greater than Prime.....");
            else{
                double pka=(Math.pow(alpha,pa))%p;
                double pkb=(Math.pow(alpha,pb))%p;
                System.out.println("The Shared Key : "+((long)(Math.pow(pkb,pa))%p));
            }
        }
    }
    
}




