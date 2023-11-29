import java.util.*;
import java.io.*;

public class WheresWaldorf10010{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		int test = in.getInt();
		boolean blank = false;
		while(test-->0){
			if(blank){
				out.println();
			}
			blank = true;
			int n = in.getInt();
			int m = in.getInt();
			String puzl[] = new String[n];
			for(int i=0;i<n;i++){
				puzl[i] = in.getLine();
				puzl[i] = puzl[i].toLowerCase();
			}
			int query = in.getInt();
			while(query-->0){
				String word = in.getLine();
				word = word.toLowerCase();
				boolean found = false;
				int len = word.length();
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						int w = 0;
						for(int k=i;k>=0;k--){
							if(puzl[k].charAt(j)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x>=0&&y<m&&!found;x--,y++){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int k=j;k<m&&!found;k++){
							if(puzl[i].charAt(k)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x<n&&y<m&&!found;x++,y++){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int k=i;k<n&&!found;k++){
							if(puzl[k].charAt(j)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x<n&&y>=0&&!found;x++,y--){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int k=j;k>=0&&!found;k--){
							if(puzl[i].charAt(k)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x>=0&&y>=0&&!found;x--,y--){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								break;
							}
						}

						if(found){
							out.println((i+1)+" "+(j+1));
							break;
						}
					}
					if(found){
						break;
					}
				}
				
				out.flush();
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
