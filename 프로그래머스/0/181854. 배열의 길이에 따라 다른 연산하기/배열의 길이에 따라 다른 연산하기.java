class Solution {
    public int[] solution(int[] arr, int n) {
        int temp = (arr.length + 1) % 2;
        for(int i=temp; i<arr.length; i+=2) {
            arr[i] += n;
        }
        return arr;
    }
}