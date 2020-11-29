import java.util.Arrays;
import java.util.Scanner;

public class UserInputCheck {

    /**
     * check if the input is a valid file name format with filetype such as txt
     * @param userInput a file name with the fileType like .txt
     * @return true if it is a valid file name; false if it is not
     */
    protected boolean inputIsFileName(String userInput, String fileType){
        String[] splitInput =  userInput.split("\\.");
        if (splitInput.length>1) return splitInput[splitInput.length-1].equals(fileType);
        else return false;
    }

    protected String validTXTFileName(){
        Scanner scnr = new Scanner(System.in);
        String userInputS = scnr.nextLine();

        // create a boolean to check for all possible errors
        while(!inputIsFileName(userInputS,"txt")) {
            System.out.println("Invalid integer; try again according to the requirement.");
            userInputS = scnr.nextLine();
        }

        return userInputS;
    }

    /**
     * check if input is an integer
     * @param userInput check if the user input is a valid integer
     * @return true if it is a integer, false if it is not an integer
     */
    protected boolean inputIsInteger(String userInput){
        try{ Integer.parseInt(userInput);
            return true;
        } catch(NumberFormatException e){ return false; }
    }


    /**
     * check if the input does not meet requirement
     * @param userInput user input in string format
     * @param min minimum requirement for the integer
     * @param max maximum requirement for the integer
     * @return true if input is not valid; false if it is valid/no error
     */
    protected boolean inputIsNotRequiredInteger(String userInput, int min, int max){
        if (inputIsInteger(userInput)){
            int wordLenInput= Integer.parseInt(userInput);
            return (wordLenInput > max || wordLenInput < min);
        }
        return true;
    }


    /**
     *
     * @param min minimum requirement for the integer
     * @param max maximum requirement for the integer
     * @return a valid integer as required
     */
    protected int validInteger(int min, int max){
        Scanner scnr = new Scanner(System.in);
        String userInputS = scnr.nextLine();

        // create a boolean to check for all possible errors
        while(inputIsNotRequiredInteger(userInputS, min, max)) {
            System.out.println("Invalid integer; try again according to the requirement.");
            userInputS = scnr.nextLine();
        }

        return Integer.parseInt(userInputS);
    }


    /**
     * check if the input is a letter
     * @return if input is a letter
     */
    protected boolean inputIsLetter(String userInput){
        // check if input is a letter
        return userInput.matches("[a-z]") ;
    }


    /**
     * check if the input is already entered
     * @return true if it is already entered, false if it is not
     */
    protected boolean inputAlreadyEntered(String userInput, String alreadyEntered){
        // check if the current list already contain this letter
        return alreadyEntered.contains(userInput);
    }


    /**
     * convert all userInput string first  to lower letter
     * return a valid letter that is not already entered
     * @param alreadyEntered a array list of already entered letters to check against with
     * @return a valid letter in string format that is new and not already entered
     */
    protected String validNewLetter(String alreadyEntered){
        Scanner scnr = new Scanner(System.in);
        String userInputS = scnr.nextLine().toLowerCase();

        // create a boolean to check for all possible errors
        while((!inputIsLetter(userInputS)) || inputAlreadyEntered(userInputS, alreadyEntered)) {
            System.out.println("Invalid letter or already entered; try again.");
            userInputS = scnr.nextLine().toLowerCase();
        }

        return userInputS.toLowerCase();
    }


}
