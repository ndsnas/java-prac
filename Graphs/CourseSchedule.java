
// https://leetcode.com/problems/course-schedule-ii/
// https://iq.opengenus.org/topological-sort-bfs/
import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));

    }

    // Used Kahn's Algo for Topological Sorting
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // first pushing all the zero degree nodes in the queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        // similar to BFS... rather than using visited array here we are using inDegree
        while (queue.size() != 0) {
            int ele = queue.remove();
            ans.add(ele);
            count++;
            for (int i = 0; i < graph[ele].size(); i++) {
                int node = graph[ele].get(i);
                inDegree[node]--;
                // only add to queue if the inDegree is zero
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        // topological sorting is for Directed Acyclic Graphs(DAG)
        // but if there's cycle in the graph the the count of visited nodes won't be
        // equal to number of nodes in the graph and then we can safely say that graph
        // has a cycle
        if (count != numCourses)
            return new int[] {};

        // just converting list to array
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
