package baekjoon.java;

import java.util.*;

public class BJ2609 {
    //최대 공약수: 두 수의 공통 되는 약수 중 가장 큰 수
    //복잡도 O(n), n은 a, b중 작은 수 이다. 문제에서 최대 10000까지 이므로 10000이 n의 최대 값이 된다.
    static int gcd(int a, int b){
        int gcd = 1;
        int n = a;
        if(a > b) n = b;
        for(int i = 2; i <=n; ++i){
            if(a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }


    /* 유클리드 호제법
    * https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
    * */
    static int gcdEuclidean(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }


    /*
    * 최소 공배수 : 두 수의 공통되는 배수 중에서 가장 작은 수
    * lcm은 a/gcd * b/gcd * gcd의 값인데
    * 식을 간단 하게 하면 g * b / gcd 가 된다.
    * 복잡도 O(1)
    * */
    static int lcm(int a, int b, int gcd){

        return a * b / gcd;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcdEuclidean(a, b);
        int lcm = lcm(a, b, gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
