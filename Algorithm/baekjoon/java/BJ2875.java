package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 10..
 */
import java.util.*;
public class BJ2875 {
    public static int teamMatching(int girls, int boys, int intern){
        int team = 0;
        while(girls >= 2 && boys >= 1 && girls + boys >= intern + 3){
            team += 1;
            girls -= 2;
            boys -= 1;
        }

        return team;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int girls = sc.nextInt();
        int boys = sc.nextInt();
        int interns = sc.nextInt();
        int output = teamMatching(girls, boys, interns);
        System.out.println(output);
    }
}
