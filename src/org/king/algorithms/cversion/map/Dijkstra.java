package org.king.algorithms.cversion.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}
}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		// visit each vertex u, always visiting vertex with smallest minDistance
		// first
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				// relax the edge (u,v);

				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					// remove v from queue
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU;
					v.previous = u;
					// re-add v to queue
					vertexQueue.add(v);
				}

			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		Vertex v0 = new Vertex("Harrisburg");
		Vertex v1 = new Vertex("Baltimore");
		Vertex v2 = new Vertex("Washington");
		Vertex v3 = new Vertex("Philadelphia");
		Vertex v4 = new Vertex("Binghamton");
		Vertex v5 = new Vertex("Allentown");
		Vertex v6 = new Vertex("New York");
		v0.adjacencies = new Edge[] { new Edge(v1, 79.83), new Edge(v5, 81.15) };
		v1.adjacencies = new Edge[] { new Edge(v0, 79.75), new Edge(v2, 39.42),
				new Edge(v3, 103.00) };
		v2.adjacencies = new Edge[] { new Edge(v1, 38.65) };
		v3.adjacencies = new Edge[] { new Edge(v1, 102.53),
				new Edge(v5, 61.44), new Edge(v6, 96.79) };
		v4.adjacencies = new Edge[] { new Edge(v5, 133.04) };
		v5.adjacencies = new Edge[] { new Edge(v0, 81.77), new Edge(v3, 62.05),
				new Edge(v4, 134.47), new Edge(v6, 91.63) };
		v6.adjacencies = new Edge[] { new Edge(v3, 97.24), new Edge(v5, 87.94) };
		Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6 };

		computePaths(v0);
		for (Vertex v : vertices) {
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
			System.out.println("Path: " + path);
		}
	}

}
