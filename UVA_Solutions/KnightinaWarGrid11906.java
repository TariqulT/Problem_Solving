import java.util.*;
import java.io.*;

class Node{
	int i;
	int j;
	int value;
	boolean visit;
	Vector<Node> adj;
	Node(int i, int j){
		this.i = i;
		this.j = j;
		value = 0;
		adj = new Vector<Node>();
		visit = false;
	}
}

public class KnightinaWarGrid11906{
	public static void main(String []args) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);

		int test = in.getInt();
		for(int t=1;t<=test;t++){
			int row = in.getInt();
			int col = in.getInt();
			int m = in.getInt();
			int n = in.getInt();
			Node gr[][] = new Node[row][col];
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					gr[i][j] = new Node(i,j);
				}
			}

			int w = in.getInt();
			for(int i=1;i<=w;i++){
				int x = in.getInt();
				int y = in.getInt();
				gr[x][y].value = -1;
			}
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					if(gr[i][j].value==-1){
						continue;
					}
					if(i+m<row&&j+n<col&&gr[i+m][j+n].value!=-1){
						gr[i][j].adj.add(gr[i+m][j+n]);
					}
					if(i-m>=0&&m*n!=0&&j+n<col&&gr[i-m][j+n].value!=-1){
						gr[i][j].adj.add(gr[i-m][j+n]);
					}
					if(i+m<row&&j-n>=0&&m*n!=0&&gr[i+m][j-n].value!=-1){
						gr[i][j].adj.add(gr[i+m][j-n]);
					}
					if(i-m>=0&&j-n>=0&&gr[i-m][j-n].value!=-1){
						gr[i][j].adj.add(gr[i-m][j-n]);
					}
					if(n==m){
						continue;
					}
					if(i+n<row&&j+m<col&&gr[i+n][j+m].value!=-1){
						gr[i][j].adj.add(gr[i+n][j+m]);
					}
					if(i-n>=0&&m*n!=0&&j+m<col&&gr[i-n][j+m].value!=-1){
						gr[i][j].adj.add(gr[i-n][j+m]);
					}
					if(i+n<row&&j-m>=0&&m*n!=0&&gr[i+n][j-m].value!=-1){
						gr[i][j].adj.add(gr[i+n][j-m]);
					}
					if(i-n>=0&&j-m>=0&&gr[i-n][j-m].value!=-1){
						gr[i][j].adj.add(gr[i-n][j-m]);
					}
				}
			}
			int countEven = 0;
			int countOdd = 0;
			ArrayDeque<Node> q = new ArrayDeque<>();
			if(gr[0][0].value!=-1){
				q.add(gr[0][0]);
				gr[0][0].visit = true;
			}
			while(q.isEmpty()==false){
				Node u = q.poll();
				for(Node v: u.adj){
					if(!v.visit){
						q.add(v);
						v.visit = true;
					}
				}
				if(u.adj.size()%2==0){
					countEven++;
				}
				else{
					countOdd++;
				}
			}
			out.println("Case "+t+": "+countEven+" "+countOdd);
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