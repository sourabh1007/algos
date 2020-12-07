//Print all sub sequences of a given array

public class SubSequenceArray {

    private void getCombinations(int [] input) {

        int[] temp = new int[input.length];
        int index = 0;
        createCombination(input, index, temp);
    }

    private void print(int[] input, int[] temp) {
        int count = 0;
        for(int tempItr : temp){
            if(tempItr == 1) {
                System.out.print(input[count]);
            }
            count++;
        }
    }
    private void createCombination(int[] input, int index, int[] temp) {
        if(index == input.length) {
            System.out.println("");
            print(input, temp);
            return;
        }
        temp[index] = 1;
        createCombination(input, index + 1 , temp);
        temp[index] = 0;
        createCombination(input, index + 1 , temp);
    }

    public static void main(String[] args) {
        int [] arrInput = {1, 2, 3};
        new SubSequenceArray().getCombinations(arrInput);
    }
}

