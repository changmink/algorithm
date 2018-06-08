package baekjoon.java;

import java.util.*;

public class BJ2022 {
   public static String getDist(double x, double y, double c){
       double left = 0;
       double right = Math.min(x, y);
       for(int i = 0; i < 10000; ++i){
           double mid = (left + right) / 2;
           double h1 = Math.sqrt(x * x - mid * mid);
           double h2 = Math.sqrt(y * y - mid * mid);

           double dist = h1*h2 / (h1+h2);

           if(dist < c){
               right = mid;
           }else if(dist > c){
               left = mid;
           }
       }

       //정답은 left혹은 right중 하나 반복문을 계속 돈다면 둘다 같은 값이 되기 때문
       return String.format("%.3f", right);
   }

   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while(true) {
           try {
               double x = sc.nextDouble();
               double y = sc.nextDouble();
               double c = sc.nextDouble();
               System.out.println(getDist(x, y, c));
           }catch (Exception e){
               break;
           }
       }
   }
}
