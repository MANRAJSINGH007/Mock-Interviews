class Solution {
    
    public static TreeNode min(TreeNode root){
        
        if(root==null){
            return root;
        }
        
        TreeNode p=root;
        while(p.left!=null){
            p=p.left;
        }
        
        return p;
        
    }
    
    public static TreeNode func(TreeNode root, TreeNode p){
        
        if(root==null){
            return null;
        }
        
        if(root==p){
            return min(p.right);
        }
        
        if(root.val>p.val){
            TreeNode ans=func(root.left,p);
            if(ans==null){
                return root;
            }
            
            return ans;
        }
        
        return func(root.right,p);
        
    }
    
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        return func(root,p);
    }
}
