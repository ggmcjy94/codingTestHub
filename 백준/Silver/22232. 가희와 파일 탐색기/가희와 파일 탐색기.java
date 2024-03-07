import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N,M,Q, K,R,C;
    static int[][] tree, dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static class File implements Comparable<File>{
        String name, extend;
        int extAvailable;

        public File(String name, String extend) {
            this.name = name;
            this.extend = extend;
        }

        @Override
        public int compareTo(File file) {

            if (this.name.compareTo(file.name) != 0) {
                return this.name.compareTo(file.name);
            }
            if (this.extAvailable != file.extAvailable) {
                return file.extAvailable - this.extAvailable;
            }
            return this.extend.compareTo(file.extend);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<File> fileList = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            st= new StringTokenizer(br.readLine(),".");
            String name = st.nextToken();
            String extend = st.nextToken();
            fileList.add(new File(name,extend));
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i<M; i++) {
            String ext = br.readLine();
            set.add(ext);
        }

        for (int i = 0; i < N; i++) {
            if (set.contains(fileList.get(i).extend)) {
                fileList.get(i).extAvailable = 1;
            } else {
                fileList.get(i).extAvailable = 0;
            }
        }

        Collections.sort(fileList);

        for (File file : fileList) {
            bw.write(file.name+"."+file.extend+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
