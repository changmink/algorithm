package baekjoon.java;

/**
 * 내 풀이 문제 접근 방식만 확인 후 손코딩 후 리팩토링
 * Created by changmin on 2018. 1. 26..
 */
import java.util.*;

public class BJ1561_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        int m = sc.nextInt();
        int[] machine = new int[m];
        for(int i = 0; i < m; ++i){
            machine[i] = sc.nextInt();
        }
        long output = findFinalRide(machine, students);
        System.out.println(output);
    }

    public static long findFinalRide(int[] machine, int student){
        if(machine.length >= student){
            return student;
        }

        long left = 0;
        long right = 2000000000L * 100000L;
        long output = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long rangeEnd = getStudentWhile(machine, mid);
            long rangeStart = rangeEnd - getStudentAt(machine, mid) + 1 ;//일단 한명은 탄것으로 계산 해야 범위 안에 들어옴

            if(student > rangeEnd){
                left = mid + 1;
            }else if(student < rangeStart){
                right = mid - 1;
            }else{
                output = lastStudent(machine, student, rangeStart, mid);
                break;
            }
        }
        //제로 인덱스 이므로 1을 붙여준다.
        return output + 1;
    }

    //해당 시간 까지의 탑승한 학생
    static long getStudentWhile(int[] machine, long time) {
        long output = machine.length;//일단 기계수만큼 계산한다
        for(int runtime:machine){
            output += (time / runtime);
        }
        return output;
    }
    //해당 시간에 탑승한 학생
    static long getStudentAt(int[] machine, long time){
        long output = 0;
        for(long runtime : machine){
            if(time % runtime == 0) output += 1;
        }
        return output;
    }

    static long lastStudent(int[] machine, int target, long begin, long time){
        long output = 0;
        for(int i = 0; i < machine.length; ++i){
            if(time % machine[i] == 0){
                if(target == begin){
                    output = i;
                    break;
                }
                begin += 1;
            }
        }
        return output;
    }

}
