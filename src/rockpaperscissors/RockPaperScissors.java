
package rockpaperscissors;

import java.util.*;

public class RockPaperScissors {

    
    public static void main(String[] args) {
        boolean playagain = true;
        System.out.println("Welcome to rock paper scissors!");
        System.out.println("if a game is tied the next round is worth 2 points");
        int playerScore = 0;
        int compScore = 0;
        int tied = 0;
        while(playagain == true){
            //gets both user choice and vomputer choice
            String comp = computerChoice();
            System.out.println("Please enter rock paper or scissors");
            //converts to lowercase for easier comparison
            String user = getInput().toLowerCase();
            //validation check of user input
            while(inputValid(user,1) == false){
                System.out.println("Please enter rock paper or scissors");
                user = getInput().toLowerCase();
            }
            System.out.println(comp);
            //selects which output is appropriate
            if(user.equals(comp)){
                System.out.println("TIE");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                tied++;
            }
            else if((user.equals("rock"))&&(comp.equals("scissors"))){
                System.out.println("User wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                playerScore = frenzyRule(tied);
            }
            else if((user.equals("rock"))&&(comp.equals("paper"))){
                System.out.println("Computer wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                compScore= frenzyRule(tied);
            }
            else if((user.equals("scissors"))&&(comp.equals("paper"))){
                System.out.println("User wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                playerScore= frenzyRule(tied);
            }
            else if((user.equals("scissors"))&&(comp.equals("rock"))){
                System.out.println("Computer wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                compScore= frenzyRule(tied);
            }
            else if((user.equals("paper"))&&(comp.equals("rock"))){
                System.out.println("User wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                playerScore= frenzyRule(tied);
            }
            else/*else if((user.equals("paper"))&&(comp.equals("scissors")))*/{
                System.out.println("Computer wins");
                System.out.println("Would you like too play again?(y/n)");
                String UI = getInput();
                while(inputValid(UI,2) == false){
                    System.out.println("Please type either(y/n)");
                    UI = getInput();
                }
                playagain = Play(UI);
                compScore= frenzyRule(tied);
            }
            System.out.println("Computer: "+compScore+" Player: "+playerScore);
        }
        System.out.println("FINAL RESULTS:");
        System.out.println("Computer: "+compScore+" Player: "+playerScore);
    }
    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public static String computerChoice(){
        Random rand = new Random();
        int choice = rand.nextInt(2-0+1)-0;
        String[] rpsChoice = {"rock","paper","scissors"};
        return rpsChoice[choice];
    }
    public static Boolean Play(String input){
        boolean playagain = true;
        if(input.equals("y")){
            playagain = true;

        }
        else if(input.equals("n")) {
            playagain = false;
        }
        return playagain;
    }
    public static boolean inputValid(String input/*user input*/,int a/*which validity check to choose*/){
        boolean valid = true;
        switch(a){
            case 1:
                if(input.equals("rock")){
                    valid = true;
                }
                else if(input.equals("scissors")){
                    valid = true;
                }
                else if(input.equals("paper")){
                    valid = true;
                }
                else{
                    valid= false;
                }
                break;
            case 2:
                if(input.equals("y")){
                    valid = true;

                }
                else if(input.equals("n")) {
                    valid = true;
                }
                else{
                    valid = false;
                }
                break;
        }
        return valid;    
    }
    public static int frenzyRule(int gamestied){
        int score = 0;
        int num = 0;
        if(gamestied <1){
            num = 1;
        }
        switch(num){
            case 1:
                score= gamestied*2;
            default:
                score = 1;
        }
        return score;
    }
}
