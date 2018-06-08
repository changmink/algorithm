package baekjoon.java;

import java.io.*;
import java.util.*;

/**
 * Created by changmin on 2018. 4. 9..
 */
public class BJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        for(int cmd = 0; cmd < n; ++cmd){
            String command = br.readLine();
            if(command.startsWith("push")){
                String[] sub = command.split("_")[1].split(" ");
                if("front".equals(sub[0])){
                    list.add(Integer.parseInt(sub[1]));
                }else{//back
                    list.add(0, Integer.parseInt(sub[1]));
                }
            }else if(command.startsWith("pop")){
                String pos = command.split("_")[1];
                if(pos.equals("front")){
                    if(list.isEmpty())
                        output.append(-1);

                    else output.append(list.remove(list.size()-1));
                }else{//back
                    if(list.isEmpty())
                        output.append(-1);

                    else output.append(list.remove(0));
                }
                output.append("\n");
            }else{
                switch (command){
                    case "size":
                        output.append(list.size());
                        break;

                    case "empty":
                        int isEmpty = (list.isEmpty())? 1 : 0;
                        output.append(isEmpty);
                        break;

                    case "front":
                        if(list.isEmpty()){
                            output.append(-1);
                        }
                        else{
                            output.append(list.get(list.size()-1));
                        }
                        break;

                    case "back":
                        if(list.isEmpty()){
                            output.append(-1);
                        }else{
                            output.append(list.get(0));
                        }
                        break;

                    default:
                        break;
                }
                output.append("\n");
            }

        }
        System.out.println(output);
    }
}
