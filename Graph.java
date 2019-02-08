import java.util.Scanner;
import java.io.File;

public class Graph {
	Vertex[] vertices;

	public static void main(String[] args){
		Graph myGraph = new Graph("input_graph_print.txt");
		myGraph.printGraph();		
	}
	public Vertex[] getVertices(){
		return vertices;
	}

	public Graph( String fileName){
		try{
			Scanner sc = new Scanner(new File(fileName));
			//scan the vertex number and initialize the vertices array
			vertices = new Vertex[Integer.parseInt(sc.nextLine())];

			//scan the vertex names and create vertices
			for(int i = 0; i < vertices.length; i++){
				vertices[i] = new Vertex(sc.nextLine(), null);
			}
			
			//scan the edges and create neighbors of all vertices
			while(sc.hasNext()){
				String[] edgeVertices = sc.nextLine().split("\\s+");
				int vertex1 = getIndexForVertex(edgeVertices[0]);
				int vertex2 = getIndexForVertex(edgeVertices[1]);

				vertices[vertex1].nbr = new Neighbor(vertex2, vertices[vertex1].nbr);
				vertices[vertex2].nbr = new Neighbor(vertex1, vertices[vertex2].nbr);
			}

			sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int getIndexForVertex(String vertexName){
		for(int i = 0; i < vertices.length; i++){
			if(vertices[i].val.equals(vertexName)){
				return i;
			}
		}
		return -1;
	}

	public void printGraph(){
		System.out.println("--------Printing the Graph---------");
		for(int i = 0; i < vertices.length; i++){
			System.out.print(vertices[i].val);
			for(Neighbor nbr = vertices[i].nbr; nbr != null; nbr = nbr.next){
				System.out.print(" --> " + vertices[nbr.vertexNumber].val);
			}
			System.out.println();
		}
	}
}
