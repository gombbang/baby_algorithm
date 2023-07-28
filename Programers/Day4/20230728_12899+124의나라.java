// 11 42
// 12 44
// 13 111
class Solution {
    private String[] str = new String[4];
    public String solution(int n) {
        str[0] = "4";
        str[1] = "1";
        str[2] = "2";
        int t;
        int a;
        String answer = "";
        while (n>0) {
            answer = str[n%3] + answer;
            if (n %3 == 0)
                a = 1;
            else a =0;
            n = n/3 - a;
        }
        return answer;
    }
}
