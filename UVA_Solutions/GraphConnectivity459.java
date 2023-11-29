import java.util.*;
import java.io.*;

public class GraphConnectivity459{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);
		int test = in.getInt();
		int t = test-1;
		String blank = in.getLine();
		while(test-->0){
			boolean graph[][] = new boolean[27][27];
			HashMap<Character,Integer> map = new HashMap<>();
			int node = 1;
			while(true){
				String st = in.getLine();
				if(st==null||st.length()==0){
					break;
				}
				if(st.length()==2){
					int n1 = map.get(st.charAt(0));
					int n2 = map.get(st.charAt(1));
					graph[n1][n2] = true;
					graph[n2][n1] = true;
				}
				else{
					for(char i='A';i<=st.charAt(0);i++){
						map.put(i,node++);
					}
				}
			}
			boolean visit[] = new boolean[27];
			int count = 0;
			for(int i=1;i<node;i++){
				if(visit[i]==false){
					count++;
					int queue[] = new int[27];
					int head = 0;
					int tail = 0;
					queue[head++] = i;
					visit[i] = true;
					while(head!=tail){
						int u = queue[tail++];
						for(int v=1;v<node;v++){
							if(graph[u][v]&&visit[v]==false){
								queue[head++] = v;
								visit[v] = true;
							}
						}
					}
				}
			}
			if(test!=t){
				out.println();
			}
			out.println(count);
			out.flush();
		}
		in.close();
		out.close();
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
