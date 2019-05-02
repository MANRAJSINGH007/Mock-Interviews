class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>(); 
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int ans=0;
        char prev=s.charAt(0);
        
        if(s.length()==1){
            return map.get(prev);
        }
        
        int flag=0;
        int n=s.length();
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            if(map.get(curr)<=map.get(prev)){
                ans+=map.get(prev);
                prev=curr;
                if(i==n-1){
                    ans+=map.get(curr);
                }
            }
            else{
                ans+=map.get(curr)-map.get(prev);
                if(i==n-1){
                    break;
                }
                if(i==n-2){
                    ans+=map.get(s.charAt(i+1));
                    break;
                }
                i++;
                prev=s.charAt(i);
            }
        }
        
        return ans;
        
    }
}
