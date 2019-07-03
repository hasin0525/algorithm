import java.util.Scanner;

public class Main {
    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int r, c, m, result;
    static int[][] map;
    static Scanner sc = new Scanner(System.in);
    static Shark[] sharkList;
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, 1, -1 };

    public static void main(String[] args) {
        r = sc.nextInt();
        c = sc.nextInt();
        m = sc.nextInt();
        map = new int[r][c];
        sharkList = new Shark[m + 1]; // 0은 안쓴다.
        for (int i = 1; i <= m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            sharkList[i] = new Shark(r - 1, c - 1, s, d, z);
            // 이 위치에 상어가 존재하냐? 값은 상어배열의 인덱스
            map[r - 1][c - 1] = i;
        }
        // 낚시왕이 열을 이동한다.
        for (int i = 0; i < c; i++) {
            // 낚시왕이 상어를 잡아먹는다.
            eating(i);
            // 상어가 이동한다.
            sharkMoving();
        }
        // 다 끝나면 잡은 상어크기를 출력한다.
        System.out.println(result);
    }

    public static void eating(int col) {
        for (int i = 0; i < r; i++) {
            // 만약 상어가 존재한다면
            if (map[i][col] != 0) {
                result += sharkList[map[i][col]].z;
                // 상어값을 지운다.
                map[i][col] = 0;
                break;
            }
        }
    }

    public static void sharkMoving() {
        for (int i = 1; i <= m; i++) {
            // 상어의 존재여부를 확인해서 없는거면 지워버린다.
            if (sharkList[i] != null && map[sharkList[i].r][sharkList[i].c] == 0) {
                sharkList[i] = null;
            } else if (sharkList[i] != null) {
                moving(i);
                // 움직임 끝내면
                map[sharkList[i].r][sharkList[i].c] = 0;
            }
        }
        // 그 후 다시 돌려서 map의 값을 수정해줘야한다.
        for (int i = 1; i <= m; i++) {
            // 문제는 이러고서 거기에 들어있는 다른 값은 지워야한다.
            if (sharkList[map[sharkList[i].r][sharkList[i].c]].z > sharkList[i].z) {
                // 내가 더 작다면 내가 먹힌다.
                sharkList[map[sharkList[i].r][sharkList[i].c]].z += sharkList[i].z;
                sharkList[i] = null;
            } else {
                map[sharkList[i].r][sharkList[i].c] = i;
                sharkList[i].z += sharkList[map[sharkList[i].r][sharkList[i].c]].z;
                sharkList[map[sharkList[i].r][sharkList[i].c]] = null;
            }
        }
    }

    public static void moving(int index) {
        Shark shark = sharkList[index];
        int x = shark.r;
        int y = shark.c;
        int direction = shark.d;
        // 속도일 동안에 한칸씩 움직이면서 만약 그다음이 벽이면 반대로 가게한다.
        for (int i = 0; i < shark.s; i++) {
            x = x + dx[direction];
            y = y + dy[direction];
            // 벽인 경우를 확인 후 방향 다시 설정해서 이동
            if (x < 0 || x >= r || y < 0 || y >= c) {
                x = x - dx[direction];
                y = y - dy[direction];
                if (direction == 1 || direction == 3) {
                    direction++;
                } else {
                    direction--;
                }
                x = x + dx[direction];
                y = y + dy[direction];
            }
        }
    }
}