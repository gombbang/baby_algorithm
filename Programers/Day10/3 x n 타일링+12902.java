class Solution {
    public int solution(int n) {
        long[] answer = new long[5001];
        answer[2] = 3L;
        answer[0] = 1L;
        long sum = 2;
        for (int i =4; i<n+1; i+=2) {
            answer[i] = (answer[i - 2] * 3 + sum) % 1000000007L;
            sum += answer[i-2] * 2;
        }
        if (n % 2 == 0)
            return (int)(answer[n] % 1000000007);
        else 
            return 0;
    }
}
