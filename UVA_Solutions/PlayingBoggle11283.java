import java.util.*;
import java.io.*;

public class PlayingBoggle11283{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		int test = in.getInt();
		boolean blank = false;
		for(int t=1;t<=test;t++){
			String board[] = new String[4];
			for(int i=0;i<4;i++){
				board[i] = in.getString();
			}
			int round = in.getInt();
			int score = 0;
			String word;
			while(round-->0){
				word = in.getString();
				int len = word.length();
				boolean found = false;
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						int flag[][] = new int[4][4];
						int f = 0;
						found = search(word,len,board,flag,f,i,j);
						if(found){
							break;
						}
					}
					if(found){
						break;
					}
				}
				if(found){
					if(len==3||len==4){
						score += 1;
					}
					else if(len==5){
						score += 2;
					}
					else if(len==6){
						score += 3;
					}
					else if(len==7){
						score += 5;
					}
					else{
						score += 11;
					}
				}
			}
			out.println("Score for Boggle game #"+t+": "+score);
		}
		out.close();
		in.close();
	}
	static boolean search(String word, int len, String[] board, int[][] flag, int f, int i, int j){
		if(f==len){
			return true;
		}
		else if(i<0||i>3||j<0||j>3||flag[i][j]==1){
			return false;
		}
		if(board[i].charAt(j)==word.charAt(f)){
			flag[i][j] = 1;
			boolean a = search(word,len,board,flag,f+1,i+1,j)||
			search(word,len,board,flag,f+1,i-1,j)||
			search(word,len,board,flag,f+1,i,j+1)||
			search(word,len,board,flag,f+1,i,j-1)||
			search(word,len,board,flag,f+1,i-1,j-1)||
			search(word,len,board,flag,f+1,i-1,j+1)||
			search(word,len,board,flag,f+1,i+1,j+1)||
			search(word,len,board,flag,f+1,i+1,j-1);
			flag[i][j] = 0;
			return a;
		}
		else{
			return false;
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
