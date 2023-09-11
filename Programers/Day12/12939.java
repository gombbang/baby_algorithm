// + 1점

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strs = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int cur;
        for (String str : strs) {
            cur = Integer.valueOf(str);
            if (cur < min)
                min = cur;
            if (cur > max)
                max = cur;
        }
        answer = min + " " + max;
        return answer;
    }
}
