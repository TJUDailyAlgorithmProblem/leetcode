package 图论;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/11/2 9:30
 */
public class _797 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int[][] g;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        cur.add(0);
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n - 1) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i1 : g[i]) {
            cur.add(i1);
            dfs(i1);
            cur.remove(cur.size() - 1);
        }
    }
}
