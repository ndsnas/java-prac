
//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class JourneyToTheMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }

    public static class Result {

        /*
         * Complete the 'journeyToMoon' function below.
         *
         * The function is expected to return an INTEGER. The function accepts following
         * parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY astronaut
         */

        public static long journeyToMoon(int n, List<List<Integer>> astronaut) {

            ArrayList<Integer>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (List<Integer> a : astronaut) {
                graph[a.get(0)].add(a.get(1));
                graph[a.get(1)].add(a.get(0));
            }
            // System.out.println(Arrays.toString(graph));
            boolean[] visited = new boolean[n];

            ArrayList<ArrayList<Integer>> countryWiseAstronautsList = new ArrayList<ArrayList<Integer>>();
            long ans = 0;
            int size = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> output = new ArrayList<>();
                if (graph[i].size() != 0 && !visited[i]) {
                    dfs(i, visited, graph, output);
                }

                else {
                    if (visited[i] == false) {
                        output.add(i);
                    }
                }
                if (output.size() != 0) {
                    if (flag == false) {
                        size = output.size();
                        flag = true;
                    } else {
                        ans += size * output.size();
                        size += output.size();
                    }
                }
                countryWiseAstronautsList.add(output);
            }
            // System.out.println(ans);
            // System.out.println(size);
            return ans;

        }

        public static void dfs(int src, boolean[] visited, ArrayList<Integer>[] graph, ArrayList<Integer> output) {
            visited[src] = true;
            output.add(src);
            for (int i = 0; i < graph[src].size(); i++) {
                if (visited[graph[src].get(i)] == false)
                    dfs(graph[src].get(i), visited, graph, output);
            }
        }

    }
}

// 100000 2
// 1 2
// 3 4

// output: 4999949998

// 10 7
// 0 2
// 1 8
// 1 4
// 2 8
// 2 6
// 3 5
// 6 9

// output: 23