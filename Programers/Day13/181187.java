// x or y의 최솟값과 최대값을 구해야함

import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long max;
        long min;
        // answer = quarter(r1,r2);
        
        for (int i = r2; i> 0; i--) {
            max = (long)Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)));
            min = (long)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
            answer += (max-min+1);
        }
        
        // answer += (r2-r1+1);
        
        
        
        return answer*4;
    }
    // private long quarter(int r1, int r2) {
    //     long x = 0;
    //     long y = r2;
    //     long result = 0;
    //     double xy = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    //     // for (int i = 0 ; x <= over; i++) {
    //     //     while ((x * x) + (y * y) >= (over * over) && y > 0) {
    //     //         result ++;
    //     //         y= y-1;
    //     //     }
    //     //     y = r2 - i;
    //     //     x++;
    //     //     if (y < r1)
    //     //         break;
    //     // }
    //     while (y > 0) {
    //             // System.out.println(" y : " + y);
    //         while(xy >= (double)r1
    //              && xy <= (double)r2
    //              && y > 0) {
    //             // System.out.println("xy : " + xy + ", y : " + y + ", x : " + x);
    //             y--;
    //             xy = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    //             result ++;
    //         }
    //         x = x+1;
    //         y = (long)Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(x,2)));
    //         xy = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    //     }
    //     return result;
    // }
}
