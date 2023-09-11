class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int xCount = 0;
        int oCount = 0;
        char[][] cMap = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            char[] cs = board[i].toCharArray();
            
            for (int j = 0; j < cs.length;j++) {
                cMap[i][j]= cs[j];
                if (cMap[i][j] == 'O')
                    oCount++;
                else if (cMap[i][j] == 'X')
                    xCount++;
            }
        }
        if (oCount - xCount < 0)
            return 0;
        else if (oCount == xCount && oCount == 0)
            return 1;
        else {
            // O가 이김 혹은 무승부
            String a = fight(cMap);
            
            if (oCount - xCount == 1) {
                if (a.equals("draw")) {
                    return 1;
                }
                else if (a.equals("win"))
                    return 1;
                else return 0;
            }
            // O가 짐 혹은 무승부
            else if (oCount - xCount == 0) {
                if (a.equals("lose"))
                    return 1;
                else if (a.equals("draw"))
                    return 1;
                else
                    return 0;
            } else 
                return 0;
        }
    }
    
    // 
    private String fight(char[][] cMap) {
        // 8가지 조건중 하나라도 충족된 O 나 X 가 있음
        //     1개 초과시 실패
        //     O와 X가 동시에 성공하는 경우가 생겨도 실패
        char target;
        boolean success = false;
        int[][] count = new int[2][3];
        
        char[] targets = {'O','X'};
        
        for (int l = 0; l < 2 ; l++) {
            target = targets[l];
            for (int i = 0; i<cMap.length; i++) {
                for (int j = 0; j<cMap.length; j++) {
                    if (target == cMap[i][j])
                        success = true;
                    else {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    if (count[l][0] > 0) {
                        return "error";
                    } else
                        count[l][0]++;
                }
                success = false;
            }
            
            for (int i = 0; i<cMap.length; i++) {
                for (int j = 0; j<cMap.length; j++) {
                    if (target == cMap[j][i])
                        success = true;
                    else {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    if (count[l][1] > 0) {
                        return "error";
                    } else
                        count[l][1]++;
                }
                success = false;
            }
            if (cMap[0][0] == cMap[1][1] && cMap[1][1] == cMap[2][2] && cMap[2][2] == target) 
                count[l][2] ++;
            if (cMap[0][2] == cMap[1][1] && cMap[1][1] == cMap[2][0] && cMap[2][0] == target)
                count[l][2] ++;
        }
        
        int sumCountO = count[0][0] + count[0][1] + count[0][2];
        int sumCountX = count[1][0] + count[1][1] + count[1][2];
        
        
        if (sumCountO == 0 && sumCountX <= 2 && sumCountX > 0)
            return "lose";
        else if (sumCountO <= 2 && sumCountX == 0 && sumCountO > 0)
            return "win";
        else if (sumCountO == 0 && sumCountX == 0) 
            return "draw";
        else 
            return "error";
    }
}
// o - x 가 1 혹은 0이 아닐때
// 이기거나 질 때의 상황
// O가 이김 : o - x == 1 && o가 이기는 상황
// O가 짐 : o - x == 0 && x가 이기는 상황
// 14점
