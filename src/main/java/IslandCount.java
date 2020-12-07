import java.util.Arrays;

class IslandCount {
    public int numIslands(int[][] grid) {

        int totalRows = grid.length;
        int totalCols = grid[0].length;

        int islandCount = 0;
        boolean[][] visitedGrid = new boolean[totalRows][totalCols];
        for(int row = 0; row < totalRows; row++) {
            for(int col = 0; col < totalCols; col++) {
                if(grid[row][col] == 1 && !visitedGrid[row][col]) {
                    traverseAndMark(row, col, grid, visitedGrid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void traverseAndMark(int row, int col, int[][] grid, boolean[][] visitedGridTomark) {
        visitedGridTomark[row][col]= true;

//        int[] directionRowCoordinate = {-1,-1,-1,0,0,1,1,1};
//        int[] directionColCoordinate = {-1,0,1,-1,1,-1,0,1};

        int[] directionRowCoordinate = {0, -1, 0, 1};
        int[] directionColCoordinate = {-1, 0, 1, 0};

        for(int counter = 0; counter < directionRowCoordinate.length; counter++) {
            int newRow = row+directionRowCoordinate[counter];
            int newCol = col+directionColCoordinate[counter];
            if(isEligible(newRow, newCol,
                    grid,
                    visitedGridTomark
            )) {

                traverseAndMark(newRow, newCol,grid,visitedGridTomark);
            }
        }
    }

    private boolean isEligible(int row, int col, int[][] grid, boolean[][] isVisited) {
        return row < (grid.length) && row >=0 &&
                col < (grid[0].length) && col >=0 &&
                !isVisited[row][col] &&
                grid[row][col] == 1;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        int[][] newInput = Arrays.stream(input).map(a ->
                Arrays.stream(a)
                        .mapToInt(Integer::parseInt).toArray()
        ).toArray(int[][]::new);
        System.out.println(new IslandCount().numIslands(newInput));

    }
}