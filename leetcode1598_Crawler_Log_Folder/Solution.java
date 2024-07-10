public class Solution {
    public int minOperations(String[] logs) {
        int ret = 0;
        for (String operate : logs) {
            if (operate.equals("../")) {
                if (ret > 0) ret--;
            }
            else if (!operate.equals("./")) {
                ret++;
            }
        }
        return ret;
    }
}
