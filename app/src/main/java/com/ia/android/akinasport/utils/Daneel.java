package com.ia.android.akinasport.utils;

/**
 * Created by Arnaud on 14/04/2016.
 */
public class Daneel
{
    //ID QUESTIONS
    private int YES = 1;
    private int PROBABLY_YES = 2;
    private int DONT_KNOW = 3;
    private int PROBABLY_NO = 4;
    private int NO = 5;

    private int[][] scoreMatrice;

    public Daneel()
    {
        
    }

    public int[][] getScoreMatrice() {return scoreMatrice;}
    public void setScoreMatrice(int[][] scoreMatrice) {this.scoreMatrice = scoreMatrice;}
}
