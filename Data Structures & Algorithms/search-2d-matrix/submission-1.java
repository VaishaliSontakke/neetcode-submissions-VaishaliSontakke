class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int t = m*n;
        int l = 0;
        int r = t-1;
        while(l <= r){
            int mid = (l+r)/2;
            int i = mid/n;   // 5/4  : 1 second row //
            int j = mid%n;   // 5%3  :  2 third element //
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }
}
