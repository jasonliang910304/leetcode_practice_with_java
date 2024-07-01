class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("[.]");
        String[] version2Array = version2.split("[.]");
        int[] version1IntArray = new int[version1Array.length];
        int[] version2IntArray = new int[version2Array.length];

        for(int i = 0; i < version1Array.length; i++){
            version1IntArray[i] = Integer.parseInt(version1Array[i]);
        }
        for(int i = 0; i < version2Array.length; i++){
            version2IntArray[i] = Integer.parseInt(version2Array[i]);
        }

        int theLongerLength = Math.max(version1IntArray.length, version2IntArray.length);

        for(int i = 0; i < theLongerLength; i++){
            int num1 = version1IntArray.length > i ? version1IntArray[i] : 0;
            int num2 = version2IntArray.length > i ? version2IntArray[i] : 0;

            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
        }
        return 0;
    }
    public int compareVersion_byGPT(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        return 0;
    }
}
