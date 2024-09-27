import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected, arr;
    static int[][] map;
    static boolean[] used;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int white = 0;
    static int blue = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP

    //8
    //6 15 21
    //7 20 25
    //1 3 8
    //3 2 14
    //8 6 27
    //2 7 13
    //4 12 18
    //5 6 20

    // 2 14 1
    // 3 8  2
    // 6 20 3
    // 6 27 4
    // 7 13 5
    // 12 18
    // 15 21
    // 20 25

    static class StudyClass implements Comparable<StudyClass>{
        int no, startTime, endTime;

        public StudyClass(int no, int startTime, int endTime) {
            this.no = no;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "StudyClass{" +
                    "no=" + no +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        @Override
        public int compareTo(StudyClass o) {
            return this.startTime - o.startTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N  = Integer.parseInt(br.readLine());

        PriorityQueue<StudyClass> studyClasses = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            studyClasses.offer(new StudyClass(no,start,end));
        }
        int cnt = 1;
        StudyClass firstStudyClass = studyClasses.poll();
        PriorityQueue<Integer> waits = new PriorityQueue<>();
        waits.offer(firstStudyClass.endTime);
        while (!studyClasses.isEmpty()) {
            if (waits.peek() > studyClasses.peek().startTime) {
                StudyClass poll = studyClasses.poll();
                waits.offer(poll.endTime);
                cnt++;
            } else {
                StudyClass poll = studyClasses.poll();
                waits.offer(poll.endTime);
                waits.poll();
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
