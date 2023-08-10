import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        System.out.println(solution(t));
    }

    private static Character solution(String t) {
        Map<Character,Integer> app = new HashMap<>();
        for (char c : t.toCharArray()) {
            char lowC = Character.toLowerCase(c);
            app.put(lowC, app.getOrDefault(lowC, 0)+1);
        }
        ArrayList<Character> arrayList = new ArrayList<>(app.keySet());
        arrayList.sort((o1, o2) -> app.get(o2).compareTo(app.get(o1)));
        if (arrayList.size() > 1 &&Objects.equals(app.get(arrayList.get(0)), app.get(arrayList.get(1)))) {
            return '?';
        }
        return Character.toUpperCase(arrayList.get(0));
    }
}