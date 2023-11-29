import java.util.*;
import java.io.*;

public class PowerStrings10298{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		while(true){
			String st = in.getString();
			if(st.compareTo(".")==0){
				break;
			}
			int len = st.length();
			int pf[] = new int[len];
			prefixFunction(pf,st,len);
			if(len%(len-pf[len-1])==0){
				out.println(len/(len-pf[len-1]));
			}
			else{
				out.println(1);
			}
			out.flush();
		}
		out.close();
		in.close();
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