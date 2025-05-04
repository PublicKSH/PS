// 1. game_board와 table에서 블럭 조각을 추출 -> 2 * 50 * 50
// 2. 완전탐색 (빈공간의 개수 : M, 조각의 개수 : N, 회전 : 4) -> 4 * N * M 의 연산으로 블럭 조각 끼우기 => map의 크기 상 충분히 가능
// blank_piece 와 block_piece가 같은지 => 2차원 배열로 piece를 관리
// 실수한 부분 : piece를 정사각형으로 관리
import java.util.*;

class Point {
    int y;
    int x;
    Point (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

// 시간 복잡도 줄이기 -> length, size로 hasing
class Piece {
    int size;
    int w;
    int h;
    int[][] board;
    boolean used;
    Piece(int size, int h, int w) {
        this.size = size;
        this.w = w;
        this.h = h;
        this.board = new int[h][w];
        this.used = false;
    }
    
    // 다른 조각이랑 모양이 같은지 확인
    boolean isSame(Piece oP) {
        if (this.used == false && oP.used == false) {
            int[][] otherPieceBoard = new int[oP.h][oP.w];
            for (int i = 0; i<oP.h; i++) {
                for (int j = 0; j<oP.w; j++) {
                    otherPieceBoard[i][j] = oP.board[i][j];
                }
            }
            
            // 코드 if문 하나 더 넣기 싫어서 ti 4 -> 5
            for (int ti =0; ti<5; ti++) {
                boolean isSame = true;
                otherPieceBoard = turn90(otherPieceBoard);

                // todo : otherPieceBoard 와 board의 가로,세로가 다르면 비교 하지 않기
                if (this.h != otherPieceBoard.length || this.w != otherPieceBoard[0].length) {
                    continue;
                }
                
                for (int i = 0; i< this.h; i++) {
                    for (int j = 0; j< this.w; j++) {
                        if (this.board[i][j] != otherPieceBoard[i][j]) {
                            isSame = false;
                        }
                    }
                }
                
                if (isSame == true) {
                    this.used = true;
                    oP.used = true;
                    return true;
                }
            }
            
            return false;
        }
        else {
            return false;
        }
    }
    
    int[][] turn90 (int[][] board) {
        int[][] turnBoard = new int[board[0].length][board.length];
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                turnBoard[j][board.length-i-1] = board[i][j];
            }
        }
        return turnBoard;
    }
}

class Solution {
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int INF = (int) 1e9;
    static ArrayList<Piece> blankPieces = new ArrayList<>();
    static ArrayList<Piece> blockPieces = new ArrayList<>();
    static public int solution(int[][] game_board, int[][] table) {
        int w = game_board[0].length;
        int h = game_board.length;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (game_board[i][j] == 0) {
                    bfs(i,j,game_board,0);
                }
                if (table[i][j] == 1) {
                    bfs(i,j,table,1);
                }
            }
        }
        
//         System.out.println("blank pieces");
//         for (Piece piece : blankPieces) {
//             for (int i=0; i<piece.h; i++) {
//                 for (int j=0; j<piece.w; j++) {
//                     System.out.print(piece.board[i][j] + " "); 
//                 }   
//                 System.out.println();
//             }
//             System.out.println();
//         }
//         System.out.println("block pieces");
//         for (Piece piece : blockPieces) {
//             for (int i=0; i<piece.h; i++) {
//                 for (int j=0; j<piece.w; j++) {
//                     System.out.print(piece.board[i][j] + " "); 
//                 }   
//                 System.out.println();
//             }
//             System.out.println();
//         }
        
        int answer = 0;
        for (Piece blankPiece : blankPieces) {
            for (Piece blockPiece : blockPieces) {
                // 두 조각이 같은지 4번 돌려가며 확인
                if (blankPiece.isSame(blockPiece)) {
                    answer += blankPiece.size;
                }
            }
        }
        
        return answer;
    }
    

    
    // boardType : 0 = game_board, 1 = table
    static void bfs(int startY, int startX, int[][] board, int boardType) {
        int w = board[0].length;
        int h = board.length;
        ArrayList<Point> pointList = new ArrayList<>();
        ArrayDeque<Point> que = new ArrayDeque();
        
        Point startP = new Point(startY, startX);
        pointList.add(startP);
        que.offer(startP);
        board[startP.y][startP.x] = (boardType == 0 ? 1 : 0);
        while(!que.isEmpty()) {
            Point nowP = que.poll();
            
            for (int i=0; i<4; i++) {
                int nextY = nowP.y + directions[i][0];
                int nextX = nowP.x + directions[i][1];
                
                if (nextY < 0 || nextX < 0 || nextY >= h || nextX >= w || board[nextY][nextX] == (boardType == 0 ? 1 : 0)) {
                    continue;
                }
                
                Point nextP = new Point(nextY, nextX);
                pointList.add(nextP);
                que.offer(nextP);
                board[nextP.y][nextP.x] = (boardType == 0 ? 1 : 0);
            }
        }
        
        // pointList 로 Piece만들기
        int minX = startX;
        int minY = startY;
        int maxX = startX;
        int maxY = startY;
        for (Point p : pointList) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        Piece piece = new Piece(pointList.size(),maxY - minY + 1, maxX - minX + 1);
        for (Point p : pointList) {
            piece.board[p.y - minY][p.x - minX] = 1;
        }
        
        if (boardType == 0) {
            blankPieces.add(piece);
        } else {
            blockPieces.add(piece);
        }
    }
}

