class Solution {
    
    public static int fun2(ListNode head, ListNode parent){
        
        if(head==parent){
            int sum=parent.val+1;
            parent.val=sum%10;
            return sum/10;
        }
        
        int sum=fun2(head.next,parent)+head.val;
        head.val=sum%10;
        return sum/10;
        
    }
    
    public static int func(ListNode curr1, ListNode curr2){
        
        if(curr1==null){
            return 0;
        }
        
        int sum=func(curr1.next,curr2.next)+curr1.val+curr2.val;
        curr1.val=sum%10;
        return sum/10;
        
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null){
            return l2;
        }
        
        if(l2==null){
            return l1;
        }
        
        int c1=0;
        int c2=0;
        
        ListNode t=l1;
        while(t!=null){
            c1++;
            t=t.next;
        }
        
        t=l2;
        while(t!=null){
            c2++;
            t=t.next;
        }
        
        // return new ListNode(c2);
        
        if(c1>=c2){
            
            int count=0;
            ListNode temp=l1;
            ListNode parent=null;
            while(count!=c1-c2){
                count++;
                parent=temp;
                temp=temp.next;
            }
            
            if(temp==l1){
                int final_carry=func(l1,l2);
                if(final_carry==0){
                    return l1;
                }
                
                ListNode head=new ListNode(1);
                head.next=l1;
                return head;
            }
            
            int carry=func(temp,l2);
            if(carry==0){
                return l1;
            }
            
            carry=fun2(l1,parent);
            if(carry==0){
                return l1;
            }
            
            ListNode head=new ListNode(1);
            head.next=l1;
            return head;

        }
        
        else{
            
            int count=0;
            ListNode temp=l2;
            ListNode parent=null;
            while(count!=c2-c1){
                count++;
                parent=temp;
                temp=temp.next;
            }
            
            int carry=func(temp,l1);
            if(carry==0){
                return l2;
            }
            
            carry=fun2(l2,parent);
            if(carry==0){
                return l2;
            }
            
            ListNode head=new ListNode(1);
            head.next=l2;
            return head;
            
        }
        
    }
}
