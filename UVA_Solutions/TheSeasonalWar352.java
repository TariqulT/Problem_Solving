import java.util.*;
import java.io.*;

class Node{
	boolean visit;
	int i;
	int j;
	Node(int i, int j, boolean v){
		visit = v;
		this.i = i;
		this.j = j;
	}
}

public class TheSeasonalWar352{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);

		int test = 1;
		while(true){
			String st = in.getLine();
			if(st==null){
				break;
			}
			int n = Integer.parseInt(st);
			Node g[][] = new Node[n][n];
			for(int i=0;i<n;i++){
				st = in.getLine();
				for(int j=0;j<n;j++){
					if(st.charAt(j)=='1'){
						g[i][j] = new Node(i,j,false);
					}
					else{
						g[i][j] = new Node(i,j,true);
					}
				}
			}
			int count = 0;
			ArrayDeque<Node> q = new ArrayDeque<>();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(g[i][j].visit==true){
						continue;
					}
					count++;
					q.add(g[i][j]);
					g[i][j].visit = true;
					while(!q.isEmpty()){
						Node u = q.poll();
						if(u.i>0&&g[u.i-1][u.j].visit==false){
							q.add(g[u.i-1][u.j]);
							g[u.i-1][u.j].visit = true;
						}
						if(u.j>0&&g[u.i][u.j-1].visit==false){
							q.add(g[u.i][u.j-1]);
							g[u.i][u.j-1].visit = true;
						}
						if(u.i<n-1&&g[u.i+1][u.j].visit==false){
							q.add(g[u.i+1][u.j]);
							g[u.i+1][u.j].visit = true;
						}
						if(u.j<n-1&&g[u.i][u.j+1].visit==false){
							q.add(g[u.i][u.j+1]);
							g[u.i][u.j+1].visit = true;
						}
						if(u.i>0&&u.j>0&&g[u.i-1][u.j-1].visit==false){
							q.add(g[u.i-1][u.j-1]);
							g[u.i-1][u.j-1].visit = true;
						}
						if(u.i>0&&u.j<n-1&&g[u.i-1][u.j+1].visit==false){
							q.add(g[u.i-1][u.j+1]);
							g[u.i-1][u.j+1].visit = true;
						}
						if(u.i<n-1&&u.j<n-1&&g[u.i+1][u.j+1].visit==false){
							q.add(g[u.i+1][u.j+1]);
							g[u.i+1][u.j+1].visit = true;
						}
						if(u.i<n-1&&u.j>0&&g[u.i+1][u.j-1].visit==false){
							q.add(g[u.i+1][u.j-1]);
							g[u.i+1][u.j-1].visit = true;
						}
					}
				}
			}
			out.println("Image number "+test+" contains "+count+" war eagles.");
			test++;
			out.flush();
		}

		in.close();
		out.close();
	}
}

class Input{
	BufferedReader in;
	StringTokenizer st;
	Input() throws Exception{
		in = new BufferedReader(new InputStreamReader(System.in));
		st = null;
	}
	public String getString() throws Exception{
		while(st==null||st.hasMoreTokens()==false){
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	public boolean getBoolean() throws Exception{
		return Boolean.parseBoolean(getString());
	}
	public byte getByte() throws Exception{
		return Byte.parseByte(getString());
	}
	public short getShort() throws Exception{
		return Short.parseShort(getString());
	}
	public int getInt() throws Exception{
		return Integer.parseInt(getString());
	}
	public long getLong() throws Exception{
		return Long.parseLong(getString());
	}
	public float getFloat() throws Exception{
		return Float.parseFloat(getString());
	}
	public double getDouble() throws Exception{
		return Double.parseDouble(getString());
	}
	public String getLine() throws Exception{
		return in.readLine();
	}
	public void close() throws Exception{
		if(in!=null) in.close();
	}
}