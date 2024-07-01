class Solution {
    public String reversePrefix(String word, char ch) {
        int remainPos = word.indexOf(ch) + 1;
        StringBuffer reversed = new StringBuffer(word.substring(0, remainPos)); //substring include start but end is not included
        return reversed.reverse() + word.substring(remainPos);
    }
}
