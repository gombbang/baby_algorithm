// 예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로, 집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다.
//집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.
// 다중집합 -> min max
// 

// 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다
// 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.

// 2개씩 끊어서 집합으로, 중복허용, 영어가 아닌 게 있으면 버린다.
// 끊은걸로 비교
// * 65536

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        String temp = null;
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < str1.length()-1; i++ ) {
            temp = isPossible(char1[i], char1[i+1]);
            if ( temp != null) {
                if (map1.get(temp) == null)
                    map1.put(temp,1);
                else 
                    map1.put(temp,map1.get(temp)+1);
            }
        }
        for (int i = 0; i < str2.length()-1; i++ ) {
            temp = isPossible(char2[i], char2[i+1]);
            if ( temp != null ) {
                if (map2.get(temp) == null)
                    map2.put(temp,1);
                else 
                    map2.put(temp,map2.get(temp)+1);
            }
        }
        
        int n = 0;
        int u = 0;
        
            // 교집합
        for (String key : map1.keySet()) {
            if (map2.get(key) != null)
                n += Math.min(map1.get(key), map2.get(key));
        }
            // 합집합
        for (String key : map1.keySet()) {
            if (map2.get(key) == null) {
                u += map1.get(key);
            }
            else
                u += Math.max(map1.get(key), map2.get(key));
        }
        for (String key : map2.keySet()) {
            if (map1.get(key) == null) 
                u += map2.get(key);
        }
        
        answer = (int)(Math.floor((double)n/u * 65536));
        if (answer == 0 && u == 0)
            return 65536;
        else 
            return answer;
    }
        
    private String isPossible(char c1, char c2) {
        String result = null;
        if (c1 <= 'z' && c1 >= 'a') {
            result = "" + (char)(c1 - 32);
        } else if (c1 <= 'Z' && c1 >= 'A') {
            result = "" + c1;
        } else 
            return null;
        
        if (c2 <= 'z' && c2 >= 'a') {
            result += (char)(c2 - 32);
        } else if (c2 <= 'Z' && c2 >= 'A') {
            result += c2;
        } else
            return null;
        
        return result;
    }
}
