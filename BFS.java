// Java program for implementation of Breadth First Search in Graphs 
class Graph 
{ 
	private int V; 
	private LinkedList<Integer> adjlist[]; 
 
	Graph(int v) 
	{ 
		V = v; 
		adjlist = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adjlist[i] = new LinkedList(); 
	} 

	// Function to add an edge
	void addEdge(int v,int w) 
	{ 
		adjlist[v].add(w); 
	} 

	// prints BFS traversal from source s 
	void BFS(int s) 
	{ 
		boolean visited[] = new boolean[V];  
		LinkedList<Integer> queue = new LinkedList<Integer>();  
		visited[s]=true; 
		queue.add(s); 
		while (queue.size() != 0) 
		{  
			s = queue.poll(); 
			System.out.print(s+" "); 
			Iterator<Integer> i = adjlist[s].listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next(); 
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 
	} 

	// Main Function 
	public static void main(String args[]) 
	{ 
		Graph g = new Graph(3); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 

		System.out.println("Following is Breadth First Traversal "+ 
						"(starting from vertex 1)"); 
		g.BFS(1); 
	} 
} 
