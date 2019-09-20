package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseCalenderII {
    int white = 0, gray = 1, black = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
//        int[] precursors = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) precursors[i] = i;
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        // get the adjacent table
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] a : prerequisites) {
            adj.get(a[0]).add(a[1]);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == white) {
                boolean acyclic = dfs(stack, visited, adj, i);
                if (!acyclic) return new int[0];;
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pollLast();
        }
        return res;
    }

    private boolean dfs(LinkedList<Integer> stack, int[] visited,
                     List<List<Integer>> adj, int v) {
            visited[v] = gray;
            List<Integer> adjL = adj.get(v);
            for (Integer next : adjL) {
                if (visited[next] == gray) return false;
                if (visited[next] == white) {
                    boolean acyclic = dfs(stack, visited, adj, next);
                    if (!acyclic) return false;
                }
            }
            visited[v] = black;
            stack.push(v);
            return true;
    }

    public static void main(String[] args) {
        CourseCalenderII t = new CourseCalenderII();
        int[][] toTest = null;
//        toTest = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        toTest = new int[][]{{1,0},{1,2},{2,1}};
        System.out.println(Arrays.toString(
                t.findOrder(4, toTest)));
    }
}
