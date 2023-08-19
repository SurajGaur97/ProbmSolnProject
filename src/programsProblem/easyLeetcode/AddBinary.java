package programsProblem.easyLeetcode;
//15-jun-2023 done
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
            System.gc();
        }
        StringBuilder resStr = new StringBuilder();
        boolean carry = false;
        int j = b.length() - 1;

        for(int i = a.length() - 1; i >= 0 ; i--) {
            if(j >= 0) {
                if(a.charAt(i) == '1' && b.charAt(j) == '1') {
                    if(carry) {
                        resStr.insert(0, "1");
                    } else {
                        resStr.insert(0, "0");
                        carry = true;
                    }
                }else if((a.charAt(i) == '0' && b.charAt(j) == '1')
                        || (a.charAt(i) == '1' && b.charAt(j) == '0')) {
                    if(carry) {
                        resStr.insert(0, "0");
                    } else {
                        resStr.insert(0, "1");
                    }
                }else {
                    if(carry) {
                        resStr.insert(0, "1");
                        carry = false;
                    } else {
                        resStr.insert(0, "0");
                    }
                }
                j--;
            } else {
                if(carry) {
                    if(a.charAt(i) == '1') {
                        resStr.insert(0, "0");
                        carry = true;
                    }else {
                        resStr.insert(0, "1");
                        carry = false;
                    }
                } else {
                    resStr.insert(0, a.substring(0, i + 1));
                    break;
                }
            }
        }
        if(carry) resStr.insert(0, "1");
        return resStr.toString();
    }
}
