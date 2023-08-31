import java.util.*;

class Solution {
    Set<Integer> set = new TreeSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        for (int i = 1; i<=elements.length;i++) {
            getData(elements,i);
        }
        System.out.println();
        return set.size();
    }
    
    private void getData(int[] e, int count) {
        int sum = 0;
        for (int start = 0 ; start<=e.length-1;start++) {
            for (int j = 0 ; j<count ; j++) {
                if (start+j >= e.length)
                    sum+= e[start+j - e.length];
                else sum += e[start+j];
            }
            set.add(sum);
            sum = 0;
        }
    }
}
// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=heartflow89&logNo=220994601249
