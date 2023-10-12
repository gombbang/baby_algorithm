// +6
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp2[0] = sequence[0];
        
        for (int i = 0 ; i<sequence.length; i++) {
            if (i%2 == 0) dp1[i] = sequence[i] * -1;
            else    dp1[i] = sequence[i];
        }
        for (int i = 0 ; i<sequence.length; i++) {
            if (i%2 == 0) dp2[i] = sequence[i];
            else    dp2[i] = sequence[i] * -1;
        }
        
        
        
        for ( int i = 1; i<sequence.length; i++) {
            if (dp1[i-1] + dp1[i] > dp1[i])
                dp1[i] = dp1[i-1] + dp1[i];
            
            if (dp2[i-1] + dp2[i] > dp2[i])
                dp2[i] = dp2[i-1] + dp2[i];
        }
        
        for (long i : dp1) {
            if (answer < i)
                answer = i;
        }
        for (long i : dp2) {
            if(answer < i)
                answer = i;
        }
        
        return answer;
    }
}

// dp의 핵심은 divide and conquer ?
