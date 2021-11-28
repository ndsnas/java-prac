// https://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/
public class EgyptianFraction {
    public static void main(String[] args) {
        solution(12, 13);
        System.out.println();
        solution(2, 3);
        System.out.println();
        solution(6, 14);
    }

    // if input is 12/13 then we need to find 1/x which is lesser than 12/13 i.e.
    // 12/13 > 1/x and subtract it from 12/13. Repeat it recursively.
    // so if solve the above equation then it is basically
    // taking the ceiling value of dr/nr and subtract from the given fraction
    public static void solution(int nr, int dr) {
        if (nr == 1) {
            System.out.print("1/" + dr);
            return;
        }

        if (dr % nr == 0) {
            System.out.print("1/" + dr / nr);
            return;
        }

        int y = (dr / nr + 1);
        System.out.print("1/" + y + "+");
        solution((nr * y - dr), dr * y);
    }
}