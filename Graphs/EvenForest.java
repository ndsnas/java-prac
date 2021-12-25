
// https://www.hackerrank.com/challenges/even-tree/problem?isFullScreen=true
// https://www.youtube.com/watch?v=T56efbMposY&ab_channel=HackerRankSolution
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class EvenForest {

    // Complete the evenForest function below.
    public static int ans = 0;

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {

        ArrayList<Integer>[] graph = new ArrayList[t_nodes + 1];

        for (int i = 1; i <= t_nodes; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < t_edges; i++) {
            graph[t_from.get(i)].add(t_to.get(i));
            graph[t_to.get(i)].add(t_from.get(i));
        }

        boolean[] visited = new boolean[t_nodes + 1];

        dfs(visited, 1, graph);
        return ans;
    }

    public static int dfs(boolean[] visited, int node, ArrayList<Integer>[] graph) {
        if (visited[node] == true)
            return 0;

        visited[node] = true;
        int numOfNodesUnderThisNode = 0;
        for (int i = 0; i < graph[node].size(); i++) {
            if (!visited[graph[node].get(i)]) {
                int numOfNodesOfTreeStartingRootedAtI = dfs(visited, graph[node].get(i), graph);
                if (numOfNodesOfTreeStartingRootedAtI % 2 == 0)
                    ans++;
                else
                    numOfNodesUnderThisNode += numOfNodesOfTreeStartingRootedAtI;

            }
        }
        return numOfNodesUnderThisNode + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);
        System.out.println("ans " + res);

        bufferedReader.close();
    }
}

/**
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8

ans==2
 */