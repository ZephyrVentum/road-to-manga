package miscellanea;

public class RansomNote {
    public static void main(String[] args) {
        String ransom = "onedollar";
        String magazine = "aonetwodollarz";
        int[] magazineBucket = new int[26];
        char[] magazineChars = magazine.toCharArray();
        for (int i = 0; i < magazineChars.length; i++) {
            int indexInBucket = (int) magazineChars[i] - 'a';
            magazineBucket[indexInBucket]++;
        }
        char[] ransomChars = ransom.toCharArray();
        for (int i = 0; i < ransomChars.length; i++) {
            int indexInBucket = (int) ransomChars[i] - 'a';
            if (magazineBucket[indexInBucket] > 0) {
                magazineBucket[indexInBucket]--;
            } else {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

//    public static void
}
