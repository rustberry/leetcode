package Leetcode;

import java.util.*;
import org.apache.commons.lang3.tuple.MutablePair;

/**
 * [[1,0]]  [[1,0],[0,1]]
 * {{0,1}, {0,2}, {1,2}}
 */
public class CourseCalender {
    final int white = 0, gray = 1, black = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        // init
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        // adj tables
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != white) continue;
            boolean acyclic = dfs(visited, i, adj);
            if (!acyclic) return false;
        }
        return true;
    }

    private boolean dfs(int[] visited, int v, List<List<Integer>> adj) {
        visited[v] = gray;
        List<Integer> verts = adj.get(v);
        for (int to : verts) {
            if (visited[to] == gray) return false;  // found a back end!
            if (visited[to] == white) {
                boolean acyclic = dfs(visited, to, adj);
                if (!acyclic) return false;
            }
        }
        visited[v] = black;
        return true;
    }

    public boolean canFinishPracticeCommons(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        // init
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        // adj tables
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
        }
        List<MutablePair<Integer, Integer>> verts = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            verts.add(new MutablePair<>(i, white));
        }
//        int white = 0, gray = 1, black = 2;
        for (int i = 0; i < numCourses; i++) {
            MutablePair<Integer, Integer> v = verts.get(i);
            if (v.getValue() != white) continue;
            boolean acyclic = dfs(v, adj, verts);
            if (!acyclic) return false;
        }
        return true;
    }

    private boolean dfs(MutablePair<Integer,Integer> v, List<List<Integer>> adj, List<MutablePair<Integer, Integer>> verts) {
        v.setValue(gray);
        List<Integer> a = adj.get(v.getLeft());
        if (a.size() == 0) {
            v.setValue(black);
            return true;
        }
        for (int j = 0; j < a.size(); j++) {
            int color = verts.get(a.get(j)).getRight();
            if (color == gray) return false;
            if (color == white) {
                boolean acyclic = dfs(verts.get(a.get(j)), adj, verts);
                if (!acyclic ) return false;
            }
        }
        v.setValue(black);
        return true;
    }



    public static void main(String[] args) {
        CourseCalender t =new CourseCalender();
        int[][] g = new int[][] {{0,1},{0,2},{1,2}};
        System.out.println(
                t.canFinish(3, g)
        );
    }
}
