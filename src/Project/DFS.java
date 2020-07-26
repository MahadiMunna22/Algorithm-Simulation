package Project;

import java.util.LinkedList;

public class DFS {
	int V;
	static int z = 0;
	LinkedList<Integer>[] g;
	LinkedList<Integer> arr1;
	LinkedList<String> arr2;
	DFS(int v)
	{
		V = v;
		g = new LinkedList[V];
		arr1 = new LinkedList();
		arr2 = new LinkedList();
		for(int i =0 ; i<V ; i++)
		{
			g[i] = new LinkedList<Integer>();
		}
	}
	void Add_edge(int u,int v)
	{
		g[u].add(v);
		g[v].add(u);
	}
	void DFS()
	{
		int color[] = new int[V];
		int d[] = new int[V];
		int f[] = new int[V];
		int black = 2;
		int grey = 1;
		int white = 0;
		int time = 0;
		for(int i = 0; i<V; i++)
		{
			color[i] = white;
			System.out.println("White "+i);
			arr1.add(i);
			arr2.add("W");
			z++;
		}
		
		for(int i = 0; i<V; i++)
		{
			if(color[i]==white)
			{
				DFS_Visit(i,white,grey,black,color,d,f,time);
			}
		}
	}
	void DFS_Visit(int u,int white,int grey,int black,int color[],int d[],int f[],int time)
	{
		color[u]= grey;
		System.out.println("Grey "+u);
		arr1.add(u);
		arr2.add("G");
		z++;
		time++;
		d[u]=time;
		//System.out.print(u+" ");
		for(int i = 0; i <g[u].size(); i++)
		{
			int v = g[u].get(i);
			if(color[v]==white)
			{
				DFS_Visit(v,white,grey,black,color,d,f,time);
			}
		}
		System.out.println("Black "+u);
		arr1.add(u);
		arr2.add("B");
		z++;
	}
	public static void main(String [] args)
	{
		DFS d = new DFS(5);
		d.Add_edge(0, 1);
		d.Add_edge(0, 2);
		d.Add_edge(1, 3);
		d.Add_edge(2, 4);
		d.Add_edge(1, 4);
		d.DFS();
		System.out.println(d.arr1);
		System.out.println(d.arr2);
		System.out.println(z);
	}
	
}
