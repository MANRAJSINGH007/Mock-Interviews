class Solution {
    
    public String removeKdigits(String str, int k) {
        
        int org_k=k;
        int n=str.length();
        Stack<Integer> stack=new Stack<Integer>();
        
        for(int i=0;i<str.length();i++){
            
            int num=(int)str.charAt(i)-48;
            while(stack.size()>0 && stack.peek()>num && k>0){
                stack.pop();
                k--;
            }
            
            stack.push(num);
        }
        
        if(n==1 && k==1){
            return "0";
        }
        
        String ans="";
        while(stack.size()>0){
            if(stack.size()<=n-org_k)
                ans=Integer.toString(stack.pop())+ans;
            else
                stack.pop();
        }
        
        int j=0;
        while(j<ans.length() && ans.charAt(j)=='0'){
            j++;
        }
        
        if(j==ans.length()){
            return "0";
        }
        
        return ans.substring(j,ans.length());
        
    }
}
