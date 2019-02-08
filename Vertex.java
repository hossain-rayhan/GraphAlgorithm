public class Vertex{
	String val;
	Neighbor nbr;
	boolean isVisited;
	
	public Vertex(String val, Neighbor nbr){
		this.val = val;
		this.nbr = nbr;
		this.isVisited = false;
	}
}
