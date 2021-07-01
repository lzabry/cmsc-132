package graphs;

import java.util.*;

/**
 * Implements a graph. We use two maps: one map for adjacency properties
 * (adjancencyMap) and one map (dataMap) to keep track of the data associated
 * with a vertex.
 * 
 * @author cmsc132
 * 
 * @param <E>
 */
public class Graph<E> {
	/* You must use the following maps in your implementation */
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	private HashMap<String, E> dataMap;

	public Graph() {
		adjacencyMap = new HashMap<String, HashMap<String, Integer>>();
		dataMap = new HashMap<String, E>();
	}

	public void addVertex(String vertexName, E data) {
		if (adjacencyMap.containsKey(vertexName) || dataMap.containsKey(vertexName)) {
			throw new IllegalArgumentException("error");
		} else {
			adjacencyMap.put(vertexName, new HashMap<String, Integer>());
			dataMap.put(vertexName, data);
		}
	}

	public void addDirectedEdge(String startVertexName, String endVertexName, int cost) {
		if ((!adjacencyMap.containsKey(startVertexName)) || (!adjacencyMap.containsKey(endVertexName))) {
			throw new IllegalArgumentException("error");
		} else {
			adjacencyMap.get(startVertexName).put(endVertexName, cost);
		}
	}

	@Override
	public String toString() {
		TreeMap<String, HashMap<String, Integer>> adjacency = new TreeMap<String, HashMap<String, Integer>>(
				adjacencyMap);
		TreeMap<String, E> data = new TreeMap<String, E>(dataMap);
		String s = "Vertices: ";
		s += data.keySet().toString();
		s += "\n";
		s += "Edges:";
		for (String t : adjacency.keySet()) {
			s += "\n";
			TreeMap<String, Integer> k = new TreeMap<String, Integer>(adjacency.get(t));
			s += "Vertex(" + t + ")--->" + k.toString();
		}
		return s;
	}

	public Map<String, Integer> getAdjacentVertices(String vertexName) {
		return adjacencyMap.get(vertexName);
	}

	public int getCost(String startVertexName, String endVertexName) {
		return adjacencyMap.get(startVertexName).get(endVertexName);
	}

	public Set<String> getVertices() {
		return dataMap.keySet();
	}

	public E getData(String vertex) {
		if (!dataMap.containsKey(vertex)) {
			throw new IllegalArgumentException("error");
		} else {
			return dataMap.get(vertex);
		}
	}

	public void doBreadthFirstSearch(String startVertexName, CallBack<E> callback) {
		if (!dataMap.containsKey(startVertexName)) {
			throw new IllegalArgumentException("error");
		}
		TreeSet<String> visited = new TreeSet<String>();
		Queue<String> discovered = new LinkedList<String>();
		discovered.add(startVertexName);
		while (!discovered.isEmpty()) {
			String x = discovered.remove();
			if (!visited.contains(x)) {
				visited.add(x);
				callback.processVertex(x, this.getData(x));
				TreeMap<String, Integer> adjacent = new TreeMap<String, Integer>(adjacencyMap.get(x));
				for (String suc : adjacent.keySet()) {
					if (!visited.contains(suc)) {
						discovered.add(suc);
					}
				}

			}

		}

	}

	public void doDepthFirstSearch(String startVertexName, CallBack<E> callback) {
		if (!dataMap.containsKey(startVertexName)) {
			throw new IllegalArgumentException("error");
		}
		TreeSet<String> visited = new TreeSet<String>();
		Stack<String> discovered = new Stack<String>();
		discovered.push(startVertexName);
		while (!discovered.isEmpty()) {
			String x = discovered.pop();
			if (!visited.contains(x)) {
				visited.add(x);
				callback.processVertex(x, this.getData(x));
				TreeMap<String, Integer> adjacent = new TreeMap<String, Integer>(adjacencyMap.get(x));
				for (String suc : adjacent.keySet()) {
					if (!visited.contains(suc)) {
						discovered.add(suc);
					}
				}

			}

		}

	}

	public int doDijkstras(String startVertexName, String endVertexName, ArrayList<String> shortestPath) {
		if ((!adjacencyMap.containsKey(startVertexName)) || (!adjacencyMap.containsKey(endVertexName))) {
			throw new IllegalArgumentException("error");
		}
		TreeMap<String, Integer> costmap = new TreeMap<String, Integer>();
		TreeMap<String, String> predecessormap = new TreeMap<String, String>();
		TreeMap<Integer, String> inversecost = new TreeMap<Integer, String>();
		shortestPath.clear();
		for (String s : dataMap.keySet()) {
			costmap.put(s, 10000);
		}
		costmap.put(startVertexName, 0);
		predecessormap.put(startVertexName, startVertexName);
		inversecost.put(0, startVertexName);
		while (!inversecost.isEmpty()) {
			Integer key = inversecost.firstKey();
			String currentVertex = inversecost.get(key);
			inversecost.remove(key);
			for (String name : getAdjacentVertices(currentVertex).keySet()) {
				if (!shortestPath.contains(currentVertex)) {
					if (costmap.get(currentVertex) + getCost(currentVertex, name) < costmap.get(name)) {
						costmap.put(name, costmap.get(currentVertex) + getCost(currentVertex, name));
						inversecost.put(costmap.get(name), name);
						predecessormap.put(name, currentVertex);
					}
				}
			}
		}
		String currentKey = endVertexName;
		while (currentKey != startVertexName) {
			String currentValue = predecessormap.get(currentKey);
			if (currentValue == null) {
				shortestPath.clear();
				shortestPath.add("None");
				return -1;
			}
			shortestPath.add(0, currentValue);
			currentKey = currentValue;
		}
		shortestPath.add(endVertexName);
		return costmap.get(endVertexName);
	}

}