package Project;

import java.util.ArrayList;
import java.util.LinkedList;
public class BFS 
{
	int V,x = 0;
	static int z = 0;
	LinkedList<Integer>[] g;
	LinkedList<Integer> arr1;
	LinkedList<String> arr2;
	BFS(int v)
	{
		V=v;
		g = new LinkedList[V];
		arr1 = new LinkedList();
		arr2 = new LinkedList();
		for(int i = 0; i<V ; i++)
		{
			g[i] = new LinkedList<Integer>();
		}
	}
	void Add_edge(int u, int v)
	{
		g[u].add(v);
		g[v].add(u);
	}
	void BFS(int s)
	{
		int Black = 2;
		int Grey = 1;
		int White = 0;
		int [] color = new int[V];
		int [] d = new int[V];
		int [] p = new int[V];
		
		for(int i = 0; i<V; i++)
		{
			d[i] = 9999;
			p[i] = -1;
			color[i] = White;
			System.out.println("WHITE "+i);
			arr1.add(i);
			arr2.add("W");
			z++;
		}
		d[s] = 0;
		color[s] = Grey;
		System.out.println("GREY "+s);
		arr1.add(s);
		arr2.add("G");
		z++;
		p[s] = -1;
		LinkedList<Integer> Q = new LinkedList<Integer>();
		Q.add(s);
		while(!Q.isEmpty())
		{
			int u = Q.poll();
			//System.out.print(u+" ");
			for(int i = 0; i<g[u].size();i++)
			{
				int v = g[u].get(i);
				if(color[v] == White)
				{
					color[v] = Grey;
					System.out.println("GREY "+v);
					arr1.add(v);
					arr2.add("G");
					z++;
					p[v] = u;
					d[v] = d[v] + 1;
					Q.add(v);
				}
			}

			color[u] = Black;
			System.out.println("BLACK "+u);
			arr1.add(u);
			arr2.add("B");
			z++;
		}
	}
	
	
	public static void main(String[] args) {
		BFS G = new BFS(5);
		G.Add_edge(0, 1);
		G.Add_edge(0, 4);
		G.Add_edge(1, 2);
		G.Add_edge(1, 3);
		G.BFS(0);
		System.out.println(G.arr1);
		System.out.println(G.arr2);
		System.out.println(z);
	}

}
