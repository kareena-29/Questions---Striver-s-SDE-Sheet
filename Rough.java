public class Rough {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        sb.append(c);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("abcd");
        String s = "abcd";
        String ans = "";
        StringBuilder sb3 = new StringBuilder();
        if (sb.toString().compareTo(s) < 0) {
            ans = s;
            sb3 = new StringBuilder(s);
            sb3.append(s.substring(2));
        }
        System.out.println(ans);
        System.out.println(sb3.toString());
        System.out.println(s.substring(1, 2));

    }
}
