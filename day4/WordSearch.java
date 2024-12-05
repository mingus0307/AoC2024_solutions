import java.util.*; 
import java.io.*; 

public class WordSearch {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("this is the instances of XMAS: " + getXmas(get2DArray(getString())));
        System.out.println("this is the amount of X-MAS: " + findMAS(get2DArray(getString())));        
    }
     
    public static int getXmas(char[][] text) {
        int xmasCount = 0;

        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[0].length; j++) {
                // Horizontal: XMAS
                if (j <= text[0].length - 4 && text[i][j] == 'X' && text[i][j + 1] == 'M' && text[i][j + 2] == 'A' && text[i][j + 3] == 'S') {
                    xmasCount++;
                }
                // horizontally backwards: SAMX
                if (j <= text[0].length - 4 && 
                    text[i][j] == 'S' && text[i][j + 1] == 'A' && text[i][j + 2] == 'M' && text[i][j + 3] == 'X') {
                    xmasCount++;
                }
                // top left to down right:  XMAS
                if (i <= text.length - 4 && j <= text[0].length - 4 &&
                    text[i][j] == 'X' && text[i + 1][j + 1] == 'M' && text[i + 2][j + 2] == 'A' && text[i + 3][j + 3] == 'S') {
                    xmasCount++;
                }
                // top left to down right: SAMX
                if (i <= text.length - 4 && j <= text[0].length - 4 &&
                    text[i][j] == 'S' && text[i + 1][j + 1] == 'A' && text[i + 2][j + 2] == 'M' && text[i + 3][j + 3] == 'X') {
                    xmasCount++;
                }
                // down left tp top right: XMAS
                if (i >= 3 && j <= text[0].length - 4 &&
                    text[i][j] == 'X' && text[i - 1][j + 1] == 'M' && text[i - 2][j + 2] == 'A' && text[i - 3][j + 3] == 'S') {
                    xmasCount++;
                }
                // down left to top right: SAMX
                if (i >= 3 && j <= text[0].length - 4 &&
                    text[i][j] == 'S' && text[i - 1][j + 1] == 'A' && text[i - 2][j + 2] == 'M' && text[i - 3][j + 3] == 'X') {
                    xmasCount++;
                }
                // Vertical upwards: XMAS
                if (i <= text.length - 4 &&
                    text[i][j] == 'X' && text[i + 1][j] == 'M' && text[i + 2][j] == 'A' && text[i + 3][j] == 'S') {
                    xmasCount++;
                }
                // Vertical down : SAMX
                if (i <= text.length - 4 &&
                    text[i][j] == 'S' && text[i + 1][j] == 'A' && text[i + 2][j] == 'M' && text[i + 3][j] == 'X') {
                    xmasCount++;
                }
            }
        }

        return xmasCount;
    }

    public static char[][] get2DArray(String text) {
        //put the single chars into a char array 140/140
        char[][] charTwoDArr = new char[140][140]; 
        int textIndex = 0; 
        char[] textArray = text.toCharArray();

        for (int i = 0; i < charTwoDArr.length; i++) {
  
            for (int j = 0; j < charTwoDArr.length; j++) {
                charTwoDArr[i][j] = textArray[textIndex];
                textIndex++;  
            }
        }
        // print the array to check i didn't fuck up 
        /*for (int i = 0; i < charTwoDArr.length; i++) {
            for (int j = 0; j < charTwoDArr.length; j++) {
                System.out.print(charTwoDArr[i][j]);
            }
            System.out.println(); 
        }*/
        return charTwoDArr;

    }

    public static int findMAS(char[][] text) {
        int count = 0;

        for (int i = 1; i < text.length - 1; i++) {
            for (int j = 1; j < text[0].length - 1; j++) {
                // check diagonal "X"-pattern
                if ((i - 1 >= 0 && i + 1 < text.length && j - 1 >= 0 && j + 1 < text[0].length)) {
                    // check MAS pattern diagonal
                    if (isMAS(text, i - 1, j - 1, i, j, i + 1, j + 1) && // \
                        isMAS(text, i - 1, j + 1, i, j, i + 1, j - 1)) { // /
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Helper-Method: check if the pattern gives out MAS/SAM
    private static boolean isMAS(char[][] text, int x1, int y1, int x2, int y2, int x3, int y3) {
        return (text[x1][y1] == 'M' && text[x2][y2] == 'A' && text[x3][y3] == 'S') ||
               (text[x1][y1] == 'S' && text[x2][y2] == 'A' && text[x3][y3] == 'M');
    }
    

       
    

    public static String getString() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("text.txt")); 
        String fin = "";

        while(scanner.hasNextLine()) {
            fin += scanner.nextLine(); 
        }

        return fin; 
    }
    
}
