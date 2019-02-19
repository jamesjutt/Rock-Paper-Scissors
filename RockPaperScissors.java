/**
 * RockPaperScissors.java
 * James Jutt
 * 1/31/19
 * Rock Paper Scissors Game that will determine the winner after 10 games, taking ties into account
 */
import javax.swing.JOptionPane;
public class RockPaperScissors 
{
    public static void main(String[] args) 
    {
        // Varibles and Constants
        int com;
        String userPick = "";
        String comPick = "";
        String message = "";
        int userScore = 0;
        int comScore = 0;
        int tieGames = 0;
        int gameCount = 1;
        final int NUM_GAMES = 10;

        // While loop controls the overall game structure
        while(gameCount <= NUM_GAMES)
        {
            // Computer randomly chooses a number between 1 and 3
            com = 1 + (int)(Math.random() * 3);
            
            // Reset the strings each time a new round is played
            userPick = "";
            message = "";

            // Validate the player data, allowing for some misspellings, loop the dialog prompt if the user does not give a valid selection
            while (!userPick.equalsIgnoreCase("Rock") && !userPick.equalsIgnoreCase("Paper") && !userPick.equalsIgnoreCase("Scissors")) 
            {
                userPick = JOptionPane.showInputDialog(null, "Please type one of the following: \nRock\nPaper\nScissors");

                userPick = userPick.toLowerCase();
                
                // Check if the first two characters are correct, assign the proper selection from there
                if (userPick.startsWith("ro"))
                {
                    userPick = "ROCK";
                }
                else
                {
                    if (userPick.startsWith("pa")) 
                    {
                        userPick = "PAPER";   
                    }
                    else
                    {
                        if (userPick.startsWith("sc")) 
                        {
                            userPick = "SCISSORS";    
                        }
                        else
                        {
                            message = "Invalid selection";
                        }
                    }
                }
            }

            // Decision process for the computer which assigns a string with the item name to the numeric choices
            
            // Computer's String
            if (com == 1) 
            {
                comPick = "ROCK";
            }
            else
            {
                if (com == 2) 
                {
                    comPick = "PAPER";
                }
                else
                {
                    comPick = "SCISSORS";
                }
            }

            // Game Mechanics
            // If userPick == comPick
            if (userPick.equals(comPick))
            {
                tieGames += 1;
                message = "Game: " + gameCount + "\nYou tie!!! \nYou both picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
            }
            else
            {
                // userPick Rock beats comPick Scissors
                if (userPick.equals("ROCK") && comPick.equals("SCISSORS"))
                {
                    userScore += 1;
                    message = "Game: " + gameCount + "\nYou win!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
                }
                else
                {
                    // userPick Paper beats comPick Rock
                    if (userPick.equals("PAPER") && comPick.equals("ROCK")) 
                    {
                        userScore += 1;
                        message = "Game: " + gameCount + "\nYou win!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
                    }
                    else
                    {
                        // userPick Scissors beats comPick Paper
                        if (userPick.equals("SCISSORS") && comPick.equals("PAPER")) {
                            userScore += 1;
                            message = "Game: " + gameCount + "\nYou win!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
                        }
                    }
                }
            }
            // comPick Rock beats userPick Scissors
            if (comPick.equals("ROCK") && userPick.equals("SCISSORS"))
            {
                comScore += 1;
                message = "Game: " + gameCount + "\nYou lose!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
            }
            else
            {
                // comPick Paper beats userPick Rock
                if (comPick.equals("PAPER") && userPick.equals("ROCK")) 
                {
                    comScore += 1;
                    message = "Game: " + gameCount + "\nYou lose!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
                }
                else
                {
                    // comPick Scissors beats userPick Paper
                    if (comPick.equals("SCISSORS") && userPick.equals("PAPER")) 
                    {
                        comScore += 1;
                        message = "Game: " + gameCount + "\nYou lose!!! \nYou picked " + userPick + "\nComputer picked " + comPick + "\nYour score: " + userScore + "\nComputers score: " + comScore + "\nWith " + tieGames + " tie games";
                    }
                }
            }
            JOptionPane.showMessageDialog(null, message);
            gameCount++;
        }
        // Determine the winner after the 10 Games
        // User wins
        if (userScore > comScore)
        {
            JOptionPane.showMessageDialog(null, "You win! \nThe final score is \nUser: " + userScore + "\nComputer: " + comScore + "\nTies: " + tieGames);
        }
        else
        {
            // Computer wins
            if (userScore < comScore) 
            {
                JOptionPane.showMessageDialog(null, "You lose! \nThe final score is \nUser: " + userScore + "\nComputer: " + comScore + "\nTies: " + tieGames);            
            }
            // Tie
            else
            {
                JOptionPane.showMessageDialog(null, "You tied! \nThe final score is \nUser: " + userScore + "\nComputer: " + comScore + "\nTies: " + tieGames);
            }
        }
    }
    
}
