package algorithm;

/**
 * 功能:一组数组中取唯一的不重复的数据
 *
 * @author kmm on 2020/3/19
 */
public class GetOne {

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 34, 453, 453, 34, 45, 56, 45, 56};
        int result = getOne(arrays);
        System.out.println(result);
    }

    /**
     * 用异或的方式获取到数组中不重复的唯一数据
     * @param arrays
     * @return
     */
    private static int getOne(int[] arrays) {
        int result = 0;
        for (int i : arrays) {
            result ^= i;
        }
        return result;
    }
}
