import java.util.Queue;
import java.util.LinkedList;

class Solution {
    final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    
    public int solution(int[][] maps) {
        int height = maps.length;
        int width = maps[0].length;
        
        boolean[][] checked = new boolean[height][width];
        Queue<Position> q = new LinkedList<Position>();
        q.offer(new Position(0,1,1));
        q.offer(new Position(1,0,1));
        
        while(!q.isEmpty()){
            Position next = q.poll();
            int nextX = next.curX;
            int nextY = next.curY;
            if(nextX == height - 1 && nextY == width -1){
                return next.distance + 1;
            }
            
            if(nextX >= height
               || nextX < 0
               || nextY >= width
               || nextY < 0
               || maps[nextX][nextY] == 0 
               || checked[nextX][nextY]
              ){
                continue;
            }
            checked[nextX][nextY] = true;
            q.offer(getNewPosition(next, NORTH, next.distance+1));
            q.offer(getNewPosition(next, EAST, next.distance+1));
            q.offer(getNewPosition(next, SOUTH, next.distance+1));
            q.offer(getNewPosition(next, WEST, next.distance+1));
        }
        
        
        return -1;
    }
    
    private Position getNewPosition(Position now, int position, int distance){
        Position newPosition = new Position(now.curX,now.curY, distance);
        if(position == NORTH){
            newPosition.curX--;
        }
        if(position == SOUTH){
            newPosition.curX++;
        }
        if(position == WEST){
            newPosition.curY--;
        }
        if(position == EAST){
            newPosition.curY++;
        }
        return newPosition;
    }
    class Position {
        int curX;
        int curY;
        int distance;
        
        Position(int curX, int curY, int distance){
            this.curX = curX;
            this.curY = curY;
            this.distance = distance;
        }
    }
}