class Solution {
    
    public static TreeNode func(TreeNode root, int x, int y){
        
        if(root==null){
            return null;
        }
        
        if(root.val<x){
            return func(root.right,x,y);
        }
        
        else if(root.val>y){
            return func(root.left,x,y);
        }
        
        root.left=func(root.left,x,y);
        root.right=func(root.right,x,y);
        return root;
        
    }
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return func(root,L,R);
    }
}
