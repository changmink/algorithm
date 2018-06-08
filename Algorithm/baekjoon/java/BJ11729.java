package baekjoon.java;

import java.util.*;

public class BJ11729 {
    public static StringBuilder output = new StringBuilder();
    public static int count = 0;
    static void solve(int n, int x, int y){
        if(n == 0) return;
        solve(n - 1, x, 6 - x - y);
        output.append(x + " " + y + "\n");
        count += 1;
        solve(n -1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n, 1, 3);
        System.out.println(count);
        System.out.println(output);
    }
}
