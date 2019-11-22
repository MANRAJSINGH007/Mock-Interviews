public class Solution {
    
    public static int[] preprocess(String pattern){
        
        int n= pattern.length();
        int[] lps = new int[n];
        
        int j = 0;
        int i = 1;
        
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j + 1;
                i++;
                j++;
            } else{
                if(j == 0) i++;
                else j = lps[j - 1];
            }
        }
        
        return lps;
        
        
    }
    
	public static int findString(String text, String pattern) {
        
        int i = 0;
        int j = 0;
        
        int[] lps = preprocess(pattern);
        
        int index = 0;
        
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else{
                if(j == 0) i++;
                else j = lps[j - 1];
                index = i - j;
            }
        }
        
        if(j == pattern.length()) return index;
        return -1;

	}
}
