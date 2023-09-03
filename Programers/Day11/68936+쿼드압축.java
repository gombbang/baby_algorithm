// 4개 구역으로 나누어 각 구역에서 처리가 되면 쳐다도 보지 않는다 (각각이 하나의 함수로 돌아야 함)
// start(x,y) end(x,y)
// return 0의 갯수, 1의 갯수
// 총 합 -> return
// [0] = 0의 갯수
// [1] = 1의 갯수

import java.util.*;
class Solution {
    int[][] arr;
    
    private int[] sol (int startX, int startY, int endX, int endY) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        
        for (int i = startX ; i < endX ; i++) {
            for (int j = startY; j < endY ; j++) {
                // System.out.print(arr[i][j]);
                if (arr[i][j] == 0)
                    answer[0] = answer[0]+1;
                else
                    answer[1] = answer[1]+1;
            }
            // System.out.println();
        }
            if (answer[0] == 0) {
                answer[1] = 1;
                
                // System.out.println("special, answer[0] : " + answer[0] + "answer[1] :" + answer[1]);
                return answer;
            } else if (answer[1] == 0) {
                answer[0] = 1;
                // System.out.println("special, answer[0] : " + answer[0] + "answer[1] :" + answer[1]);
            
                return answer;
            }
        
        
            
        // System.out.println("endX-startX :" + (endX-startX));
        // System.out.println("endY-startY :" + (endY-startY));
        
        // 나눠질 수 없음
        if (endX-startX == 2) {
            // System.out.println("answer[0] : " + answer[0] + "answer[1] :" + answer[1]);
            
            return answer;
        }
        else {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;
            
            int[] s1 = sol(startX,startY,midX,midY);
            int[] s2 = sol(midX,startY,endX,midY);
            int[] s3 = sol(startX,midY,midX,endY);
            int[] s4 = sol(midX,midY,endX,endY);
            answer[0] = s1[0] + s2[0] + s3[0] +s4[0];
            answer[1] = s1[1] + s2[1] + s3[1] +s4[1];
            // System.out.println("answer[0] : " + answer[0] + "answer[1] :" + answer[1]);
            return answer;
        }
    }
    
    public int[] solution(int[][] a) {
        arr = a;
        // System.out.println("a.length :" + a.length);
        // System.out.println("a[0].length :" + a[0].length);
        // for (int i = 0 ; i < a.length ; i++) {
        //     for (int j = 0; j < a.length ; j++) {
        //         System.out.print(a[i][j]);
        //         // if (arr[i][j] == 0)
        //         //     answer[0] = answer[0]+1;
        //         // else
        //         //     answer[1] = answer[1]+1;
        //     }
        //         System.out.println();
        // }
        // return null;
        return sol(0,0,a.length,a[0].length);
    }
}
