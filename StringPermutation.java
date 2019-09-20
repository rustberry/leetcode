import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class StringPermutation {
    TreeSet<String> res = new TreeSet<>();
    
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> result = new ArrayList<>();
       if (str == null) return result;
       String[] strA = new String[str.length()];
       int i = 0;
       for (char c : str.toCharArray()) {
           strA[i] = String.valueOf(c);
           i++;
       }
       System.out.println("strA: " + Arrays.toString(strA));
       perHelper(strA, 0);
       result.addAll(res);
       return result;
    }
    
    private void perHelper(String[] strA, int begin) {
        if (begin == strA.length - 1) {
            StringBuilder sb = new StringBuilder(strA.length);
            for (String s : strA) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = begin; i < strA.length; i++) {
            // swap begin and i
            String temp = strA[begin];
            // if (temp.equals(strA[i])) continue;
            strA[begin] = strA[i];
            strA[i] = temp;
            
            perHelper(strA, begin+1);
            
            temp = strA[begin];
            strA[begin] = strA[i];
            strA[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        StringPermutation test = new StringPermutation();
        String t = "aa";
        test.Permutation(t);
        System.out.println(test.res);
    }
}