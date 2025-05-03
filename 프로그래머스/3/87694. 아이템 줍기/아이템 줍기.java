import java.util.*;
// Enum을 사용하지 않는 코드가 더 작성하기 편함
enum Direction {
    D(-1,0),U(1,0),R(0,1),L(0,-1);
    private int y;
    private int x;
    
    Direction(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getX() {
        return this.x;
    }
}

class Point {
    int y;
    int x;
    int cnt;
    Direction d;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
        this.cnt = 0;
    }
    
    Point(int y, int x, int cnt, Direction d) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.d = d;
    }
}

class Solution {
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    // System.out.println();
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // map 채우기
        for (int ri=0; ri<rectangle.length; ri++) {
            int lx = 2 * rectangle[ri][0];
            int ly = 2 * rectangle[ri][1];
            int rx = 2 * rectangle[ri][2];
            int ry = 2 * rectangle[ri][3];
            for (int x=lx; x<=rx; x++) {
                map[ly][x] = 1;
                map[ry][x] = 1; 
            }
            
            for (int y=ly+1; y<ry; y++) {
                map[y][lx] = 1;
                map[y][rx] = 1; 
            }
        }
        
        // 테두리만 남기기
        for (int ri=0; ri<rectangle.length; ri++) {
            int lx = 2 * rectangle[ri][0];
            int ly = 2 * rectangle[ri][1];
            int rx = 2 * rectangle[ri][2];
            int ry = 2 * rectangle[ri][3];
            for (int x=lx+1; x<rx; x++) {
                for (int y=ly+1; y<ry; y++) {
                    map[y][x] = 0; 
                }
            }
            
            
        }
        
        ArrayDeque<Point> que = new ArrayDeque<>();
        que.offer(new Point(characterY * 2, characterX * 2));
        visited[characterY * 2][characterX * 2] = true;
        
        while(!que.isEmpty()) {
            Point nowP = que.poll();
            
            // bfs로 이동하다가 아이템을 만나면 return (최단거리)
            if (nowP.y == itemY * 2 && nowP.x == itemX * 2) {
                return nowP.cnt/2;
            }
            
            for (Direction d : Direction.values()) {
                int nextY = nowP.y + d.getY();
                int nextX = nowP.x + d.getX();
                
                
                if (nextY < 0 || nextX < 0 || nextY >= 102 || nextX >= 102 || map[nextY][nextX] == 0 || visited[nextY][nextX] == true) {
                    continue;
                }
                
                // 만약 시계 반대 방향으로 90도 회전 가능하면 해당 방향으로 진행
                Point nextP = new Point(nextY, nextX, nowP.cnt+1, d);
                visited[nextP.y][nextP.x] = true;
                que.offer(nextP);
            }
        }
        
        
        // bfs로 진행 -> 정답 나오면 return
        for (int i=0; i<20; i++) {
            for (int j=0; j<20; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print(" ");
            for (int j=0; j<20; j++) {
                if (visited[i][j]) {
                    System.out.print("1 ");    
                }
                else {
                    System.out.print("0 ");    
                }
            }
            System.out.println();
        }
        
        return answer;
    }
}