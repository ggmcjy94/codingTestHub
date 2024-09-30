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



    static class StudyClass implements Comparable<StudyClass>{
        int start, end;

        public StudyClass(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(StudyClass o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        PriorityQueue<StudyClass> studyClasses = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            studyClasses.offer(new StudyClass(start, end));
        }
        //3
        //0 40
        //5 10
        //15 30

        PriorityQueue<Integer> wait = new PriorityQueue<>();
        StudyClass studyClass = studyClasses.poll();
        assert studyClass != null;
        wait.offer(studyClass.end);
        int cnt = 1;
        while (!studyClasses.isEmpty()) {
            StudyClass peek = studyClasses.peek();
            if (!wait.isEmpty() && wait.peek() > peek.start) {
                cnt++;
                StudyClass poll = studyClasses.poll();
                wait.offer(poll.end);
            } else {
                StudyClass poll = studyClasses.poll();
                wait.offer(poll.end);
                wait.poll();
            }

        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
