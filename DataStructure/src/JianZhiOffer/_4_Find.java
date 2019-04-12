package JianZhiOffer;

/**
 * @Date 2019/4/2 14:42
 */
public class _4_Find {
    public boolean Find(int target, int[][] array) {
        boolean found = false;
        int rows = array.length;
        int cols = array[0].length;

        if (array!=null&&rows>0&&cols>0) {
            for (int i = rows - 1, j = 0; i >= 0 && j < cols; ) {
                if (target == array[i][j]) {
                    return true;
                }
                if (target < array[i][j]) {
                    --i;
                    continue;
                }
                if (target > array[i][j]) {
                    ++j;
                    continue;
                }
            }
        }
        return found;
    }
}
