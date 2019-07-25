/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, October 25th, 2018
 *  Description: The HotPotato class will run the application 
 * of Hot Potato Game. It will add Players, then display 
 * all the information of all Players, random to choose who will 
 * play first, decrease the number of Potatoes, eliminated the person 
 * who no more potatoes and then output the people who will 
 * in the Round-Robin Elimination. And then output the 
 * information of only Player exist in Round-Robin Elimination
 */

package HotPotatoes;

import java.util.Random;
import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, October 25th, 2018
 * Description: The HotPotato class will run the application 
 * of Hot Potato Game. It will add Players, then display 
 * all the information of all Players, random to choose who will 
 * play first, decrease the number of Potatoes, eliminated the person 
 * who no more potatoes and then output the people who will 
 * in the Round-Robin Elimination. And then output the 
 * information of only Player exist in Round-Robin Elimination
 */
public class HotPotato {
    private DLLCircularQueue<Player> circleHotPotatoe;
    private int countPotatoes;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: none
     * Post-condition: initialize the circleHotPotatoe, and
     * countPotatoes for HotPotato class
     */
    public HotPotato(){
        circleHotPotatoe = new DLLCircularQueue<Player>();
        countPotatoes = 0;
    }
    
    /**
     * Mutator: run()
     * Pre-condition: addManyPlayers(), outputInformation(), 
     * getTotalPotatoes(), size(), whoPlayFirst(), 
     * displayRanDomPlayer(positionFisrt), whoWasOred(positionFisrt),
     * listInRoundRobin(), displayWinner(), and sleep(int) 
     * method are defined
     * Post-condition: run the application of Hot Potato Game
     * It will add Players, then display all the information of all
     * Players, random to choose who will play first, decrease the
     * number of Potatoes, eliminated the person who no more potatoe
     * and then output the people who will in the Round-Robin 
     * Elimination. And then output the information of only Player
     * exist in Round-Robin Elimination if the number of Players greater
     * than or equal 3.
     * If the number of Players less than 3, the game is finished
     */
    public void run(){
        instructions();
        addManyPlayers();
        circleHotPotatoe.outputInformation();
        int decreamentPotatoe = circleHotPotatoe.getTotalPotatoes();
        
        if(circleHotPotatoe.size() >= 3){
            System.out.println("The player will start the game "
                    + "Hot Potatoe: ");
            int positionFisrt = whoPlayFirst();
            circleHotPotatoe.displayRanDomPlayer(positionFisrt);
            
            do{
                if(decreamentPotatoe != circleHotPotatoe.getTotalPotatoes() 
                        && decreamentPotatoe % 2 == 0){
                    System.out.println(decreamentPotatoe + " potatoes.");
                    whoWasOred(positionFisrt);
                    listInRoundRobin();
                }
                countPotatoes++;
                if(countPotatoes <= decreamentPotatoe){
                    System.out.println(countPotatoes + " potato.");
                }
                
                if(countPotatoes >= decreamentPotatoe){
                    countPotatoes = 0;
                    if(this.isDecreamentPotatoes()){
                        decreamentPotatoe--;
                    }
                }
                
                sleep(500);
            }while(circleHotPotatoe.size() != 1);
            displayWinner();
        }else{
            System.out.println("There is no enought the number of "
                    + "Player to run the Hot Potato Game.");
        }
    }
    
    /**
     * Accessor: isDecreamentPotatoes()
     * @return true if the number potato is 0 (the Player) will
     * eliminated from the Round-Robin Elimination, otherwise return
     * false
     * Pre-condition: nothing
     * Post-condition: true if the number potato is 0 (the Player) will
     * eliminated from the Round-Robin Elimination, otherwise return
     * false
     */
    private boolean isDecreamentPotatoes(){
        Random rand = new Random();
        boolean isDecreament = false;
        
        // 1: no decreament
        // 2: decrease the potaotes
        int decision = 1 + rand.nextInt(2);
        if(decision == 1){
            isDecreament = false;
        }else if(decision == 2){
            isDecreament = true;
        }
        return isDecreament;
    }
    
