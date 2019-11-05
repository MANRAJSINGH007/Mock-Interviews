import java.util.*;

class Pair{
    int freq;
    int occurence;
    
    Pair(int freq, int occurence){
        this.freq = freq;
        this.occurence = occurence;
    }
}

public class Main {

	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        HashMap<Integer, Pair> map = new HashMap<>();
        
        for(int i = 0; i < Math.min(n, k); i++){
            int curr = arr[i];
            if(!map.containsKey(curr)){
                map.put(curr, new Pair(1, i));
            }
            else{
                int curr_freq = map.get(curr).freq;
                curr_freq++;
                map.put(curr, new Pair(curr_freq, i));
            }
        }
        
        System.out.println(map.size());
        
        for(int i = k; i < n; i++){
            Pair prev = map.get(arr[i - k]);
            if(prev.freq == 1) map.remove(arr[i - k]);
            else prev.freq--;
            int curr = arr[i];
            if(!map.containsKey(curr)){
                map.put(curr, new Pair(1, i));
            }
            else{
                int curr_freq = map.get(curr).freq;
                curr_freq++;
                map.put(curr, new Pair(curr_freq, i));
            }
            
            System.out.println(map.size());
        }

	}

}
