class Solution{
    public int appendCharacters(String s, String t){
        String temp = s;
        for(int i = 0; i < t.length(); i++){
            if(temp.indexOf(t.charAt(i)) == -1) return t.length() - i;
            else{
                temp = temp.substring(temp.indexOf(t.charAt(i)));
            }
        }
        return 0;
    }
}
