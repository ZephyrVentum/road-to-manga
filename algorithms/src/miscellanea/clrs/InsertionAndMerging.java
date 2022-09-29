package miscellanea.clrs;

import java.math.BigInteger;

public class InsertionAndMerging {

    public static void main(String[] args) {
        BigInteger merging = new BigInteger("0");
        BigInteger insertion =new BigInteger("0");
        int n = 2;
        do {
            n++;
            merging = new BigInteger("" + n);
            merging = merging.pow(8);

            insertion = new BigInteger("2");
            insertion = insertion.pow(n);
            System.out.println("I: " + insertion);
            System.out.println("M: " + merging);
            System.out.println();
        }while (insertion.compareTo(merging) < 0);

        System.out.println(n);
    }
}
