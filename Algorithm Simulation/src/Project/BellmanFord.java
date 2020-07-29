package Project;

public class BellmanFord
{
    
    class Edge {
        int src, destination, weight;
        Edge() 
        {
            src = destination = weight = 0;
        }
    };
 
    int k = 0;
    int V;
	int E;
    Edge edge[];
    int dist[];
    int []x;
    static int sp[];
    // Creates a graph with V vertices and E edges
    BellmanFord(int v, int e)
    {
		V = v;
		E = e;
		sp = new int[V];
		dist = new int[V];
		x = new int[V];
		edge = new Edge[E];
		for(int i = 0; i < E ; i++)
		{
			edge[i] = new Edge();
		}
    }
    
    void addedge(int i, int s, int d, int w)
    {

		edge[i].src = s;
        edge[i].destination = d;
        edge[i].weight = w;
 
    }
    
	void relax(int u, int v, int weight)
	{
		if((dist[u] + weight) < dist[v])
		{
			dist[v] = dist[u] + weight;
		}
	}
    
    void initialize_distance(int src){
       for (int i=0; i<V; ++i)
       {
    	   dist[i] = 9999;
       }
       dist[src] = 0; 
       k++;
    }
    
    void calculate_distance()
    {
        //Actual Bellman Ford Algorithm
    	
    	for(int i = 0; i<V ; i++)
    	{
    		for(int j = 0; j<E ; j++)
    		{
    			relax(edge[j].src, edge[j].destination, edge[j].weight);
    		}
    		sp[i] = dist[i];
    		x[i] = dist[i];
    	}
    	System.out.println();
    }
    boolean NegCycle = false;
    void find_negative_cycle(){
		//Bellman Ford with extra code for detecting negative edge
    	
    	for(int j = 0; j<E ; j++)
		{
			relax(edge[j].src, edge[j].destination, edge[j].weight);
		}
    	for(int i = 0; i<V ; i++)
		{
    		if(x[i] != dist[i])
			{
    			NegCycle = true;
				System.out.println("Negative Cycle Found ");
				break;
			}
		}
    }
    
    void print_output(int src)
    {
    	System.out.println("Source\tDestination\tShortest Path");
	      for (int i=0; i<V; ++i)
	      {
	    	  System.out.println(src+"\t"+i+"\t\t"+sp[i]);
	      }
    }
    
    void BellmanFord(int src)
    {
       
    	initialize_distance(src);
        calculate_distance();
        print_output(src);
    }
 
    
    public static void main(String[] args)
    {
        int V = 4;  // Number of vertices in graph
        int E = 6;  // Number of edges in graph
 
        BellmanFord graph = new BellmanFord(V, E);
        
        graph.addedge(0, 0, 1, 5);
        graph.addedge(1, 1, 0, 3);
        graph.addedge(2, 0, 2, 2);
        graph.addedge(3, 1, 3, 4);
        graph.addedge(4, 0, 3, 6);
        graph.addedge(5, 2, 3, 1);
        
        for(int i = 0; i<2; i++)
        {
        	graph.BellmanFord(i);
        }
        

        //System.out.println(graph.sp[3]);
    }
}