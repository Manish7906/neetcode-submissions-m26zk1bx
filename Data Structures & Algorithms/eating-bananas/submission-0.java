class Solution {
    public static double totalhours(int arr[],int i){
        double totalhours=0;
        for(int j=0;j<arr.length;j++){
            totalhours+=Math.ceil((double)arr[j]/i);
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] arr, int hours) {
        int low=1;
        int high=Arrays.stream(arr).max().getAsInt();
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            double th=totalhours(arr,mid);
            if(th<=hours){
                ans=mid;
                high=mid-1;
            } else  {
                low=mid+1;
            }
        }
        return ans;
    }
}
