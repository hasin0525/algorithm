package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] cross = new int[8];
    static boolean[][] visited;
    static char[][] grid2;
    static int rowMax, colMax, answer = 0;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
  
    private static void dfs(int r, int c, int count) {
        if (count == 2) {
            int temp = 0;
            for (int i = 0; i < 8; i++) {
            	if(cross[i] > 0) {
            		temp = temp + ((i * 2 + 1) * 2 -1) * cross[i];
            	}
            }
            answer = Math.max(answer, temp);
            return;
        }
        if (c >= colMax) {
            dfs(r + 1, 0, count);
            return;
        }
        if (r >= rowMax) {
            return;
        }
        if (grid2[r][c] == 'B'){
            dfs(r,c+1,count);
            return;
        }
            for (int i = 0; i < 8; i ++) {
                boolean isOk = true;
                for (int k = 0; k < 4; k++) {
                    int nextR = r;
                    int nextC = c;
                    if(visited[nextR][nextC]) {
                    	break;
                    }
                    for (int j = 1; j <= i; j++) {
                        nextR += dr[k];
                        nextC += dc[k];
                        if (nextR < 0 || nextR >= rowMax || nextC < 0 || nextC >= colMax
                                || grid2[nextR][nextC] == 'B' || visited[nextR][nextC]) {
                            isOk = false;
                            break;
                        }
                    }
                    if (!isOk) {
                        break;
                    }
                }
                if (isOk) {
                    for (int k = 0; k < 4; k++) {
                        int nextR = r;
                        int nextC = c;
                        visited[nextR][nextC] = true;
                        for (int j = 1; j <= i; j++) {
                            nextR += dr[k];
                            nextC += dc[k];
                            visited[nextR][nextC] = true;
                        }
                    }
                    cross[i] += 1;
                    dfs(r, c + 1, count + 1);
                    cross[i] -= 1;
                    for (int k = 0; k < 4; k++) {
                        int nextR = r;
                        int nextC = c;
                        visited[nextR][nextC] = false;
                        for (int j = 1; j <= i; j++) {
                            nextR += dr[k];
                            nextC += dc[k];
                            visited[nextR][nextC] = false;
                        }
                    }
                }
            }
        dfs(r, c + 1, count);
    }

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        rowMax = grid.length;   
        colMax = grid[0].length();
        grid2 = new char[rowMax][colMax];

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                grid2[i][j] = grid[i].charAt(j);
            }
        }
        
        visited = new boolean[rowMax][colMax];
        //dfs(2,4,0);
        dfs(0, 0, 0);
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);
        System.out.println(result);

        scanner.close();
    }
}
