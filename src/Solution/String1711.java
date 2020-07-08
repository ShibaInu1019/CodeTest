package Solution;

public class String1711 {

    public int findClosest(String[] words, String word1, String word2) {
        if (words.length == 0)
            return 0;

        int a = -1, b = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            if (words[i].equals(word2)) {
                b = i;
            }
            if (a != -1 && b != -1)
                min = Math.min(min, Math.abs(b - a));
        }
        return min;
    }
}