    /**
     * Mutator: sleep(int time)
     * @param time the time will calculated by milliseconds
     * Pre-condition: nothing
     * Post-condition: pause the time
     */
    public void sleep(int time){
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    /**
     * Mutator: whoWasOred(int position)
     * @param position the position who will start playing the game
     * Pre-condition: outputPlayerWasORed(positionOut, 1) is defined
     * Post-condition: the position will be random and eliminated
     * that person in the appropriate position if they have no potato
     */
    public void whoWasOred(int position){
        int positionOut = 0;
        Random rand = new Random();
        
        do{
            positionOut = position + rand.nextInt(circleHotPotatoe.size());
            if(position > circleHotPotatoe.size()){
                position = 1;
            }
        }while(!(1 <= positionOut && positionOut 
                <= circleHotPotatoe.size()));
        
        System.out.println("The person will be eliminated in Round-Robin");
        circleHotPotatoe.printTile();
        circleHotPotatoe.outputPlayerWasORed(positionOut, 1);
        circleHotPotatoe.printFormat();
        System.out.println("");
    }
    
    /**
     * Mutator: listInRoundRobin
     * Pre-condition: nothing
     * Post-condition: display the Players' information in the Round
     * Robin Elimination after a person is eliminated. The last
     * person in the queue will be Winner person.
     */
    public void listInRoundRobin(){
        System.out.println("\nList Players in Hot Potato's RoundRobin");
        System.out.print("Currently, there "
                + "are " + circleHotPotatoe.size() + " in the "
                        + "Round-Robin Elimination.");
        circleHotPotatoe.outputInformation();
    }
    
    /**
     * Mutator: displayWinner()
     * Pre-condition: nothing
     * Post-condition: display the Players' information who is
     * Winner person.
     */
    public void displayWinner(){
        if(circleHotPotatoe.size() == 1){
            circleHotPotatoe.first().setWhoWin(Winner.win);
            circleHotPotatoe.printTile();
            System.out.printf("\n| %-10d |", 1); 
            circleHotPotatoe.first().displayPlayerInformation();
            circleHotPotatoe.printFormat();
            System.out.println("\nCONGRATULATION. "
                    + "\"" + circleHotPotatoe.first().getName() 
                    + "\" WINNER.");
            System.exit(0);
        }
    }
    
    /**
     * Mutator: instructions()
     * Pre-condition: nothing
     * Post-condition: display the instructions of the Game
     */
    public void instructions(){
        System.out.println("Programmed by: Quang Bui.\n" 
                + "Project 3: Hot Potato Game.\n" 
                + "Due date: Thursday, October 25th, 2018.\n" 
                + "Welcome to Hot Potato Game Application is written "
                + "by \nJava Programming Language. The Hot Potato Game "
                + "is written based \non the idea of Double-Linked List "
                + "Circular Queue in the \nData Structure and Algorithm "
                + "course. \nI feel happy and would like to say thank "
                + "you when you and \nyour friends can take yours time "
                + "to joint in my Application.\n" 
                + "My Application will run step by step. You should "
                + "have at "
                + "least 3 people \nto take part in the Hot Potato Game.\n" 
                + "1) You enter your name and your friends' name. \nEach "
                + "time you enter the names, your name and your friends' "
                + "name \nwill enqueue (add name on the rear of "
                + "the queue).\n" 
                + "2) After that, my Application will random to "
                + "choose \nwho will start the game.\n" 
                + "3) When the game is started. My Application will run "
                + "the count \nPotatoes from 1 to the total Potatoe of "
                + "all Players in the Queue.\n In the process of the "
                + "game, the total of number Potato \nare decrease "
                + "randomly one by one. If 2 potato is decrease, \n"
                + "there is one person will be eliminated from the "
                + "Round-Robin Elimination.\n" 
                + "4) Then the round-robin elimination will continue until"
                + "\nthere is only one Player in the round-robin. "
                + "\nAnd that Player will determined Winner Player. ");
    }
    
    /**
     * Accessor: whoPlayFirst()
     * @return the position who will be started playing the game
     * Pre-condition: nothing
     * Post-condition: return the position who will be started playing 
     * the game
     */
    public int whoPlayFirst(){
        Random rand = new Random();
        int position = 1 + rand.nextInt((circleHotPotatoe.size()));
        return position;
    }
    
    /**
     * Mutator: addManyPlayers()
     * Pre-condition: addPlayers() and enqueue() method are defined
     * Post-condition: enter the number of Player and add the 
     * Player's name respectively with the number is entered
     */
    public void addManyPlayers(){
        Scanner cin = new Scanner(System.in);
        
        boolean isValidInteger = false;
        int numPlayers = 0;
        
        while (isValidInteger == false) {
            try {
                do {
                    System.out.print("Enter the number of Players: ");
                    numPlayers = Integer.parseInt(cin.nextLine());
                    if (!(1 <= numPlayers 
                            && numPlayers <= Integer.MAX_VALUE)) {
                        System.err.println("The number of Players that "
                                + "you enter must be in the range "
                                + "[1 - " + Integer.MAX_VALUE + "].");
                    }
                } while (!(1 <= numPlayers 
                        && numPlayers <= Integer.MAX_VALUE));
                isValidInteger = true;
            } catch (NumberFormatException e) {
                System.err.println("Input is not a valid integer "
                        + "data type.");
                System.err.println("The exception message is:"
                        + " " + e.getMessage());
            }
        }
        isValidInteger = true;
        
        if(isValidInteger){
            for(int i = 1; i <= numPlayers; i++){
                System.out.println("Enter the Player: " + i + ".");
                Player who = new Player();
                who.addPlayers();
                circleHotPotatoe.enqueue(who);
            }
        }
    }
}