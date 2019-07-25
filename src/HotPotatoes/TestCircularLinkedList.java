
/**
 * CSC-223 Weeks #4/5 Lab #2
 * DUE DATE: Thursday, October 25th, 2018
 * DATE SUBMITTED: Thursday, October 25th, 2018
 * PROGRAMMED BY: Quang Bui
 * DESCRIPTION: Create the new HotPotato object and test the 
 * Hot Potato Application.
 */
 

package HotPotatoes;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Quang Bui
 */
public class TestCircularLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HotPotato gamePlay = new HotPotato();
        gamePlay.run();
        System.out.println("THE GAME IS FINISHED.");
    }
}

/*
run:
Enter the number of Players: -1
The number of Players that you enter must 
be in the range [1 - 2147483647].
Enter the number of Players: 2
Enter the Player: 1.
Enter the Player's Name: quang bui
Enter the Player: 2.
Enter the Player's Name: manh quan

+------------+-------------+-----------------+-----------------+
| Order      | Name        | Number Potatoes | Status          |
+------------+-------------+-----------------+-----------------+
| 1          | Quang Bui   | 2               | Playing.        |
+------------+-------------+-----------------+-----------------+
| 2          | Manh Quan   | 2               | Playing.        |
+------------+-------------+-----------------+-----------------+
There is no enought the number of Player to run the Hot Potato Game.
THE GAME IS FINISHED.
*/

/*
run:
Enter the number of Players: 5
Enter the Player: 1.
Enter the Player's Name: manh quan
Enter the Player: 2.
Enter the Player's Name: duy   quang
Enter the Player: 3.
Enter the Player's Name:   minh nguyen
Enter the Player: 4.
Enter the Player's Name: thuong  nguyen
Enter the Player: 5.
Enter the Player's Name: phuong uyen

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Manh Quan     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 2          | Duy Quang     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 3          | Minh Nguyen   | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 4          | Thuong Nguyen | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 5          | Phuong Uyen   | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
The player will start the game Hot Potatoe: 

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Minh Nguyen   | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
1 potato.
2 potato.
3 potato.
....
7 potato.
8 potato.
9 potato.
8 potatoes.
The person will be eliminated in Round-Robin

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Minh Nguyen   | 0               | ORed.           |
+------------+---------------+-----------------+-----------------+


List Players in Hot Potato's RoundRobin
Currently, there are 4 in the Round-Robin Elimination.
+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Manh Quan     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 2          | Duy Quang     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 3          | Thuong Nguyen | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 4          | Phuong Uyen   | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
1 potato.
2 potato.
3 potato.
...
5 potato.
6 potato.
7 potato.
6 potatoes.
The person will be eliminated in Round-Robin

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Thuong Nguyen | 0               | ORed.           |
+------------+---------------+-----------------+-----------------+

List Players in Hot Potato's RoundRobin
Currently, there are 3 in the Round-Robin Elimination.
+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Manh Quan     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 2          | Duy Quang     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 3          | Phuong Uyen   | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
1 potato.
2 potato.
...
3 potato.
4 potato.
5 potato.
4 potatoes.
The person will be eliminated in Round-Robin

+------------+--------------+-----------------+-----------------+
| Order      | Name         | Number Potatoes | Status          |
+------------+--------------+-----------------+-----------------+
| 1          | Phuong Uyen  | 0               | ORed.           |
+------------+--------------+-----------------+-----------------+

List Players in Hot Potato's RoundRobin
Currently, there are 2 in the Round-Robin Elimination.
+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Manh Quan     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
| 2          | Duy Quang     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+

1 potato.
2 potato.
3 potato.
4 potato.
1 potato.
2 potato.
3 potato.
2 potatoes.
The person will be eliminated in Round-Robin

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Manh Quan     | 0               | ORed.           |
+------------+---------------+-----------------+-----------------+

List Players in Hot Potato's RoundRobin
Currently, there are 1 in the Round-Robin Elimination.
+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Duy Quang     | 2               | Playing.        |
+------------+---------------+-----------------+-----------------+
1 potato.

+------------+---------------+-----------------+-----------------+
| Order      | Name          | Number Potatoes | Status          |
+------------+---------------+-----------------+-----------------+
| 1          | Duy Quang     | 2               | WINNER.         |
+------------+---------------+-----------------+-----------------+
CONGRATULATION. "Duy Quang" WINNER.
BUILD SUCCESSFUL (total time: 1 minute 51 seconds)

*/