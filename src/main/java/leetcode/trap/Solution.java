package leetcode.trap;

/**
 * @author Alan
 * @Description
 * @date 2023.08.12 17:12
 */
public class Solution {

    public int trap2(int[] height) {
        // 双指针。与先确定好左右的最大值类似。可以不同同时确定左右的最大值，其中一方确定且小于另一边的当前最大值，即可计算接水面积
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int res = 0;
        for(int i = 0; i < height.length; i ++){
            if(leftMax < rightMax){
                leftMax = Math.max(leftMax,height[left]);
                res += leftMax - height[left];
                left ++;
            }else{
                rightMax = Math.max(rightMax,height[right]);
                res += rightMax - height[right];
                right --;
            }
        }
        return res;


    }

    // 每一个位置能装的水取决于，向左包含自己的最大值，向右包含自己的最大值，两个最大值中较小的一个 减去 当前位置占用的空间
    public int trap(int[] height) {
        // 确定每个索引往左的最大值
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        for(int i = 1; i < height.length; i ++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        // 确定每个索引往右的最大值
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = height[height.length-1];
        for(int i = height.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        // 计算面积
        int res = 0;
        for(int i = 0; i < height.length; i ++){
            int curr = Math.min(maxLeft[i],maxRight[i]) - height[i];
            res += curr;
        }
        return res;
    }
}
