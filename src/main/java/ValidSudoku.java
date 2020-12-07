import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] matrix = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println((isValid(matrix)?"YES":"NO"));
    }

    private static boolean isMatrixValid(char[][] matrix, int colCount, int rowCount) {
        Set set = new HashSet();
        for(int col=0 + 3*colCount; col < 3; col++) {
            for(int row=0 + 3*rowCount; row < 3; row++) {
                if(matrix[col][row] != '.' && !set.add(matrix[col][row])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] matrix) {
        if(matrix.length != 9 && matrix[0].length != 9) {
            return false;
        }

        for(int colStart = 0; colStart<3; colStart++) {
            for(int rowStart=0; rowStart<3; rowStart++) {
                if(!isMatrixValid(matrix, colStart, rowStart)) {
                    return  false;
                }
            }
        }
        return true;
    }
}
