package programsProblem.practice.array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IceCreamParlour {
    public static List<Integer> iceCreamParlor(int m, List<Integer> arr) {
        List<Integer> resArr = new ArrayList<>();

        int i = 0, j = 1;
        while (i < arr.size() && j < arr.size()){
            if(m - arr.get(i) == arr.get(j)){
                resArr.add(i + 1);
                resArr.add(j + 1);
                break;
            }

            if(j == arr.size() - 1){
                i++;
                j = i;
            }
            j++;
        }

        return resArr;
    }

    /**
     * Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
     * Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
     * <p>
     * Example.
     * The two flavors that cost  and  meet the criteria. Using -based indexing, they are at indices  and .
     * Function Description
     * Complete the icecreamParlor function in the editor below.
     * <p>
     * icecreamParlor has the following parameter(s):
     * int m: the amount of money they have to spend
     * int cost[n]: the cost of each flavor of ice cream
     * Returns
     * int[2]: the indices of the prices of the two flavors they buy, sorted ascending
     * <p>
     * Input Format
     * The first line contains an integer, , the number of trips to the ice cream parlor. The next  sets of lines each describe a visit.
     * Each trip is described as follows:
     * The integer , the amount of money they have pooled.
     * The integer , the number of flavors offered at the time.
     * space-separated integers denoting the cost of each flavor: .
     * Note: The index within the cost array represents the flavor of the ice cream purchased.
     * <p>
     * STDIN       Function
     * -----       --------
     * 2           t = 2
     * 4           k = 4
     * 5           cost[] size n = 5
     * 1 4 5 3 2   cost = [1, 4, 5, 3, 2]
     * 4           k = 4
     * 4           cost[] size n = 4
     * 2 2 4 3     cost=[2, 2,4, 3]
     *
     * @param args
     * @throws IOException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                List<Integer> result = iceCreamParlor(m, arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
