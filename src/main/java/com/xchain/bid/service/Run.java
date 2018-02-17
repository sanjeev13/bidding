package com.xchain.bid.service;

import java.util.Stack;

public class Run {

	private static boolean contains(String str) {
		if(str.contains("1") && str.contains("2") &&
				str.contains("3")) {
			return true;
		}
		return false;
	}
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<=pattern.length();i++) {
			st.push(i+1);
			if(i == pattern.length() || pattern.charAt(i) == 'N' ) {
				while(!st.isEmpty()) {
					ans = ans*10+st.pop();
				}
			}else if(pattern.charAt(i) != 'M') {
				return -1;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		String A = "addf yiuii";
		String a[] = A.split(" ");
		System.out.println(a[a.length-1].length());
	}
}
