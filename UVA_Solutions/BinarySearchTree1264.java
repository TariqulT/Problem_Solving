import java.util.*;
import java.io.*;

class Node{
	int value;
	Node left;
	Node right;
	int cntLeft;
	int cntRight;
	Node(int value){
		left = null;
		right = null;
		cntLeft = 0;
		cntRight = 0;
		this.value = value;
	}
}
class BST{
	Node root;
	BST(){
		root = null;
	}
	public void insert(int value, Node node){
		if(node==null){
			Node nw = new Node(value);
			root = nw;
			return;
		}
		if(value<node.value){
			if(node.left==null){
				Node nw = new Node(value);
				node.left = nw;

			}
			else{
				insert(value,node.left);
			}
			node.cntLeft++;
		}
		else{
			if(node.right==null){
				Node nw = new Node(value);
				node.right = nw;
			}
			else{
				insert(value,node.right);
			}
			node.cntRight++;
		}
	}
	public long bstPermutation(Node node){
		if(node==null){
			return 1;
		}
		int n = max(node.cntRight,node.cntLeft);
		int r = min(node.cntRight,node.cntLeft);
		long permu = calculatePermutation(n,r);
		permu = (permu*bstPermutation(node.left))%9999991;
		permu = (permu*bstPermutation(node.right))%9999991;

		return permu;
	}
	long calculatePermutation(int n, int r){
		long permu = 1L;
		int c1[] = new int[r];
		int c2[] = new int[r];
		for(int i=1;i<=r;i++){
			c1[i-1] = n+i;
			c2[i-1] = i;
		}
		for(int i=0;i<r;i++){
			if(c2[i]==1){
				continue;
			}
			for(int j=0;j<r;j++){
				if(c1[j]%c2[i]==0){
					c1[j] = c1[j]/c2[i];
					c2[i] = 1;
					break;
				}
				int g = gcd(c2[i],c1[j]);
				if(g>1){
					c2[i] = c2[i]/g;
					c1[j] = c1[j]/g;
					if(c2[i]!=1){
						i--;
					}
					break;
				}
			}
		}
		for(int i=0;i<r;i++){
			permu = (c1[i]*permu)%9999991;
		}
		return permu;
	}

	int gcd(int a, int b){
		if(a%b==0){
			return b;
		}
		return gcd(b,a%b);
	}
	int max(int a, int b){
		return (a<b?b:a);
	}
	int min(int a, int b){
		return (a<b?a:b);
	}
}

public class BinarySearchTree1264{
	public static void main(String args[]) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Input in = new Input();
		int test = in.getInt();
		while(test-->0){
			int n = in.getInt();
			int a;
			BST bst = new BST();
			for(int i=0;i<n;i++){
				a = in.getInt();
				bst.insert(a,bst.root);
			}
			out.println(bst.bstPermutation(bst.root));
			out.flush();
		}
		out.close();
		in.close();
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
