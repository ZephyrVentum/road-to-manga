package miscellanea.leetcode;

public class EggDropWith2EggsAndNFloors {

    public static void main(String[] args) {
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(42));
    }

    public int twoEggDrop(int n) {
        return (int) (0.5 + (Math.sqrt(2*n)));
    }
}
