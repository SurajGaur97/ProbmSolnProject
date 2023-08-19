package programsProblem.company.inMobi;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1SplitArr = version1.split(".");
        String[] v2SplitArr = version2.split(".");

        int length;
        if(v1SplitArr.length < v2SplitArr.length)
            length = v1SplitArr.length;
        else
            length = v2SplitArr.length;

        for(int i = 0; i < length; i++) {
            if(Integer.parseInt(v1SplitArr[i]) < Integer.parseInt(v2SplitArr[i]))
                return -1;
            else if(Integer.parseInt(v1SplitArr[i]) > Integer.parseInt(v2SplitArr[i]))
                return 1;
        }
        return 0;
    }
}
