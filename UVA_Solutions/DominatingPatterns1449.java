import java.util.*;
import java.io.*;

public class DominatingPatterns1449{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		while(true){
			int n = in.getInt();
			if(n==0){
				break;
			}
			String pattern[] = new String[n];
			for(int i=0;i<n;i++){
				pattern[i] = in.getString();
			}
			String text = in.getString();
			int appear[] = new int[n];
			int maxApp = 0;
			for(int i=0;i<n;i++){
				int cnt = countAppearance(text,pattern[i]);
				if(cnt>maxApp){
					maxApp = cnt;
				}
				appear[i] = cnt;
			}
			out.println(maxApp);
			for(int i=0;i<n;i++){
				if(appear[i]==maxApp){
					out.println(pattern[i]);
				}
			}
			out.flush();
		}
		out.close();
		in.close();
	}
	public static int countAppearance(String text, String pattern){
		int count = 0;
		int lenT = text.length();
		int lenP = pattern.length();
		int pf[] = new int[lenP];
		preFunction(pf,pattern,lenP);
		for(int i=0,j=0;i<lenT;i++){
			while(j>0&&text.charAt(i)!=pattern.charAt(j)){
				j = pf[j-1];
			}
			if(text.charAt(i)==pattern.charAt(j)){
				j++;
			}
			if(j==lenP){
				count++;
				j = pf[j-1];
			}
		}
		return count;
	}
	public static void preFunction(int pf[], String ptr, int lenP){
		pf[0] = 0;
		for(int i=1,q=0;i<lenP;i++){
			while(q>0&&ptr.charAt(q)!=ptr.charAt(i)){
				q = pf[q-1];
			}
			if(ptr.charAt(q)==ptr.charAt(i)){
				q++;
			}
			pf[i] = q;
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