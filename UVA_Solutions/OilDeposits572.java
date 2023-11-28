import java.util.*;
import java.io.*;

class Node{
	boolean visit;
	Vector<Node> adj;
	Node(boolean visit){
		this.visit = visit;
		adj = new Vector<>();
	}
}

public class OilDeposits572{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);

		while(true){
			int m = in.getInt();
			int n = in.getInt();
			if(m==0){
				break;
			}
			Node g[][] = new Node[m][n];
			for(int i=0;i<m;i++){
				String st = in.getString();
				for(int j=0;j<n;j++){
					if(st.charAt(j)=='@'){
						g[i][j] = new Node(false);
					}
					else{
						g[i][j] = new Node(true);
					}
				}
			}
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(g[i][j].visit==true){
						continue;
					}
					if(i>0&&g[i-1][j].visit==false){
						g[i][j].adj.add(g[i-1][j]); 
					}
					if(i>0&&j<n-1&&g[i-1][j+1].visit==false){
						g[i][j].adj.add(g[i-1][j+1]);
					}
					if(j<n-1&&g[i][j+1].visit==false){
						g[i][j].adj.add(g[i][j+1]);
					}
					if(i<m-1&&j<n-1&&g[i+1][j+1].visit==false){
						g[i][j].adj.add(g[i+1][j+1]);
					}
					if(i<m-1&&g[i+1][j].visit==false){
						g[i][j].adj.add(g[i+1][j]);
					}
					if(i<m-1&&j>0&&g[i+1][j-1].visit==false){
						g[i][j].adj.add(g[i+1][j-1]);
					}
					if(j>0&&g[i][j-1].visit==false){
						g[i][j].adj.add(g[i][j-1]);
					}
					if(i>0&&j>0&&g[i-1][j-1].visit==false){
						g[i][j].adj.add(g[i-1][j-1]);
					}
				}
			}
			int count = 0;
			ArrayDeque<Node> q = new ArrayDeque<>();
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(g[i][j].visit){
						continue;
					}
					count++;
					q.add(g[i][j]);
					g[i][j].visit = true;
					while(!q.isEmpty()){
						Node u = q.poll();
						for(Node v: u.adj){
							if(!v.visit){
								q.add(v);
								v.visit = true;
							}
						}
					}
				}
			}
			out.println(count);
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