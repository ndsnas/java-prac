import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * LINK https://www.hackerrank.com/challenges/torque-and-development/problem?
     * isFullScreen=true
     * 
     * 
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * following parameters: 1. INTEGER n 2. INTEGER c_lib 3. INTEGER c_road 4.
     * 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        cities.stream().forEach(city -> {
            graph[city.get(0)].add(city.get(1));
            graph[city.get(1)].add(city.get(0));
        });
        boolean[] visited = new boolean[n + 1];
        long cost = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] != true) {
                int numOfNodes = dfs(i, graph, visited);
                cost += Math.min((numOfNodes * c_lib), (c_lib + ((numOfNodes - 1) * c_road)));
            }
        }

        return cost;

    }

    private static int dfs(int src, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[src] = true;
        int numOfNodes = 1;
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited[graph[src].get(i)] != true) {
                numOfNodes += dfs(graph[src].get(i), graph, visited);
            }
        }
        return numOfNodes;
    }

}

public class RoadLibrary {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt).collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);
                System.out.println("ans: " + result);
                // bufferedWriter.write(String.valueOf(result));
                // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}

// Sample Input

// 2
// 3 3 2 1
// 1 2
// 3 1
// 2 3
// 6 6 2 5
// 1 3
// 3 4
// 2 4
// 1 2
// 2 3
// 5 6