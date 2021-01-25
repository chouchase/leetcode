package leetcode.no399;

/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
*/

import java.util.*;

public class Solution {
    private static class Edge {
        private String adj;
        private double value;

        public Edge(String adj, double value) {
            this.adj = adj;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dem = equations.get(i).get(0);
            String num = equations.get(i).get(1);
            if (!map.containsKey(dem)) {
                map.put(dem, new ArrayList<>());
            }
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(dem).add(new Edge(num, values[i]));
            map.get(num).add(new Edge(dem, 1.0 / values[i]));

        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i ++) {
            List<String> query = queries.get(i);

            if(!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))){
                res[i] = -1.0;
                continue;
            }
            Set<String> isVisited = new HashSet<>();
            isVisited.add(query.get(0));
            res[i] = dfs(query.get(0),query.get(1),1.0, isVisited,map);
        }
        return res;
    }
    private double dfs(String cur, String target, double lastRes, Set<String> isVisited,Map<String,List<Edge>> graph){
        if(cur.equals(target)){
            return lastRes;
        }
        double res = - 1.0;
        for(Edge edge: graph.get(cur)){
            if(!isVisited.contains(edge.adj)){
                isVisited.add(edge.adj);
                res = dfs(edge.adj,target,lastRes * edge.value,isVisited,graph);
                if(Math.abs(res + 1.0) > 1e-6){
                    return res;
                }
            }
        }
        return res;
    }
    private static class Domain{
        private List<List<String>> equations;
        private double[] value;
        private List<List<String>> queries;

        public List<List<String>> getEquations() {
            return equations;
        }

        public void setEquations(List<List<String>> equations) {
            this.equations = equations;
        }

        public double[] getValue() {
            return value;
        }

        public void setValue(double[] value) {
            this.value = value;
        }

        public List<List<String>> getQueries() {
            return queries;
        }

        public void setQueries(List<List<String>> queries) {
            this.queries = queries;
        }
    }
    public static void main(String[] args) /*throws JsonProcessingException*/ {
       /* ObjectMapper objectMapper = new ObjectMapper();
        String str = "{\"equations\":[[\"x1\",\"x2\"],[\"x2\",\"x3\"],[\"x3\",\"x4\"],[\"x4\",\"x5\"]]," +
                "\"value\":[3.0,4.0,5.0,6.0]," +
                "\"queries\":[[\"x1\",\"x5\"],[\"x5\",\"x2\"],[\"x2\",\"x4\"],[\"x2\",\"x2\"],[\"x2\",\"x9\"],[\"x9\",\"x9\"]]}";
        Domain domain = objectMapper.readValue(str, Domain.class);
        double[] res = new Solution().calcEquation(domain.getEquations(),domain.getValue(),domain.getQueries());
        System.out.println(Arrays.toString(res));
*/
    }
}
