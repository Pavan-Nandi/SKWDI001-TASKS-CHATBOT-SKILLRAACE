import java.util.*;
public class p3{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String num=sc.nextLine();
int te=0;
int yu=0;
StringBuilder sb=new StringBuilder(num);
int ro=sb.length();
for(int i=0; i<ro; i++){
char e=sb.charAt(i);
int r=Character.getNumericValue(e);
if(r%2==0){
te=te+r;
}
else{
yu=yu+r;
}
}
System.out.print(yu+" ");
System.out.print(te);
}
}