package com.company;

import java.util.ArrayList;

public class ShipsGame
{
    private Support supporter = new Support();
    private ArrayList<Ship> listOfShips = new ArrayList<Ship>();
    private int numberOfMoves = 0;

    public void prepareGame()
    {
       Ship first = new Ship();
       first.setName("");
       Ship second = new Ship();
       second.setName("");
       Ship third = new Ship();
       third.setName("");

       listOfShips.add(first);
       listOfShips.add(second);
       listOfShips.add(third);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("    Hi!  This is game where u must kill all ships in a field.    ");
        System.out.println("Field is a matrix 7 x 7 and all three ships are three grids long.");
        System.out.println("  Try guess grid (bounds: a-f, 0-6; example: 'a1') -  Good Luck! ");
        System.out.println("-----------------------------------------------------------------");

        for(Ship arrangedShip : listOfShips)
        {
            ArrayList<String> newLocation = supporter.arrangeShip(3);
            arrangedShip.setLocationField(newLocation);
        }
    }

    public void startGame()
    {
        while(!listOfShips.isEmpty())
        {
            String playerMove = supporter.getInputData("Gimme location:");
            checkPlayerMove(playerMove);
        }
        endGame();
    }

    private void checkPlayerMove(String move)
    {
        numberOfMoves++;
        String score = "miss";

        for(Ship shipToCheck : listOfShips)
        {
            score = shipToCheck.check(move);
            if(score.equals("hit"))
            {
                break;
            }
            if(score.equals("kill"))
            {
                listOfShips.remove(shipToCheck);
                break;
            }
        }
        System.out.println(score);
    }

    private void endGame()
    {
        System.out.println("All ships are killed! \nNumber of moves:" + numberOfMoves);
    }
}
