import java.util.ArrayList;

public class RecursionExercises {


    public int factorial(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }else{
            if(n == 1){
                return 1;
            }


            int newN = n -1;


            return n * factorial(newN);
        }
    }


    public int sum1(int n){
        if(n < 0){
            return 0;
        }

        // base
        if(n == 0){
            return 0;
        }else{
            int newN = n -1;

            if(n % 3 == 0){
                return sum1(newN);
            } else{
                return n + sum1(newN);
            }

        }
    }

    public int sum2(ArrayList<Integer> list){

        if(list == null){
            return 0;
        }
        if(list.isEmpty()){
            return 0;
        }else{
            int number = list.get(0);
            list.remove(0);
            if(number % 3 == 0){
                return sum2(list);
            }else{
                return number + sum2(list);
            }
        }



    }






    public String duplicateVowels(String str){

        if(str == null){
            return null;
        }
        // Go by character by character
        // if vowel, duplicate it

        if(str.isEmpty()){
            return "";
        }
        else {
            String firstLetter = str.charAt(0) + "";
            String remainStr = str.substring(1);

            if(firstLetter.equalsIgnoreCase("a") ||
                    firstLetter.equalsIgnoreCase("e") ||
                    firstLetter.equalsIgnoreCase("i") ||
                    firstLetter.equalsIgnoreCase("o") ||
                    firstLetter.equalsIgnoreCase("u") ||
                    firstLetter.equalsIgnoreCase("y")
                    ){
                String twoLetters = firstLetter;
                twoLetters += firstLetter;
                return twoLetters + duplicateVowels(remainStr);
            }
            else{
                return firstLetter + duplicateVowels(remainStr);
            }
        }


    }

}
