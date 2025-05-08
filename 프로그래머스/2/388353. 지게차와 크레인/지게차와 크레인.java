import java.util.*;

class Point {
    int y;
    int x;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        String[][] map = new String[storage.length+2][storage[0].length()+2];
        
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                map[i][j] = ".";
            }
        }
        
        for (int i=0; i<storage.length; i++) {
            for (int j=0; j<storage[0].length(); j++) {
                map[i+1][j+1] = storage[i].charAt(j) +"";
            }
        }
        
        for (int i=0; i<requests.length; i++) {
            if (requests[i].length() == 1) {
                forkLift(requests[i], map);
            } else {
                crane(requests[i].charAt(0) + "", map);
            }
        }
        return leftContainerCnt(map);
    }
    public void printMap(String[][] map) {
        for (int i=0; i<map.length; i++) {
                for (int j=0; j<map[0].length; j++) {
                    System.out.print(map[i][j]+"");
                }
                System.out.println();
            }
    }
    /*
        Map내부의 모든 target들을 크레인으로 제거
    */
    public int leftContainerCnt(String[][] map) {
        int cnt = 0;
         for (int i=0; i<map.length; i++) {
                for (int j=0; j<map[0].length; j++) {
                    if (!map[i][j].equals(".")) {
                        cnt++;
                    }
                }
            }
        return cnt;
    }
    
    public void crane(String target, String[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if(map[i][j].equals(target)) {
                    map[i][j] = ".";
                }
            }
        }
    }
    
    /*
        창고 외부와 연결된 target들을 지게차로 제거
    */
    public void forkLift(String target, String[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        ArrayDeque<Point> que = new ArrayDeque<>();
        ArrayList<Point> targetList = new ArrayList<>();
        
        visited[0][0] = true;
        que.offer(new Point(0,0));
        
        while (!que.isEmpty()) {
            Point nowPoint = que.poll();
            // System.out.println(map[nextY][nextX])
            for (int i=0; i<4; i++) {
                int nextY = nowPoint.y + directions[i][0];
                int nextX = nowPoint.x + directions[i][1];
            
                if (nextX < 0 || nextY < 0 || nextY >= map.length || nextX >= map[0].length || (!map[nextY][nextX].equals(target) && !map[nextY][nextX].equals(".")) || visited[nextY][nextX] == true) {
                    continue;
                }
                
                visited[nextY][nextX] = true;
                if (map[nextY][nextX].equals(".")) {
                    // 방문 처리후 que에 넣기
                    que.offer(new Point(nextY, nextX));
                }
                if (map[nextY][nextX].equals(target)) {
                    targetList.add(new Point(nextY, nextX));
                }
            }
            
        }
        
        for (Point p : targetList) {
            map[p.y][p.x] = ".";
        }
    }
}