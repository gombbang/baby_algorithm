import java.util.*;

// // 前의 방법 (start, end)
// // 前의 방법에서 end를 2로 수정
// // 後를 3으로 이동
// // 前의 방법으로 start를 2로 end를 3으로 수정

class Solution {
    private List<List<int[]>> resultList = new ArrayList<>();
    private List<int[]> result;
    
    public int[][] solution(int n) {
        
        while (resultList.size() < n) {
            result = new ArrayList<int[]>();
            int size = resultList.size();
            int[] t = new int[2];
            if ( resultList.size() == 0) {
                t[0] = 1;
                t[1] = 3;
                result.add(t);
            } else {
                move(1,3,2);
                t[0] = 1;
                t[1] = 3;
                result.add(t);
                move(2,1,3);
            }
            resultList.add(result);
        }
        int[][] answer = new int[resultList.get(n-1).size()][2];
        int index = 0;
        for (int[] x : resultList.get(n-1)) {
            answer[index][0]= x[0];
            answer[index++][1] = x[1];
        }
        
        return answer;
    }
    private void move (int start, int bypass, int end) {
        List<int[]> r = resultList.get(resultList.size()-1);
        int[] target;
        int[] array = new int[4];
        array[1] = start;
        array[2] = bypass;
        array[3] = end;
        
        for(int[] arr : r) {
            target = new int[2];
            target[0] = array[arr[0]];
            target[1] = array[arr[1]];
            result.add(target);
        }
    }
}



// // 1,3
// // 1,2 | 1,3 | 2,3
// // 1,3 1,2 3,2 | 1,3 | 2,1 
// // 

// class Solution {
//     private List<int[][]> resultList = new ArrayList<>();
//     private int[][] result;
//     // result의 index에서 시작
//     // 계속 convert한 값 추가
//     // 끝
//     private int move (int start, int end, int bypass, int length, int index) {
//         int[][] before = resultList.get(length-1);
//         int[] array = new int[4];
//         int res = 0;
//         array[1] = start;
//         array[2] = bypass;
//         array[3] = end;
        
//         int j = 0;
        
//         for (int i = index ; i< 226 ; i++) {
//             if (before.length <= j) {
//                 break;
//             }
//             else {
//                 before[i][0] = array[before[j][0]];
//                 before[i][1] = array[before[j][1]];
//                 res ++;
//                 j++;
//             }
//         }
        
//         // get from data
//         // convert data
//         // output
        
//         // return last of array index
//         return res;
//     }
    
//     private void job (int n) {
//         int index=0;
//         if (n>=1) {
//             index = move(1,2,3,n,0);
//             result[index][0] = 1;
//             result[index][1] = 3;
//             move(2,3,1,n,index+1);
//         } else {
//             result[index][0] = 1;
//             result[index][1] = 3;
//         }
//     }
    
//     public int[][] solution(int n) {
//         int size = resultList.size();
        
//         while (size < n) {
//             if (size == 0)
//                 result = new int[1][2];
//             else 
//                 result = new int[size*size + 2*size+1][2];
            
//             job(size);
            
            
//             // do job
//             resultList.add(result);
//             size += 1;
//         }
        
//         // int[][] answer = {};
        
        
        
//         return resultList.get(n-1);
//     }
// }
