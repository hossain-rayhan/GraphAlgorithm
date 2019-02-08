//DFS-- using stack
//Use the previous helper classes- GraphPrint, Vertex, and Neighbor
//USe the input file: input_dfs.txt

import java.util.Stack;

public class DFS{
	public Vertex[] vertices;
	
	public static void main(String[] args){
		DFS myDFS = new DFS("input_dfs.txt");
		myDFS.runDFS();
	}
	public DFS(String inputFile){
		Graph graph = new Graph(inputFile);
		//graph.printGraph();

		vertices = graph.getVertices();
				
	}

	public void runDFS(){
		Stack<Vertex> stack =  new Stack<>();

		stack.push(vertices[0]);
		vertices[0].isVisited = true;

		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			System.out.print("--> " + v.val);
			
			for(Neighbor nbr = v.nbr; nbr != null; nbr = nbr.next){
				if(!vertices[nbr.vertexNumber].isVisited){
					stack.push(vertices[nbr.vertexNumber]);
					vertices[nbr.vertexNumber].isVisited = true;
				}
			}
		}
		System.out.println();
	}
}
