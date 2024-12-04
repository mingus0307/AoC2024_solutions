import java.util.*;
import java.io.*; 


public class adventOne {

    /**
    * this class stores the two lists and implements of the used methods
    */
    public static class Pair {
        List<Integer> first = new ArrayList<>(); 
        List<Integer> second = new ArrayList<>();
        
        Pair(List<Integer> a, List<Integer> b){
            this.first = a; 
            this.second = b; 
            Collections.sort(first);
            Collections.sort(second);
        } 
        /**
        * determines the distance between the two numbers 
        * @return    sum     the distances of each pair in the lists added up
        */
        public int determineDistance(){
            int sum = 0;
            for (int i = 0; i < first.size(); i++) {
                int distance = (first.get(i) - second.get(i));
                sum += Math.abs(distance); 
            }
            return sum; 

        }

        public int similarityScore(){
            int similarity = 0;
            for (int i = 0; i < first.size(); i++) {
                int leftNumber = first.get(i); 
                int multiplicator = 0; 

                for (int j = 0; j < second.size(); j++) {
                    if (leftNumber == second.get(j)) {
                        multiplicator++; 
                    }
                }
                similarity += leftNumber * multiplicator; 
                multiplicator = 0; 
            } 
            
            return similarity;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

       Pair test =  makingTwoLists("text.txt");
       System.out.println("das ist die Distanz: " + test.determineDistance());
       System.out.println("Das ist der SimilarityScore: " + test.similarityScore()); 

        
                
    }

    public static Pair makingTwoLists(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));  

        List<Integer> first = new ArrayList<>(); 
        List<Integer> second = new ArrayList<>();
        boolean isFirstList = true; 
        
        while (input.hasNextInt()){

            if(isFirstList){
                first.add(input.nextInt());
                isFirstList = false; 
            } else {
                second.add(input.nextInt()); 
                isFirstList = true; 
            }
        }

        return new Pair(first, second);  

    }

}
