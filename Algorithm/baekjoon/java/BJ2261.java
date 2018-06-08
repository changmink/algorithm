package baekjoon.java;

//틀렸습니다.

import java.util.*;
public class BJ2261 {
    static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Point[] p = new Point[n];

       for(int i = 0; i < n; ++i){
           p[i] = new Point(sc.nextInt(), sc.nextInt());
       }
       //정렬 하고 넘겨 준다.
       Arrays.sort(p, new Comparator<Point>() {
           @Override
           public int compare(Point o1, Point o2) {
               if(o1.x == o2.x) return Integer.compare(o1.y, o2.y);
               else return Integer.compare(o1.x, o2.x);
           }
       });

       int output = closestPair(p, 0, n-1);
       System.out.println(output);
   }

    private static int closestPair(Point[] p, int start, int end) {
       int length = end - start + 1;
       if(length <= 3){
           int output = Integer.MAX_VALUE;
           for(int i = start; i <= end-1; ++i){
               for(int j = i+1; j <= end; ++j){
                   output = Math.min(output, getDist(p[i], p[j]));
               }
           }
           return output;
       }else{
           // 반으로 재귀
           int mid = (start + end) / 2;
           int left = closestPair(p, start, mid);
           int right = closestPair(p, mid + 1, end);

           //양쪽에서 작은거로 선택
           int output = Math.min(left, right);

           //중앙 값들 비교하기
           int dist = getRangeMin(output, start, end, p);

           // 최종 비교
           return Math.min(output, dist);
       }

    }

    private static int getRangeMin(int output, int start, int end, Point[] p) {
        List<Point> list = new ArrayList<>();
        //거리가 중심으로 부터 output보다 작은 것만 고르기
        int mid = (start + end) / 2;
        for(int i = start; i <= end; ++i){
            if(getDist(p[i], p[mid]) < output)
                list.add(p[i]);
        }

        //y기준으로 정렬
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });

        //선택된것 끼리 비교한다. 가장 작은거 리턴
        for(int i = 0; i < list.size() - 1; ++i){
            for(int j = i+1; j < list.size(); ++j){
                int y = list.get(i).y - list.get(j).y;
                if(y * y < output){
                    int dist = getDist(list.get(i), list.get(j));
                    output = Math.min(dist, output);
                }else break;
            }
        }
        return output;
    }

    private static int getDist(Point p1, Point p2) {
       int x = Math.abs(p1.x - p2.x);
       int y = Math.abs(p1.y - p2.y);
       return x*x + y*y;
    }
}
