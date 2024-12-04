import java.util.*; 
import java.io.*; 
import java.util.regex.*; 

public class Multiplication {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is the correct sum: " + fixMemory());
    }
    
    /**
     * regex the term "mul(x, y)" out of the string and calculate the sum
     */ 
    public static int fixMemory() throws FileNotFoundException{
        int sum = 0; 
        String text = getString();
        String regex = "mul\\(\\d+,\\d+\\)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String s = matcher.group();
            sum += multiplicate(s);

        }

        return sum; 
    }
    
    /**
     * build  a single string out of the file 
     */  
    public static String getString() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("text.txt"));
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            sb.append(s);
        }

        return sb.toString();

    }
    
    /**
     * regex the numbers out of the terms and calculate
     */ 
    public static int multiplicate(String mul){
        int fin = 1; 
        //practising regex 
        // gets you an finite amount of digits in a row
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(mul);

        while (matcher.find()) {
            fin *= Integer.parseInt(matcher.group());
        }
        return fin; 
    }
}
