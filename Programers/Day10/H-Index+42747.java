import java.util.*;
// 인용된 논문의 수 >= h
// 나머지 논문이 인용수 <= h
// h : 인용된 횟수

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int h = 0;
        int time = 0;
        while (true) {
            for (int i = citations.length-1; i>= 0; i--) {
                if (h>citations[i])
                    break;
                else
                    time ++;
            }
            if (time<h) 
                break;
            time = 0;
            h++;
        }
        return h-1;
    }
}
// https://dev-musa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Level-2-H-Index-%EC%BD%94%ED%8B%80%EB%A6%B0
