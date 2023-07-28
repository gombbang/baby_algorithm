import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    private List<String> tempAnswer = new ArrayList<>();
    private Map<String,Integer> map = new HashMap<>();
    
    private void comb( char[] origin, Boolean[] visited, int cursor, int course) {
        String str = "";
        if (course == 0) {
            for (int i = 0; i<origin.length; i++) { 
                if (visited[i] != null) {
                    if (visited[i]) {
                        str += origin[i];
                    }
                }
            }
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            str = String.valueOf(temp);
            
            if(map.get(str) != null)
                map.replace(str,map.get(str)+1);
            else
                map.put(str,1);
            return;
        }
        
        if (cursor == origin.length)
            return;
        
        visited[cursor] = true;
        comb(origin,visited,cursor+1,course-1);
        visited[cursor] = false;
        comb(origin,visited,cursor+1,course);
        
        return;
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i = 0 ; i<course.length; i++) {
            int max = -1;
            for (String order : orders) {
                char[] o = order.toCharArray();
                Boolean[] visited = new Boolean[o.length];
                
                if (o.length >= course[i]) {
                    comb(o,visited,0,course[i]);
                }
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                }
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) == max && max>=2) {
                    tempAnswer.add(key);
                }
            }
            
            map.clear();
        }
        String[] arr = tempAnswer.toArray(new String[tempAnswer.size()]);
        Arrays.sort(arr);
        answer = arr;
        return answer;
    }
}
