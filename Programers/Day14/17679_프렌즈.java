class Solution {
    boolean[][] visit;
    int count;
    char[][] boards;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        visit = new boolean[m][n];
        count = 0;
        
        boards = new char[m][n];
        
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0; j < n ; j ++) {
                boards[i][j] = board[i].charAt(j);
            }
        }
        
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0; j < n ; j ++) {
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }
        
        
        
        for (int i = 0; i<m; i ++) {
            for (int j = 0 ; j<n; j++) {
                if (boards[m-1-i][j] != "") {
                    check(m-1-i, j);
                    countSum(); // count 올려서 합치고 초기화
                }
            }
        }
        
        return answer;
    }
    
    private void check (int m, int n) {
        if ()
    }
    
    private void checkUpperLeft(m,n) {
        if (m-1< )
    }
}
// 타겟 기준 좌상 우상 우하 좌하 4개를 체크
    // 위에서부터 체크하자, (m-1, 0) -> (m-1, j) -> (m-1-i, j)
        // 첫번째 인자 : 위로 올라감
        // 두번째 인자 : 오른쪽으로 나아감

// 발생시 재귀로 -> 갯수 총합 (boolean으로 해서 체크하고 다시 지우자. nope, 그 위치의 배열값을 null로 처리 하면서 내리는 작업을 해줘야함)
// 끝나면 밑으로 내리기
// 
