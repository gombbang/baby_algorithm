import java.util.*;

class Solution {
    
    int[][] map;
    int[][] t;
    
    private class Node {
        List<Pos> puzzle;
        
        public Node (List<Pos> puzzle) {
            this.puzzle = puzzle;
        }
        
        public Node () {}
         
    }
    
    private class Pos {
        int x;
        int y;
        
        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        map = game_board;
        t= table;
        int answer = 0;
        
        List<Node> nodeList = checkBoard(map,0);
        List<Node> tableList = checkBoard(t,1);
        
        for (int i = 0 ; i<nodeList.size(); i++) {
            int nodeSize = nodeList.get(i).puzzle.size();
            
            for (int j = 0 ; j<tableList.size(); j++) {
                if (tableList.get(j).puzzle.size() == nodeSize)
                    if (checkPuzzle(nodeSize,nodeList.get(i),tableList.get(j))) {
                        nodeList.remove(i--);
                        tableList.remove(j);
                        answer += nodeSize;
                        break;
                    }
            }
        }
        

        
        
        
        return answer;
    }
    
    boolean checkPuzzle (int size, Node board, Node table ) {
        if (size <= 2)
            return true;
        else {
            movePuzzle(board);
            movePuzzle(table);
            
            for (int i = 0; i <= 3 ; i ++) {
                if (checkSame(board, table))
                    return true;
                else {
                    rotate(table);
                    movePuzzle(table);
                }
            }
            return false;
        }
    }
    
    Node rotate (Node table) {
        List<Pos> puzzle = new ArrayList<>();
        
        int[][] tempMap = new int[6][6];
        for (Pos pos : table.puzzle) {
            int temp = pos.x; // 이거 안해서 난리났었음
            pos.x = tempMap.length - 1 - pos.y;
            pos.y = temp;// 이거 안해서 난리났었음
        }
        
        return new Node(puzzle);
    }
    
    void movePuzzle (Node node) {
        int minY = node.puzzle.get(0).y;
        int minX = node.puzzle.get(0).x;
        for (Pos pos : node.puzzle) {
            if (minX > pos.x)
                minX = pos.x;
            if (minY > pos.y)
                minY = pos.y;
        }
        
        for (Pos pos : node.puzzle) {
            pos.y -= minY;
            pos.x -= minX;
        }
    }
    
    boolean checkSame(Node g, Node t) {
        int[][] map1 = new int[6][6];
        int[][] map2 = new int[6][6];
        
        for (Pos pos :g.puzzle) {
            map1[pos.x][pos.y] = 1;
        }
        for (Pos pos :t.puzzle) {
            map2[pos.x][pos.y] = 1;
        }
        
        for (int i = 0; i<6; i++) {
            for (int j = 0; j<6; j++) {
                if (map1[i][j] != map2[i][j])
                    return false;
            }
        }
        return true;
    }
    
    
    List<Node> checkBoard(int[][] map, int flag) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0 ; i < map.length; i ++) {
            for (int j = 0; j <map[i].length;j++) {
                if (map[i][j] == flag) {
                    nodeList.add(makePuzzle(map,i,j,flag));
                }
            }
        }
        return nodeList;
    }
    
    private Node makePuzzle (int[][] map, int startX, int startY, int flag) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(startX,startY));
        
        Node node = new Node();
        
        List<Pos> puzzle = new ArrayList<>();
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        
        while (!q.isEmpty()) {
            Pos pos = q.poll(); 
            if (map[pos.x][pos.y] == flag) {
                if (flag == 0)
                    map[pos.x][pos.y] = 1;
                else 
                    map[pos.x][pos.y] = 0;
                puzzle.add(pos);

                for (int i = 0; i<4;i++) {
                    if (pos.x + dx[i] > -1 && pos.x + dx[i] < map.length) {
                        if (pos.y + dy[i] > -1 && pos.y + dy[i] < map[0].length) {
                            if (map[ pos.x + dx[i] ][ pos.y + dy[i] ] == flag) {
                                q.add(new Pos(pos.x + dx[i],pos.y + dy[i]));
                            }
                        }
                    }
                }
            }
        }
        
        node.puzzle = puzzle;
        
        return node;
    }
    
}
