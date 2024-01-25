package programsProblem.practice.string;


public class ChristmasGifts {
    private int crishtmasGift(int input1, String input2) {
        if(input2.contains("TH")){
            return 0;
        }
        if(input2.contains("HT")){
            return input2.indexOf("HT") + 1;
        }
        return -1;
    }
}
