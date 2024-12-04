import java.util.*; 
import java.io.*; 
import java.util.regex.*; 

public class Multiplication {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is the sum for part 1: " + fixMemoryPartOne(getString()));
        System.out.println("This is the correct sum for part 2: " + fixMemoryPartTwo());

    }
    
    /**
     * regex the term "mul(x, y)" out of the string and calculate the sum
     */ 
    public static int fixMemoryPartOne(String text) throws FileNotFoundException{
        int sum = 0; 
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
     * cuts the text up in a list with the relevant parts and calculates with it with the solution to one 
     */ 
    public static int fixMemoryPartTwo() throws FileNotFoundException{
        String text = getString();
        List<String> dos = getDos(text);
        int sum = 0; 

        for (int i = 0; i < dos.size(); i++) {
            sum += fixMemoryPartOne(dos.get(i));  
        }
        return sum; 
    }
    /**
     * extracts the parts we wanna use for our calculation 
     */ 
    public static List<String> getDos(String text){
        List<String> dos = new ArrayList();
        boolean isFirst = true; 
        // get everything before the first don't and then everything between a "do" and "don't"
        String regrex = "(.*?)don't";

        Pattern pattern = Pattern.compile(regrex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            if(matcher.group(1) != null && isFirst){
                isFirst = false; 
                dos.add(matcher.group(1)); 
            }
        }

        String regrexSec = "do\\(\\)(.*?)don't\\(\\)";
        Pattern patternSec = Pattern.compile(regrexSec);
        Matcher matcherSec = patternSec.matcher(text);
            
        while(matcherSec.find()) {
            if(matcherSec.group(1) != null){
                dos.add(matcherSec.group(1));
            }
        }

        //System.out.println(dos); 
        return dos; 
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
