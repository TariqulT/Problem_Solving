import java.util.*;
import java.io.*;

public class Dominos2_11518{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);
		int test = in.getInt();
		while(test-->0){
			int n = in.getInt();
			int m = in.getInt();
			int l = in.getInt();

			Vector<Vector<Integer>> g =new Vector<>();
			for(int i=0;i<=n;i++){
				g.add(new Vector<Integer>());
			}
			for(int i=0;i<m;i++){
				g.get(in.getInt()).add(in.getInt());
			}
			boolean fall[] = new boolean[n+1];
			int q[] = new int[n];
			int head = 0;
			int tail = 0;

			int count = 0;
			for(int i=0;i<l;i++){
				int a = in.getInt();
				if(fall[a]==true){
					continue;
				}
				fall[a] = true;
				count++;
				q[head++] = a;
				while(head!=tail){
					int u = q[tail++];
					Vector<Integer> adj = g.get(u);
					for(int v: adj){
						if(fall[v]==false){
							fall[v] = true;
							q[head++] = v;
							count++;
						}
					}
				}
			}
			out.println(count);
		}
		out.close();
		in.close();
	}
}

class Input{
	BufferedReader in;
	StringTokenizer st;
	public Input() throws Exception{
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
