import java.io.*;
import java.util.*;

public class Main {
    static class Book implements Comparable<Book>{
        String book;
        int cnt;

        public Book(String book, int cnt) {
            this.book = book;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Book o) {
            if (o.cnt == this.cnt) {
                return this.book.compareTo(o.book);
            }
            return o.cnt-this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) +1);
        }
        List<Book> books = new ArrayList<>();
        for (String s : map.keySet()) {
            books.add(new Book(s, map.get(s)));
        }
        Collections.sort(books);
        bw.write(books.get(0).book);
        bw.flush();
        bw.close();
    }
}