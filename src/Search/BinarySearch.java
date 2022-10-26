package Search;

/**
 * @author Shangchen Yao
 * @date 2022/10/25 23:39
 *
 * 二分查找，使用前提是数组是有序数组，，同时数组中无重复元素
 * 返回值为target的数组下标
 * 写二分法，区间的定义一般为两种，左闭右闭即[left, right]，或者左闭右开即[left, right)。
 */


public class BinarySearch {
    /**
     * 第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）。
     *
     * 区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
     * while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
     * if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1
     */
    //定义target在一个左闭右闭的区间里
    public int binarySearch1(int[] nums, int target){
        //避免target不在nums中却进行多次运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left+(right-left)/2;// 防止溢出 等同于(left + right)/2
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right) ，那么二分法的边界处理方式则截然不同。
     *
     * 有如下两点：
     *
     * while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
     * if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
     * @param nums
     * @param target
     * @return
     */
    //定义target在一个左闭右开的区间里
    public int binarySearch2(int[] nums, int target){
        //避免target不在nums中却进行多次运算
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;// 防止溢出 等同于(left + right)/2
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch2(nums, 4));
    }
}
