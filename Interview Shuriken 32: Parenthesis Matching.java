import java.util.Scanner;

public class Main {

	public static boolean check(String s, int n, int i, int opening){
        if(i == n){
            if(opening == 0) return true;
            return false;
        }
        
        char curr = s.charAt(i);
        
        if(opening == 0){
            if(curr == ')') return false;
            return check(s, n, i + 1, opening + 1);
        }
        
        else if(s.charAt(i) == '('){
            return check(s, n, i + 1, opening + 1);
        }
        
        return check(s, n, i + 1, opening) || check(s, n, i + 1, opening + 1) || check(s, n, i + 1, opening - 1);
    }
    
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(check(s, s.length(), 0, 0));

	}

}
