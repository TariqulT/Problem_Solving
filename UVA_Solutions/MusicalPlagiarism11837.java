import java.util.*;
import java.io.*;

public class MusicalPlagiarism11837{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		while(true){
			int m = in.getInt();
			int t = in.getInt();
			if(m==0&&t==0){
				break;
			}
			String melody[] = {"A","A#","Bb","B","C","C#","Db","D","D#","Eb","E","F","F#","Gb","G","G#","Ab"};
			HashMap<String,Integer> map = new HashMap<>();
			int tone = 1;
			for(int i=0;i<17;i++){
				if(melody[i].length()==2){
					map.put(melody[i++],tone);
					map.put(melody[i],tone++);
				}
				else{
					map.put(melody[i],tone++);
				}
			}
			map.put("B#",4);
			map.put("Cb",3);
			map.put("E#",9);
			map.put("Fb",8);
			
			String song[] = in.getLine().split(" ");
			String snp[] = in.getLine().split(" ");
			StringBuilder st1 = new StringBuilder();
			StringBuilder st2 = new StringBuilder();
			if(t==1){
				for(int i=0;i<m;i++){
					st1.append(check(map.get(song[i])));
				}
				for(int i=0;i<t;i++){
					st2.append(check(map.get(snp[i])));
				}
			}
			else{
				for(int i=0;i<m-1;i++){
					int dis = map.get(song[i+1])-map.get(song[i]);
					if(dis<0){
						dis = dis+12;
					}
					st1.append(check(dis));
				}
				for(int i=0;i<t-1;i++){
					int dis = map.get(snp[i+1])-map.get(snp[i]);
					if(dis<0){
						dis = dis+12;
					}
					st2.append(check(dis));
				}
			}
			if(match(st1.toString(),st2.toString())){
				out.println("S");
			}
			else{
				out.println("N");
			}
			out.flush();
		}
		out.close();
		in.close();
	}
	public static String check(int a){
		if(a==10){
			return "A";
		}
		else if(a==11){
			return "B";
		}
		else if(a==12){
			return "C";
		}
		else{
			return Integer.toString(a);
		}
	}
	public static boolean match(String tx, String pt){
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
				return true;
			}
		}
		return false;
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
