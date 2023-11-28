import java.util.*;
import java.io.*;

public class BigMod374{
	public static void main(String args[]) throws Exception{
		Input in = new Input();
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			long b = in.getLong();
			long p = in.getLong();
			long m = in.getLong();
			long result = mod(b,p,m);
			out.println(result);
			out.flush();
			String st = in.getLine();
			if(st==null){
				break;
			}
		}
		in.close();
		out.close();
	}
	public static long mod(long b, long p, long m){
		if(p==0){
			return 1%m;
		}
		else if(p==1){
			return b%m;
		}
		else if(p%2==1){
			return (mod(b,p-1,m)*(b%m))%m;
		}
		else{
			long res = mod(b,p/2,m);
			return (res*res)%m;
		}
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