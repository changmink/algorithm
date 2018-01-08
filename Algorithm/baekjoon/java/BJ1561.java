package baekjoon.java;


import java.util.*;

/**
 * Created by changmin on 2017. 12. 16..
 */
public class BJ1561 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int children = sc.nextInt();
        int machine = sc.nextInt();
        int[] rides = new int[machine];
        for (int i = 0; i < machine; i++) {
            rides[i] = sc.nextInt();
        }

        int output = findLastRide(children, machine, rides);
        System.out.println(output);
    }

    public static int findLastRide(int children, int ride, int[] a) {
        if(children <= ride){//기기 수 보다 사람이 적으면
            return children;
        }

        long left = 0;
        long right = 2000000000L * 1000000L;// 사람의 수 * 운행시간 분은 만들어 준다

        while(left <= right){
            long mid = (left + right) / 2;
            long begin, end;
            begin = end = 0;

            //0분에 탄 아이들은 기계 수 만큼이다
            end = ride;

            //mid분까지 탄 학생의 수
            for(int i = 0; i < ride; ++i){
                end += mid/a[i];
            }
            begin = end;

            //mid분에 탄 학생의 수는 뺀다
            for(int i =0 ; i < ride; ++i){
                if(mid % a[i] == 0){
                    begin -= 1;
                }
            }

            //한명 탔을 때 부터를 고려
            begin += 1;

            if(children < begin){// 그 보다 작으면 이전 시간을 찾아 본다.
                right = mid - 1;
            } else if(children > end){//크다면 이후 시간을 찾는다.
                left = mid + 1;
            } else{// begin보다 크거나 같거나 end보다는 작은 경우
                for (int i = 0; i < ride; ++i){
                    if(mid % a[i] == 0){//탄 사람
                        if(children == begin){//
                            return i + 1;//제로 인덱스이나 놀이기가구는 1부터 시작이다
                        }
                        //다음으로 탄사람을 고려
                        begin += 1;
                    }
                }
            }

        }

        return 0;
    }

}
