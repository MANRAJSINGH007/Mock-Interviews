
public class Solution {

/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/
    
    static int count=0;
    
    public static int func(BinaryTreeNode<Integer> root){
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            count++;
            return root.data;
        }
        
        else if(root.left!=null && root.right==null){
            int x1=func(root.left);
            if(x1==-1){
                return -1;
            }
            if(x1==root.data){
                count++;
                return root.data;
            }
            
            return -1;
        }
        
        else if(root.left==null && root.right!=null){
            int x1=func(root.right);
            if(x1==-1){
                return -1;
            }
            if(x1==root.data){
                count++;
                return root.data;
            }
            
            return -1;
        }
        else{
            int x1=func(root.right);
            int x2=func(root.left);
            if(x1==-1 || x2==-1){
                return -1;
            }
            if(x1==root.data && x2==root.data){
                count++;
                return root.data;
            }
            
            return -1;
        }
        
    }
	
	public static int unival(BinaryTreeNode<Integer> root){
        
        count=0;
        int x=func(root);
        return count;
		
	}


	
	
}
