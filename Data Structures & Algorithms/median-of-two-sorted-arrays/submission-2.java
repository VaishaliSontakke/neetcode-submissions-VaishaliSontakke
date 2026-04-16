class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1 2 3 4 5 // 5 6
        //   0 1 2 3 4    0 1
        // 1 2 3 4 5 5 6 7


        int n = nums1.length + nums2.length;
        int m1=0, m2=0;
        int i=0, j=0;
        int count = 0;
        // 1 2   3 4     2+3/2 = 2.5
        // 0 <= 2  count 1 m2 0 m1 1
        // 1 <= 2  count 2 m2 1 m1 2
        // 2 <= 2  count 3 m2 2 m1 3 
        // one can reach end and m1 and m2 both might be found in another array.
        while((i < nums1.length || j < nums2.length) && count <= ((n/2))){
            count++;
            m2 = m1;
            if(i == nums1.length){
                m1 = nums2[j++];
                continue;
            }
            if(j == nums2.length){
                m1 = nums1[i++];
                continue;
            }
            if(nums1[i] <= nums2[j]){
                m1 = nums1[i];
                i++;
            } else {
                m1 = nums2[j];
                j++;
            }
        }

        if(n % 2 == 0){
            double median = (m1 + m2) / 2.0;
            return median;
        } else {
            return m1;
        }
        
    }
}
