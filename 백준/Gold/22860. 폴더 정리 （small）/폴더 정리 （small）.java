import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N,M,Q, K,R,C;
    static int[][] tree, dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static  class Folder {
        String folderName;
        int fileCnt;
        HashSet<String> files = new HashSet<>();
        ArrayList<Folder> children = new ArrayList<>();

        public Folder(String folderName) {
            this.folderName = folderName;
        }

        public void addFolder(Folder folder) {
            children.add(folder);
        }

        public void addFile(String name) {
            files.add(name);
            fileCnt++;
        }

        public void mergeFiles(Folder other) {
            files.addAll(other.files);
            fileCnt += other.fileCnt;
        }
    }
    static HashMap<String, Folder> folderHashMap = new HashMap<>();
    public static Folder getFolder(String folderName) {
        if (folderHashMap.containsKey(folderName)) return folderHashMap.get(folderName);
        Folder folder = new Folder(folderName);
        folderHashMap.put(folderName, folder);
        return folder;
    }

    public static void dfs(Folder now) {
        for (Folder next : now.children) {
            dfs(next);
            now.mergeFiles(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String f1 = st.nextToken();
            String f2 = st.nextToken();
            int fileExists = Integer.parseInt(st.nextToken());
            Folder folder = getFolder(f1);
            if (fileExists == 0) {
                folder.addFile(f2);
            } else {
                Folder other = getFolder(f2);
                folder.addFolder(other);
            }
        }

        dfs(getFolder("main"));


        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i<Q; i++) {
            String s = br.readLine();
            int index = s.lastIndexOf("/");
            String folderName = s.substring(index + 1);
            Folder folder = getFolder(folderName);
            bw.write(folder.files.size() + " " + folder.fileCnt +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
