// 1순위 : 해당 시작 시간
// 2순위 : 가장 최근에 멈춘 과제
// [0] : name
// [1] : start
// [2] : 소요시간
// 시작시간으로 sort 안되어있음
// return 끝낸 과제 순서

// 정렬
// 
// 중간 내용 -> map, key : name  => stack

import java.util.*;

class Solution {
    public class Pair {
        String name;
        int time;
        
        Pair(String name, int time) {
            this.name=name;
            this.time = time;
        }
        
        int getTime() {
            return this.time;
        }
        String getName() {
            return this.name;
        }
    }
    
    public String[] solution(String[][] plans) {
        Stack<Pair> stack = new Stack<>();
        int[] now = new int[2];
        String[] nowS;
        int[] nextTime = new int[2];
        String[] nextTimeS;
        int workingTime; 
        int left;
        
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans, new Comparator<String[]> () {
            @Override
            public int compare(String[] o1, String[] o2) {
                String[] o1Time = o1[1].split(":");
                String[] o2Time = o2[1].split(":");
                
                return Integer.valueOf(o1Time[0])!=Integer.valueOf(o2Time[0]) ? Integer.valueOf(o1Time[0])-Integer.valueOf(o2Time[0]) : Integer.valueOf(o1Time[1])-Integer.valueOf(o2Time[1]);
            }
        });
//         now = plans[0][1].split(":");
//         stack.add(new Pair(plans[0][0],Integer.valueOf(plans[0][2])));
        
//         while (!stack.isEmpty()) {
//             Pair pair = stack.pop();
            
//         }
        
        for (int i = 0; i<plans.length;i++) {
            if (i < plans.length - 1) {
                
                nowS = plans[i][1].split(":");
                for (int  j = 0; j<nowS.length;j++)
                    now[j] = Integer.valueOf(nowS[j]);
                    
                
                nextTimeS = plans[i+1][1].split(":");
                for (int  j = 0; j<nextTimeS.length;j++)
                    nextTime[j] = Integer.valueOf(nextTimeS[j]);
                 
            } else {
                nextTimeS = plans[i][1].split(":");
                for (int  j = 0; j<nextTimeS.length;j++)
                    nextTime[j] = Integer.valueOf(nextTimeS[j]);
            }
            
               
            if (now[0] < nextTime[0])
                nextTime[1] = nextTime[1] + (nextTime[0]-now[0]) *60;
            workingTime = nextTime[1] - now[1];

            if (workingTime < Integer.valueOf(plans[i][2])) {
                left = Integer.valueOf(plans[i][2]) - workingTime;
                stack.add(new Pair(plans[i][0],left));
                continue;
            } else if (workingTime == Integer.valueOf(plans[i][2])) {
                answer.add(plans[i][0]);
                continue;
            }
            else {
                answer.add(plans[i][0]);
                left = workingTime - Integer.valueOf(plans[i][2]);
                 if (!stack.isEmpty()) {
                    Pair canWork = stack.pop();
                    if (canWork.getTime() < left) {
                        answer.add(canWork.getName());
                        left = left - canWork.getTime();
                        while(!stack.isEmpty()) {
                            canWork = stack.pop();
                            if (left < canWork.getTime()) {
                                stack.add(new Pair(canWork.getName(), canWork.getTime() - left));
                                break;
                            } else if (left == canWork.getTime()) {
                                answer.add(canWork.getName());
                            } else {
                                answer.add(canWork.getName());
                                left = left - canWork.getTime();
                            }
                        }
                    } else if (canWork.getTime() == workingTime - Integer.valueOf(plans[i][2])) {
                        answer.add(canWork.getName());
                        continue;
                    }
                    else {
                        stack.add(new Pair(canWork.getName(),canWork.getTime()- (workingTime - Integer.valueOf(plans[i][2]))));
                    }
                 }
            }
            
        }
        
        while (!stack.isEmpty())
            answer.add(stack.pop().getName());
        
        
        String[] ret = new String[answer.size()];
        for (int i = 0; i<answer.size();i++)
            ret[i] = answer.get(i);
        
        return ret;
    }
}
