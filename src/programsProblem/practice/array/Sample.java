package programsProblem.practice.array;

public class Sample {
	public static void main(String[] args) {
		Sample.solution("U", 5, new int[] {-1,-2,4,1,3,0}, new int[] {5,4,3,3,1,-1});
	}
	
	public static int solution(String direction, int radius, int[] X, int[] Y) {
        // Implement your solution here
        int count = 0;
        for(int i = 0; i < X.length; i++) {
            double dist = Math.sqrt(X[i] * X[i] + Y[i] * Y[i]);

            if(dist <= radius) {
                if(direction == "U" && Math.toDegrees(Math.atan(Y[i] / X[i])) >= 45 && Math.atan(Y[i] / X[i]) <= 135) {
                    count++;
                }
                else if(direction == "D" && Math.atan(Y[i] / X[i]) >= 225 && Math.atan(Y[i] / X[i]) <= 315) {
                    count++;
                }
                else if(direction == "R" && Math.atan(Y[i] / X[i]) >= 315 && Math.atan(Y[i] / X[i]) <= 45) {
                    count++;
                }
                else if(direction == "L" && Math.atan(Y[i] / X[i]) >= 135 && Math.atan(Y[i] / X[i]) <= 225) {
                    count++;
                }
            }
        }
        return count;
    }
}
