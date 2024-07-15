import java.lang.*;
import java.util.*;
public class p4{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String nu=sc.nextLine();
StringBuilder sb=new StringBuilder(nu);
int te=0;
int uy=sb.length();
for(int i=0; i<uy; i++){
int y=Character.getNumericValue(sb.charAt(i));
if(y==4){
te++;
}
}
System.out.println(te);
}
}