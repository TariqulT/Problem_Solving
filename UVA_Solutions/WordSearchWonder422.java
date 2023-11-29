import java.util.*;
import java.io.*;

public class WordSearchWonder422{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		int n = in.getInt();
		String puzl[] = new String[n];
		for(int i=0;i<n;i++){
			puzl[i] = in.getLine();
		}
		while(true){
			String word = in.getLine();
			if(word.compareTo("0")==0){
				break;
			}
			String wordRev = (new StringBuilder(word)).reverse().toString();
			int len = word.length();
			int get = -1;
			for(int i=0;i<n;i++){
				get = match(puzl[i],word);
				if(get>0){
					out.print((i+1)+","+(get-len+1)+" ");
					out.println((i+1)+","+get);
					break;
				}
				get = match(puzl[i],wordRev);
				if(get>0){
					out.print((i+1)+","+get+" ");
					out.println((i+1)+","+(get-len+1));
					break;
				}
			}
			if(get>0){
				continue;
			}
			for(int i=0;i<n;i++){
				StringBuilder st = new StringBuilder();
				for(int j=0;j<n;j++){
					st.append(puzl[j].charAt(i));
				}
				get = match(st.toString(),word);
				if(get>0){
					out.print((get-len+1)+","+(i+1)+" ");
					out.println(get+","+(i+1));
					break;
				}
				get = match(st.toString(),wordRev);
				if(get>0){
					out.print(get+","+(i+1)+" ");
					out.println((get-len+1)+","+(i+1));
					break;
				}
			}
			if(get>0){
				continue;
			}
			for(int s_i=0,s_j=0;s_i<n;){
				if(s_j==n-1){
					s_i++;
				}
				else{
					s_j++;
				}
				StringBuilder st = new StringBuilder();
				for(int i=s_i,j=s_j;i<n&&j>=0;i++,j--){
					st.append(puzl[i].charAt(j));
				}
				get = match(st.toString(),word);
				if(get>0){
					out.print((get+s_i-len+1)+","+(s_j-get+2+len-1)+" ");
					out.println((get+s_i)+","+(s_j-get+2));
					break;
				}
				get = match(st.toString(),wordRev);
				if(get>0){
					out.print((get+s_i)+","+(s_j-get+2)+" ");
					out.println((get+s_i-len+1)+","+(s_j-get+2+len-1));
					break;
				}
			}
			if(get>0){
				continue;
			}
			for(int s_i=0,s_j=n-1;s_i<n;){
				if(s_j==0){
					s_i++;
				}
				else{
					s_j--;
				}
				StringBuilder st = new StringBuilder();
				for(int i=s_i,j=s_j;i<n&&j<n;i++,j++){
					st.append(puzl[i].charAt(j));
				}
				get = match(st.toString(),word);
				if(get>0){
					out.print((get+s_i-len+1)+","+(get+s_j-len+1)+" ");
					out.println((get+s_i)+","+(get+s_j));
					break;
				}
				get = match(st.toString(),wordRev);
				if(get>0){
					out.print((get+s_i)+","+(get+s_j)+" ");
					out.println((get+s_i-len+1)+","+(get+s_j-len+1));
					break;
				}
			}
			if(get==-1){
				out.println("Not found");
			}
		}
		out.close();
		in.close();
	}
	
	public static int match(String tx, String pt){
		int len1 = tx.length();
		int len2 = pt.length();
		int pf[] = new int[len2];
		preFunction(pt,pf,len2);
		int q = 0;
		for(int i=0;i<len1;i++){
			while(q>0&&tx.charAt(i)!=pt.charAt(q)){
				q = pf[q-1];
			}
			if(tx.charAt(i)==pt.charAt(q)){
				q++;
			}
			if(q==len2){
				return i+1;
			}
		}
		return -1;
	}
	public static void preFunction(String pt, int pf[], int len2){
		int q = 0;
		pf[0] = 0;
		for(int i=1;i<len2;i++){
			while(q>0&&pt.charAt(q)!=pt.charAt(i)){
				q = pf[q-1];
			}
			if(pt.charAt(q)==pt.charAt(i)){
				q++;
			}
			pf[i] = q;
		}
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
