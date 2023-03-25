package miscellanea.leetcode;

public class EggDropWith2EggsAndNFloors {

    public static void main(String[] args) {
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(42));
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop2(42));
    }

    public int twoEggDrop(int n) {
        return (int) (0.5 + (Math.sqrt(2 * n)));
    }

    public int twoEggDrop2(int n) {
        return (int) Math.ceil((-1.0 + Math.sqrt(1 + 8 * n)) / 2.0);
    }
}
