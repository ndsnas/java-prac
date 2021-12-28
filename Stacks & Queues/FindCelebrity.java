import java.util.Stack;

public class FindCelebrity {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 1 },
                           { 1, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 1, 1, 1, 0 }
                         };
        findCelebrity(matrix);
    }

    public static void findCelebrity(int[][] matrix) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {
            stack.push(i);
        }

        while (stack.size() >= 2) {
            int p1 = stack.pop();
            int p2 = stack.pop();

            if (matrix[p1][p2] == 1) {
                // if p1 knows p2 --> p1 is not a celeb
                stack.push(p2);
            } else {
                // if p1 doesn't know p2 --> p2 is not a celeb
                stack.push(p1);
            }
        }

        if (!stack.isEmpty()) {
            int potentialCeleb = stack.peek();
            // checking in potential celeb's row and col
            for (int i = 0; i < matrix.length; i++) {
                if (i != potentialCeleb) {
                    if (matrix[potentialCeleb][i] == 1 || matrix[i][potentialCeleb] == 0) {
                        System.out.println("No one is a celeb.");
                        return;
                    }
                }
            }
            System.out.println("Celeb --> " + stack.pop());
        }

    }
}
