import static java.lang.String.format;

public class StringPattern {
    public static void main(String[] args) {
       // search("TEST","THIS IS A TEST TEXT");
        search("AABA", "AABAACAADAABAABA");
    }

    private static void search(String pattern, String data) {
        search(pattern.toCharArray(), data.toCharArray());
    }

    private static void search(char[] pattern, char[] data) {
        int dataIndex = 0;

        System.out.println(pattern);
        System.out.println(data);
        System.out.println();

        for(char dataCharacter: data) {
            int counter = 0;
            int temDataIndex = dataIndex;
            if((data.length - dataIndex) > pattern.length -1) {
                for(char ptrn: pattern) {
                    if(data[temDataIndex] == ptrn) {
                        counter++;
                        temDataIndex++;
                        continue;
                    }
                    break;
                }
                if(counter == pattern.length) {
                    System.out.println("Pattern found at " + dataIndex);
                }
            } else {
                break;
            }

            dataIndex++;
        }
    }
}
