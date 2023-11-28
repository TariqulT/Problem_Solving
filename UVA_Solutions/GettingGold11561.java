import java.util.*;
import java.io.*;

class Node{
	char val;
	boolean visit;
	Vector<Node> adj;
	Node(char val, boolean visit){
		this.val = val;
		this.visit = visit;
		adj = new Vector<>();
	}
}

public class GettingGold11561{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			String st = in.getLine();
			if(st==null){
				break;
			}
			String s[] = st.split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			Vector<Vector<Node>> g = new Vector<>();
			int pi = 0, pj = 0;

			for(int i=0;i<m;i++){
				st = in.getLine();
				Vector<Node> row = new Vector<>();
				for(int j=0;j<n;j++){
					if(st.charAt(j)=='P'){
						pi = i; 
						pj = j;
					}
					if(st.charAt(j)=='G'||st.charAt(j)=='P'||st.charAt(j)=='.'){
						row.add(new Node(st.charAt(j),false));
					}
					else{
						row.add(new Node(st.charAt(j),true));
					}
				}
				g.add(row);
			}
			for(int i=1;i<m-1;i++){
				for(int j=1;j<n-1;j++){
					if(g.get(i).get(j).visit==true||g.get(i-1).get(j).val=='T'||g.get(i).get(j+1).val=='T'
						||g.get(i+1).get(j).val=='T'||g.get(i).get(j-1).val=='T'){
						continue;
					}
					if(g.get(i-1).get(j).visit==false){
						g.get(i).get(j).adj.add(g.get(i-1).get(j)); 
					}
					
					if(g.get(i).get(j+1).visit==false){
						g.get(i).get(j).adj.add(g.get(i).get(j+1));
					}
					
					if(g.get(i+1).get(j).visit==false){
						g.get(i).get(j).adj.add(g.get(i+1).get(j));
					}
					
					if(g.get(i).get(j-1).visit==false){
						g.get(i).get(j).adj.add(g.get(i).get(j-1));
					}
				}
			}
			
			out.println(dfsVisit(g.get(pi).get(pj)));
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
				if(v.val=='G'){
					c++;
				}
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