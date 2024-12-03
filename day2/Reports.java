import java.util.*; 
import java.io.*; 

public class Reports {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is the number of save reports: " + saveReports()); 
    }

    public static int saveReports() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("text.txt"));
        int saveReps = 0;  
        
        //take the report out of the file and add them to a list; 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); 
            List<Integer> lineArray = new ArrayList<>(); 
            
            String[] numbers = line.trim().split("\\s");
            for (String num : numbers) {
                lineArray.add(Integer.parseInt(num));
            }

            System.out.println(lineArray); 
            if (analyze(lineArray)) {
                saveReps++; 
            }
        }
        

        return saveReps; 
    }

    public static boolean analyze(List<Integer> line) {
        //we have the list with the current report 
        //lets go analyze it 
        boolean isSave = true; 
        boolean isIncreasing = false;

        for (int i = 0; i < line.size()-1; i++) {
            //get the right numbers to check the condition
            int canidate = line.get(i);
            int successor = line.get(i+1); 
            // 24 20 18 15 9
       
            
            //determine if increasing or decreasing
            if (i == 0 ) {
                isIncreasing = canidate < successor; 
            } 
            
            //kick every one if the distance is out of bounds
            if (Math.abs(canidate - successor) < 1 || Math.abs(canidate - successor) > 3) {return false;}

            if(isIncreasing && canidate > successor){
                return false; 
            } else if(!isIncreasing && canidate < successor) {
                return false;  
            }
         }
        return isSave; 

    }
}
