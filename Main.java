import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(reorganizeString("abccab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("abcdeeeee"));
        System.out.println(reorganizeString("avaaavv"));

    }

    public static String reorganizeString(String s) {
        int n = s.length(), p = -1, k = -2;
        int[] letters  = new int[26];
        Character[] chars = new Character[n];
        char[] res = new char[n];

        for(int i = 0; i < n; i++){
            letters[s.charAt(i)-'a']++;
            chars[i] = s.charAt(i);
        }

        for(int i = 0; i < 26; i++) {
            if (letters[i] > (n + 1) / 2)
                return "";
        }

        Arrays.sort(chars, new Comparator<Character>(){
            @Override
            public int compare(Character ch1,Character ch2){
                return letters[ch1 - 'a'] == letters[ch2 - 'a'] ? ch1 - ch2 : letters[ch2 - 'a'] - letters[ch1 - 'a'];
            }
        });

        while(true){
            k += 2;
            p++;
            res[k] = chars[p];

            if(k == n-1 || k == n-2){
                if(p == n-1)
                    break;
                else
                    k = -1;
            }
        }
        return new String(res);
    }
}
