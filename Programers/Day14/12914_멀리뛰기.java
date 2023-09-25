import java.util.*;

class Solution {
    private long[] answers;
    // start : 0
    // end : n
    public long solution(int n) {
        answers = new long[n+1];
        answers[1] = 1;
        if (n>=2)
            answers[2] = 2;
        
        for (int i = 3; i <= n;i++) {
            if (i<=n) {
                answers[i] = answers[i-1] + answers[i-2];
                answers[i] %= 1234567;
            }
        }
        return answers[n];
    }
}

// 1부터 시작
// 각 기회를 배열에 담아둠
// 배열의 인덱스 수는 해당 남은 칸수에서 얻을 수 있는 모든 가능 수
