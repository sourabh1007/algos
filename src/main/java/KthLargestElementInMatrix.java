import java.util.PriorityQueue;

/**
 * Given MxN matrix with sorted elements row wise and column wise, find the Kth largest element
 */
public class KthLargestElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {10, 30, 20, 40},
                {15, 25, 55, 45},
                {24, 79, 37, 48},
                {32, 33, 39, 50}
        };

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int k = 3;
        int col = matrix.length;
        int row = matrix[0].length;

        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(heap.size() < k) {
                    heap.add(matrix[i][j]);
                } else if(heap.peek() < matrix[i][j]){
                    heap.poll();
                    heap.add(matrix[i][j]);
                }

                System.out.println(heap);
            }
        }
        //System.out.println(heap.poll());
    }
}
