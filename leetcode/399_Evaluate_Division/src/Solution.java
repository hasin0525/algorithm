import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
	Map<List<String>, Double> valueList;
	Map<String, Map<String, Double>> graph;
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		graph = new HashMap<>();
		valueList = new HashMap<>();
		int index = 0;
		for (List<String> equation : equations) {
			graph.putIfAbsent(equation.get(0),new HashMap<>());
			graph.get(equation.get(0)).putIfAbsent(equation.get(1), values[index]);
			graph.putIfAbsent(equation.get(1),new HashMap<>());
			graph.get(equation.get(1)).putIfAbsent(equation.get(0), Math.pow(values[index++], -1));
			
			List<String> eq = new ArrayList<>();
			eq.add(equation.get(0));
			eq.add(equation.get(0));
			valueList.putIfAbsent(eq, 1.0);
			eq = new ArrayList<>();
			eq.add(equation.get(1));
			eq.add(equation.get(1));
			valueList.putIfAbsent(eq, 1.0);
		}
		for(Map.Entry<String, Map<String, Double>> e : graph.entrySet()) {
            	dfs(e.getKey(),e.getValue(), 1.0, new HashSet<String>());
		}
		
		for(Map.Entry<List<String>, Double> e : valueList.entrySet()) {
        	System.out.println(e.getKey().get(0) + " " + e.getKey().get(1) + ": " + e.getValue());
		}	
		
		double[] answer = new double[queries.size()];
		int answerIndex = 0;
		for(List<String> query : queries) {
			answer[answerIndex++] = valueList.getOrDefault(query, -1.0); 
		}
		return answer;
	}
	private void dfs(String start, Map<String, Double> nextList, double value, Set<String> visited) {
		visited.add(start);
		for(Map.Entry<String, Double> next : nextList.entrySet()) {
			if(!visited.contains(next.getKey())) {
				visited.add(next.getKey());
				List<String> equation = new ArrayList<>();
				equation.add(start);
				equation.add(next.getKey());
				valueList.putIfAbsent(equation, value * next.getValue());
				dfs(start, graph.get(next.getKey()), value * next.getValue(), visited);
			}
		}
	}
}