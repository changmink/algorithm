package baekjoon.java;

import java.util.*;

class Meeting{
    int start;
    int end;
}
public class BJ1931 {

    public static int maxScheduleMeeting(Meeting[] meetings){
        List<Meeting> list = new ArrayList<>();

        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end)
                    return Integer.compare(o1.start, o2.start);
                return Integer.compare(o1.end, o2.end);
            }
        });

        list.add(meetings[0]);

        for(int i = 1; i < meetings.length; ++i){
            if(list.get(list.size()-1).end <= meetings[i].start){
                list.add(meetings[i]);
            }
        }

        return list.size();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Meeting[] meetings = new Meeting[n];

        for(int i = 0; i < n; ++i){
            Meeting meeting = new Meeting();
            meeting.start = scanner.nextInt();
            meeting.end = scanner.nextInt();

            meetings[i] = meeting;
        }

        int output = maxScheduleMeeting(meetings);
        System.out.println(output);
    }
}
