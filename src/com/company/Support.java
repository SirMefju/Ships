package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Support
{
    private static final String alphabet = "abcdefg";
    private int boardLength = 7;
    private int boardSize = 49;
    private int[] board = new int [boardSize];
    private int numberOfShips = 0;

    public String getInputData(String info)
    {
        String welcomeData = null;
        System.out.println(info + " ");
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            welcomeData = is.readLine();
            if (welcomeData.length() == 0) return null;
        } catch (IOException e)
        {
            System.out.println("IoException: " + e);
        }
        return welcomeData.toLowerCase();
    }

    public ArrayList arrangeShip (int shipSize)
    {
        ArrayList<String> occupiedFields = new ArrayList<String>();
        String[] alphacoords = new String[shipSize];
        String help = null;
        int[] coordinates = new int[shipSize];
        int tried = 0;
        boolean success = false;
        int position = 0;
        numberOfShips++;
        int inkr = 1; //horizontal gain
        if((numberOfShips % 2) == 1)
        {
            inkr = boardLength; //vertical gain
        }
        while (!success & tried++ < 200)
        {
            position = (int) (Math.random()* boardSize);
            int x = 0;
            success = true;
            while(success && x < shipSize)
            {
                if(board[position] == 0)
                {
                    coordinates[x++] = position;
                    position += inkr;
                    if(position >= boardSize)
                    {
                        success = false;
                    }
                    if(x > 0 & (position % boardLength == 0))
                    {
                        success = false;
                    }
                }
                else
                {
                    success = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int column = 0;
        while(x < shipSize)
        {
            board[coordinates[x]] = 1;
            row = (int) (coordinates[x] / boardLength);
            column = coordinates[x] % boardLength;
            help = String.valueOf(alphabet.charAt(column));
            occupiedFields.add(help.concat(Integer.toString(row)));
            x++;
//            System.out.println("Co-ordinates ("+x+") of ship: " + occupiedFields.get(x-1)); // showing all ships in a field
        }
        return occupiedFields;
    }
}