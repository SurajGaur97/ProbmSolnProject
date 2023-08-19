package programsProblem.practice.maths;

public class ExcelSheetColumnNo {
    public int titleToNumber(String columnTitle) {
        int titleNo = 0;

        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            titleNo += ((int)columnTitle.charAt(i) - (int)'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
        }

        return titleNo;
    }
}
