/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

The given array is not null

Examples

{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
*/

public class Solution {
  public int maxTrapped(int[] array) {
    if (array.length < 2) return 0;
    int leftMax = array[0];
    int rightMax = array[array.length - 1];
    int left = 0;
    int right = array.length - 1;
    int sum = 0;
    while (left <= right) {
      int height = 0;
      if (leftMax < rightMax) {
        height = array[left] >= leftMax ? 0 : leftMax - array[left];
        if (array[left] >= leftMax) leftMax = array[left];
        left++;
      } else {
        height = array[right] >= rightMax ? 0 : rightMax - array[right];
        if (array[right] >= rightMax) rightMax = array[right];
        right--;
      }
      sum += height;
    }
    return sum;
  }
}
