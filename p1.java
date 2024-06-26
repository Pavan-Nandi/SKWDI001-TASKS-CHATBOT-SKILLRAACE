import java.lang.*;
import java.util.*;

public class p1{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int d=sc.nextInt();
int te=0;
int y=0;;
int x=0;
int a=0;
int f=0;
if(d==1 || d==2 || d==5 || d==10 || d==50 || d==100){
System.out.println("1");
}


else if(d%10==0 || d%5==0 || d%2==0 || d%3==0 || d%7==0 || d%11==0 || d%1==0 ){
y=d/100;
d=d-(y*100);
if(d==0){

System.out.println(y);
}



else if(d%5==0 || d%2==0 || d%3==0 || d%7==0 || d%11==0 || d%1==0){
x=d/50;
d=d-(x*50);

if(d==0){

System.out.println(x+y);

}




else if(d%2==0 || d%5==0 || d%3==0 || d%7==0 || d%9==0 || d%11==0 || d%1==0){
a=d/10;

d=d-(a*10);
if(d==0){

System.out.println(x + y + a);
}

else if(d%5==0 || d%2==0 || d%3==0 || d%7==0 || d%11==0 || d%9==0 || d%11==0 || d%1==0){
te=d/5;

d=d-(te*5);

if(d==0){

System.out.println(x + y + a + te);
}
else if(d%2==0 || d%1==0){
f=d/2;
d=d-(f*2);
if(d==0){
System.out.println(x + y + a + te + f);
}
else if(d==1){
System.out.println( x + y + a + te + f + 1);
}
}
}

}
}
}


}
}
