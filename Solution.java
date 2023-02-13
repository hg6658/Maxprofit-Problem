import java.util.*;

class Solution{

    static int max(int a, int b) { return (a > b) ? a : b; }
    
    public static pack knapsack(int capacity,int[] time,int[] earning,int idx,int[] front,int ef){

        if(capacity ==0 ||idx == time.length){
            return new pack(ef,front);
        }

        pack notTake = knapsack(capacity, time, earning, idx+1, front,ef);

        pack take = new pack(0,new int[3]);
        int[] newFront = new int[3];
        for(int i=0;i<front.length;i++){
            newFront[i] = front[i];
        }
        if(time[idx]<=capacity){
            newFront[idx]++;
            take = knapsack(capacity-time[idx], time, earning, idx, newFront,ef+earning[idx]);
        }


        if(notTake.ans>take.ans){
            return notTake;
        }else{
            return take;
        }

     
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER TIME UNIT:");
        int w = in.nextInt();
        int[] time = new int[]{5,4,10};
        int[] earning = new int[]{1500,1000,3000};
        int[] front = new int[time.length];
        pack  ans = knapsack(w, time, earning, 0, front,0);
        System.out.println(ans.ans);
        char[] types  = new char[]{'T','P','C'};
        for(int i=0;i<ans.set.length;i++){
            System.out.print(types[i]+":"+ans.set[i]);
        }
        System.out.println();
    }
}

class pack{
    int ans;
    int[] set;

    pack(int ans,int[] set){
        this.ans = ans;
        this.set = set;
    }

}