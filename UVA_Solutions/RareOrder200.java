import java.util.*;
import java.io.*;

public class RareOrder200{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();

		String prev = "*";
		boolean adj[][] = new boolean[26][26];
		while(true){
			String index = in.getString();
			if(index.compareTo("#")==0){
				break;
			}
			for(int i=0;i<index.length();i++){
				int ch = index.charAt(i)-65;
				if(adj[ch][ch]==false){
					adj[ch][ch] = true;
				}
			}
			if(prev.compareTo("*")!=0){
				int loop = Dec.min(prev.length(),index.length());
				for(int i = 0;i<loop;i++){
					if(prev.charAt(i)!=index.charAt(i)){
						int u = prev.charAt(i)-65;
						int v = index.charAt(i)-65;
						if(adj[u][v]==false){
							adj[u][v] = true;
						}
						break;
					}
				}
			}
			prev = index;
		}
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		boolean[] visited = new boolean[26];
		for(int i=0;i<26;i++){
			if(!visited[i]){
				dfs(i,adj,stack,visited);
			}
		}
		while(stack.isEmpty()==false){
			char cha = stack.pop();
			if(adj[cha-65][cha-65]==true){
				out.print(cha);
			}
		}
		out.println();
 
		out.close();
		in.close();
	}
	static void dfs(int u, boolean[][] adj, ArrayDeque<Character> stack, boolean[] visited){
		for(int v=0;v<26;v++){
			if(adj[u][v]&&!visited[v]&&u!=v){
				dfs(v,adj,stack,visited);
			}
		}
		visited[u] = true;
		stack.push((char)(u+65));
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
class Dec{
	public static void sort(int[] a){
		int aux[] = new int[a.length];
		margeSort(a,aux,0,a.length-1);
	}
	private static void margeSort(int[] a, int[] aux, int lo, int hi){
		if(lo==hi){
			return;
		}
		int mid = (lo+hi)/2;
		margeSort(a,aux,lo,mid);
		margeSort(a,aux,mid+1,hi);

		for(int i=lo;i<=hi;i++){
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k] = aux[j++];
			}
			else if(j>hi){
				a[k] = aux[i++];
			}
			else if(aux[i]>aux[j]){
				a[k] = aux[j++];
			}
			else{
				a[k] = aux[i++];
			}
		}
	}
	public static int min(int a,int b){
		return (a<b?a:b);
	}
	public static int max(int a,int b){
		return (a>b?a:b);
	}
	public static long max(long a,long b){
		return (a>b?a:b);
	}
	public static int abs(int a){
		return (a<0?-1*a:a);
	}
	public static long abs(long a){
		return (a<0?-1*a:a);
	}
	public static int gcd(int a, int b){
		if(a%b==0){
			return b;
		}
		return gcd(b,a%b);
	}
	public static int lcm(int a, int b){
		return (a*b)/gcd(a,b);
	}
	public static int power(int base, int p){
		int res = 1;
		for(int i=0;i<p;i++){
			res = res*base;
		}
		return res;
	}
}