// https://leetcode.com/problems/reorganize-string

class Solution {
    public String reorganizeString(String S) {
        int freq[] = new int[26];
		int n = S.length();
		
		for(int i=0;i<n;i++) {
			char ch = S.charAt(i);
			freq[ch - 'a'] ++;
			if(freq[ch - 'a'] > 1 && freq[ch - 'a'] > (n+1)/2) {
				return "";
			}
		}
		
		char ans[] = new char[n];
		ans[0] = max(freq, '$');
		
		for(int i=1;i<n;i++) {
			if(i % 2 == 0) {
				ans[i] = max(freq, ans[i-1]);
			}else {
				ans[i] = min(freq, ans[i-1]);
			}
		}
		
		return new String(ans);
    }
	
	public static char min(int freq[], char c) {
		int val = Integer.MAX_VALUE;
		char ch = '$';
		
		for(int i=0;i<freq.length;i++) {
			char temp = (char)('a' + i);
			if(freq[i] > 0 && freq[i] < val && temp != c) {
				val = freq[i];
				ch = (char)('a' + i);
			}
		}
		
		freq[ch - 'a'] --;
		return ch;
	}
	
	public static char max(int freq[], char c) {
		int val = Integer.MIN_VALUE;
		char ch = '$';
		
		for(int i=0;i<freq.length;i++) {
			char temp = (char)('a' + i);
			if(freq[i] > 0 && freq[i] > val && temp != c) {
				val = freq[i];
				ch = (char)('a' + i);
			}
		}
		
		freq[ch - 'a'] --;
		return ch;
	}
}