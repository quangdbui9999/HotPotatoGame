/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, October 25th, 2018
 *  Description: Player will save the name, numPotatoes, and status (it is
 *  defined by the enumeration type) of each Player. It allow the
 *  programmers enter the name, check name, add the Players, and
 *  output information of Player
 */
package HotPotatoes;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, October 25th, 2018
 * Description: Player will save the name, numPotatoes, and status (it is
 * defined by the enumeration type) of each Player. It allow the
 * programmers enter the name, check name, add the Players, and
 * output information of Player
 */

public class Player {
    private String name;
    private int numPotatoes;
    private Winner whoWin;

    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: none
     * Post-condition: initialize the name, numPotatoes, and set the
     * status for whoWin variable
     */
    public Player(){
        this.name = "";
        this.numPotatoes = 2;
        if(this.numPotatoes == 2 || this.numPotatoes == 1){
            this.whoWin = Winner.none;
        }else if(this.numPotatoes == 0){
            this.whoWin = Winner.wasORed;
        }
    }

    /**
     * C O N V E R S I O N   C O N S T R U C T O R
     * @param whoPlay the name of Player will be assign to name 
     * instance variable
     * Pre-condition: none
     * Post-condition: initialize the name following the whoPlay param, 
     * and numPotatoes, and set the status for whoWin variable
     */
    public Player(String whoPlay){
        if(checkNamePlayer(whoPlay) == true){
            this.name = standardize(whoPlay);
        }
        this.numPotatoes = 2;
        if(this.numPotatoes == 2 || this.numPotatoes == 1){
            this.whoWin = Winner.none;
        }else if(this.numPotatoes == 0){
            this.whoWin = Winner.wasORed;
        }
    }
    
    /**
     * Mutator: standardize(String str)
     * @param str a String is pass as a parameter, and it will
     * be standardized
     * @return a String is standardized String (there are no space at
     * the front and at the rear of String, and there are no redundant
     * space between two word)
     * Pre-condition: none
     * Post-condition: return a String is standardized String 
     * (there are no space at the front and at the rear of String, 
     * and there are no redundant space between two word)
     */
    public String standardize(String str){
        String regex = "[a-zA-Z ,]+";
        String result = "";
        if(str.matches(regex) == false){
            return "";
        }else{
            str = str.toLowerCase(); // convert to lower case in string str
            String[] splitWord;
            
            splitWord = str.split(" ");
            for(int i = 0; i < splitWord.length; i++){
                String s1 = "";
                if(!splitWord[i].equals("") && !splitWord[i].equals(null)){
                    if(splitWord[i].length() < 1){
                        return result;
                    }else{
                        if(splitWord[i].length() != 0){
                            // proper format
                            // charAt(0) first character
                            s1 += Character.toUpperCase(
                                    splitWord[i].charAt(0));
                            if(splitWord[i].length() > 1){
                                s1 += splitWord[i].substring(1);
                            }
                            result += s1;
                            if(i < splitWord.length){
                                // print space character after each word
                                result += " "; 
                            }
                        }
                    }
                }
            }
            // cut the space character on both end of result variable
            result = result.trim();
            return result;
        }
    }
    
    /**
     * Accessor: checkNamePlayer(String namePlayer)
     * @param namePlayer
     * @return a valid name (the length of name must be in the
     * range from 5 - 40, it just include the lower case and
     * upper case letter)
     * Pre-condition: none
     * Post-condition: return a valid name (the length of name must be 
     * in the range from 5 - 40, it just include the lower case and
     * upper case letter)
     */
    public boolean checkNamePlayer(String namePlayer){
        boolean isValidNameStudent = false;
        
        /**
         * accept the characters in the range [a-z] and [A-Z] and
         * the name must be in the range [5 - 20] characters of length
         */
        String regex = "[a-z A-Z]{5,40}";
        
        if(namePlayer.matches(regex)){
            isValidNameStudent = true;
        }else{
            isValidNameStudent = false;
        }
        return isValidNameStudent;
    }
    
    /**
     * Mutator: addPlayers()
     * Pre-condition: checkNamePlayer(this.name) and
     * setName(this.name); and standardize(String) are defined
     * Post-condition: add one Player into the Queue with valid name
     */
    public void addPlayers(){
        Scanner cin = new Scanner(System.in);
        
        do{
            System.out.print("Enter the Player's Name: ");
            this.name = cin.nextLine();
            if(checkNamePlayer(this.name) == false){
                System.out.println("Invalid Name.");
            }
        }while(!checkNamePlayer(this.name));
        
        this.setName(standardize(this.name));
    }

    /**
     * Accessor: getNumPotatoes()
     * @return the numPotatoes of a Player
     * Pre-condition: none
     * Post-condition: return the numPotatoes of a Player
     */
    public int getNumPotatoes() {
        return numPotatoes;
    }

    /**
     * Mutator: setNumPotatoes(int numberPotatoes)
     * @param numberPotatoes assign a number of potato from 
     * numberPotatoes to numPotatoes instance variable
     * Pre-condition: nothing
     * Post-condition: assign a number of potato from numberPotatoes to 
     * numPotatoes instance variable and set whoWin is none if 
     * numPotatoes == 2 or 1, if numPotatoes = 0, set whoWin is
     * WINNER
     */
    public void setNumPotatoes(int numberPotatoes) {
        if(numberPotatoes >= 0){
            this.numPotatoes = numberPotatoes;
        }
        if(this.numPotatoes == 2 || this.numPotatoes == 1){
            this.whoWin = Winner.none;
        }else if(this.numPotatoes == 0){
            this.whoWin = Winner.wasORed;
        }
    }
    
    /**
     * Mutator: setName(String inName)
     * @param inName if inName is valid name, assign inName to 
     * Player's name
     * Pre-condition: checkNamePlayer(String) must be defined
     * Post-condition: assign a new name from inName to name 
     * instance variable
     */
    public void setName(String inName) {
        if(checkNamePlayer(inName) == true){
            this.name = standardize(inName);
        }
    }

    /**
     * Accessor: getName()
     * @return the name of a Player
     * Pre-condition: none
     * Post-condition: return the name of a Player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Mutator: displayPlayerInformation()
     * Pre-condition: none
     * Post-condition: output the Player's information
     */
    public void displayPlayerInformation(){
        try{
            String statusWasORed = "";
            
            if(this.whoWin == Winner.wasORed){
                statusWasORed += "ORed.";
            }else if(this.whoWin == Winner.none){
                statusWasORed += "Playing.";
            }else if(this.whoWin == Winner.win){
                statusWasORed += "WINNER.";
            }
            
            System.out.printf(" %-45s | %-15d | %-15s |",
                this.name, this.numPotatoes, statusWasORed);
        }catch(Exception ex){
            System.err.println("Error Message: " + ex.getMessage());
        }
    }
    
    /**
     * Accessor: getWhoWin()
     * @return the status of a Player
     * Pre-condition: none
     * Post-condition: return the status of a Player
     */
    public Winner getWhoWin() {
        return whoWin;
    }
    
    /**
     * Mutator: setWhoWin(Winner whoWin)
     * @param whoWin assign whoWin param to whoWin instance variable
     * Pre-condition: none
     * Post-condition: assign whoWin param to whoWin instance variable
     */
    public void setWhoWin(Winner whoWin) {
        this.whoWin = whoWin;
    }
}
