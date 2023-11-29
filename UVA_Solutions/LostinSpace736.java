import java.util.*;
import java.io.*;

public class LostinSpace736{
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
			String puzl[] = new String[n];
			for(int i=0;i<n;i++){
				puzl[i] = in.getLine();
			}
			while(true){
				String word = in.getLine();
				if(word==null||word.length()==0){
					break;
				}
				out.println("\n"+word);
				boolean found = false;
				int len = word.length();
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						int w = 0;
						if(puzl[i].charAt(j)==' '){
							continue;
						}
						for(int k=i;k>=0;k--){
							if(puzl[k].charAt(j)==word.charAt(w)){
								w++;
							}
							else if(puzl[k].charAt(j)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - N");
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x>=0&&y<n;x--,y++){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else if(puzl[x].charAt(y)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - NE");
								break;
							}
						}
						
						w = 0;
						for(int k=j;k<n;k++){
							if(puzl[i].charAt(k)==word.charAt(w)){
								w++;
							}
							else if(puzl[i].charAt(k)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - E");
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x<n&&y<n;x++,y++){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else if(puzl[x].charAt(y)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - SE");
								break;
							}
						}
						
						w = 0;
						for(int k=i;k<n;k++){
							if(puzl[k].charAt(j)==word.charAt(w)){
								w++;
							}
							else if(puzl[k].charAt(j)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - S");
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x<n&&y>=0;x++,y--){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else if(puzl[x].charAt(y)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - SW");
								break;
							}
						}
						
						w = 0;
						for(int k=j;k>=0;k--){
							if(puzl[i].charAt(k)==word.charAt(w)){
								w++;
							}
							else if(puzl[i].charAt(k)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - W");
								break;
							}
						}
						
						w = 0;
						for(int x=i,y=j;x>=0&&y>=0;x--,y--){
							if(puzl[x].charAt(y)==word.charAt(w)){
								w++;
							}
							else if(puzl[x].charAt(y)==' '){
								continue;
							}
							else{
								break;
							}
							if(w==len){
								found = true;
								out.println("("+(i+1)+","+(j+1)+")"+" - NW");
								break;
							}
						}
					}
				}
				if(found==false){
					out.println("not found");
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
