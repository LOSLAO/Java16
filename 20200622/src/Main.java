import java.util.Arrays;

public class Main {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int ans = gifts[n/2];
        int num = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == ans) {
                num++;
            }
        }
        return num <= n/2 ? 0 : ans;
    }

    public static  Node partition(Node head,int x){

        Node small=null;
        Node big=null;
        Node smallLast=null;
        Node bigLast=null;
        Node cur=head;
        while(cur!=null)
        {

            if(cur.val<x)
            {
                Node next =cur.next;
                if(small==null)
                {
                    small=cur;
                }else{
                    smallLast.next=cur;
                }
                smallLast=cur;
                cur=next;

            }else{
                Node next =cur.next;
                if(big==null)
                {
                    big=cur;
                }else{
                    bigLast.next=cur;
                }
                bigLast=cur;
                cur=next;

            }

        }
        if(small==null)
        {
            return big;
        }else{
            smallLast.next=big;
            if(bigLast!=null)
            {
                bigLast.next=null;

            }
            return small;
        }


    }


}
