
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < points.length; i++) {

            int a = points[i][0];
            int b = points[i][1];

            // Check if the point is valid
            if (a == x || b == y) {

                // Calculate Manhattan distance
                int distance = Math.abs(x - a) + Math.abs(y - b);

                // Update minimum distance
                if (distance < minDistance) {
                    minDistance = distance;
                    result = i;
                }
            }
        }

        return result;
    }
}
