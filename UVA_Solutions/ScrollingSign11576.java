import java.util.*;
import java.io.*;

public class ScrollingSign11576{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		int test = in.getInt();
		while(test-->0){
			int len = in.getInt();
			int n = in.getInt();
			String st[] = new String[n];
			for(int i=0;i<n;i++){
				st[i] = in.getString();
			}
			StringBuilder minLetter = new StringBuilder(st[0]);
			for(int i=1;i<n;i++){
				minLetter.append(needed(minLetter.toString(),st[i],len));
			}
			out.println(minLetter.length());
			out.flush();
		}
		out.close();
		in.close();
	}
	public static String needed(String tx, String pt, int len){
		int lenTx = tx.length();
		int pf[] = new int[len];
		prefixFunction(pf,pt,len);
		int q = 0;
		for(int i=lenTx-len;i<lenTx;i++){
			while(q>0&&tx.charAt(i)!=pt.charAt(q)){
				q = pf[q-1];
			}
			if(tx.charAt(i)==pt.charAt(q)){
				q++;
			}
		}
		return pt.substring(q);
	}
	public static void prefixFunction(int pf[], String ptr, int len){
		for(int i=1,j=0;i<len;i++){
			while(j>0&&ptr.charAt(i)!=ptr.charAt(j)){
				j = pf[j-1];
			}
			if(ptr.charAt(i)==ptr.charAt(j)){
				j++;
			}
			pf[i] = j;
		}
	}
}

class Input{
	BufferedReader in;
	StringTokenizer st;
	public Input(){
		in = new BufferedReader(
			new InputStreamReader(System.in));
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