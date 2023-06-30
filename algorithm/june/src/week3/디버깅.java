package week3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            v = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ey = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            answer=Integer.MAX_VALUE;

            if(y==ey && x==ex){
                System.out.println(0);
                continue;
            }
            q = new LinkedList<>();
            // 나이트의 끝점
            map[ey][ex] = 1;

            q.offer(new int[]{y, x,1});

            BFS(q);

        }
    }

    private static void BFS(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] yx = q.poll();
            int y = yx[0];
            int x = yx[1];
            int cnt=yx[2];
            v[y][x]=true;

            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && 0 <= nx && ny < N && nx < N && !v[ny][nx]) {
                    if(map[ny][nx]==1){
                        System.out.println(cnt);
                        return;
                    }

                    v[ny][nx]=true;
                    q.offer(new int[] {ny,nx,cnt+1});
                }
            }

        }
    }
}
