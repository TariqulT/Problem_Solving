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

public class CountingCellsInaBlob871{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);
		int test = in.getInt();
		int t = test;
		String st = in.getLine();
		while(test-->0){
			int m = 0, n = 0;
			Vector<Vector<Node>> g = new Vector<>();
			while(true){
				st = in.getLine();
				if(st==null||st.length()==0){
					break;
				}
				n = st.length();
				Vector<Node> row = new Vector<>();
				for(int i=0;i<n;i++){
					if(st.charAt(i)=='1'){
						row.add(new Node(false));
					}
					else{
						row.add(new Node(true));
					}
				}
				g.add(row);
				m++;
			}
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(g.get(i).get(j).visit==true){
						continue;
					}
					if(i>0&&g.get(i-1).get(j).visit==false){
						g.get(i).get(j).adj.add(g.get(i-1).get(j)); 
					}
					if(i>0&&j<n-1&&g.get(i-1).get(j+1).visit==false){
						g.get(i).get(j).adj.add(g.get(i-1).get(j+1));
					}
					if(j<n-1&&g.get(i).get(j+1).visit==false){
						g.get(i).get(j).adj.add(g.get(i).get(j+1));
					}
					if(i<m-1&&j<n-1&&g.get(i+1).get(j+1).visit==false){
						g.get(i).get(j).adj.add(g.get(i+1).get(j+1));
					}
					if(i<m-1&&g.get(i+1).get(j).visit==false){
						g.get(i).get(j).adj.add(g.get(i+1).get(j));
					}
					if(i<m-1&&j>0&&g.get(i+1).get(j-1).visit==false){
						g.get(i).get(j).adj.add(g.get(i+1).get(j-1));
					}
					if(j>0&&g.get(i).get(j-1).visit==false){
						g.get(i).get(j).adj.add(g.get(i).get(j-1));
					}
					if(i>0&&j>0&&g.get(i-1).get(j-1).visit==false){
						g.get(i).get(j).adj.add(g.get(i-1).get(j-1));
					}
				}
			}
			int max = 0;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(g.get(i).get(j).visit==true){
						continue;
					}
					int cnt = 1+dfsVisit(g.get(i).get(j));
					if(cnt>max){
						max = cnt;
					}
				}
			}
			if(test!=t-1){
				out.println();
			}
			out.println(max);
			out.flush();
		}

		in.close();
		out.close();
	}
	static int dfsVisit(Node u){
		int c = 0;
		u.visit = true;
		for(Node v: u.adj){
			if(!v.visit){
				c++;
				c+=dfsVisit(v);
			}
		}
		return c;
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