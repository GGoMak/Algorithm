package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회_S1 {

	static int N;
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		char data, left, right;
		Node(char data, char left, char right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void preorder(int n) {
		
		if(tree[n] != '.') {
			sb.append(tree[n]);
		}
		if(tree[n * 2] != '.') {
			preorder(n * 2);
		}
		if(tree[n * 2 + 1] != '.') {
			preorder(n * 2 + 1);
		}
	}
	
	public static void inorder(int n) {
		
		if(tree[n * 2] != '.') {
			inorder(n * 2);
		}
		if(tree[n] != '.') {
			sb.append(tree[n]);
		}
		if(tree[n * 2 + 1] != '.') {
			inorder(n * 2 + 1);
		}
	}
	
	public static void postorder(int n) {
		
		if(tree[n * 2] != '.') {
			postorder(n * 2);
		}
		if(tree[n * 2 + 1] != '.') {
			postorder(n * 2 + 1);
		}
		if(tree[n] != '.') {
			sb.append(tree[n]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N];
		tree = new char[100000];
		Arrays.fill(tree, '.');
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
	
			nodes[i] = new Node(data, left, right);
		}
		
		Arrays.sort(nodes, (o1, o2) -> {
			return o1.data - o2.data;
		});
		
		tree[1] = nodes[0].data;
		tree[2] = nodes[0].left;
		tree[3] = nodes[0].right;
		
		for(int i = 1; i < N; i++) {
			Node n = nodes[i];
			
			for(int j = 1; j < tree.length; j++) {
				if(tree[j] == n.data) {
					tree[j * 2] = n.left;
					tree[j * 2 + 1] = n.right;
					break;
				}
			}
		}
		
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		sb.append("\n");
		System.out.println(sb);
	}

}
