package edu.louisville.tictactoe;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int BLANK = 0;
    public static final int X = 1;
    public static final int O = 2;
    public static final String XWIN = "X WINS!!!";
    public static final String OWIN = "O WINS!!!";
    public static final String TIE = "IT'S A TIE.";
    public static final String XTURN = "Turn: X";
    public static final String OTURN = "Turn: O";
    public static final String BOARD = "BOARD_STATE";
    public static final String TURN = "TURN";
    boolean xTurn = true;

    public int[] gameArray = new int [9];

    ImageButton[] ibArray = new ImageButton[9];

    TextView text;

    private static void evaluateWinner (int[] gameArray, TextView text,ImageButton[] imageArray){
        if(((gameArray[0] == X) && (gameArray[1] == X) && (gameArray[2] == X))
                || ((gameArray[3] == X) && (gameArray[4] == X) && (gameArray[5] == X))
                || ((gameArray[6] == X) && (gameArray[7] == X) && (gameArray[8] == X))
                || ((gameArray[0] == X) && (gameArray[3] == X) && (gameArray[6] == X))
                || ((gameArray[1] == X) && (gameArray[4] == X) && (gameArray[7] == X))
                || ((gameArray[2] == X) && (gameArray[5] == X) && (gameArray[8] == X))
                || ((gameArray[0] == X) && (gameArray[4] == X) && (gameArray[8] == X))
                ||  (((gameArray[2] == X) && (gameArray[4] == X) && (gameArray[6] == X))))
        {
            text.setText(XWIN);
            for (ImageButton image:imageArray) {
                image.setClickable(false);
            }
        }
        else if(((gameArray[0] == O) && (gameArray[1] == O) && (gameArray[2] == O))
                || ((gameArray[3] == O) && (gameArray[4] == O) && (gameArray[5] == O))
                || ((gameArray[6] == O) && (gameArray[7] == O) && (gameArray[8] == O))
                || ((gameArray[0] == O) && (gameArray[3] == O) && (gameArray[6] == O))
                || ((gameArray[1] == O) && (gameArray[4] == O) && (gameArray[7] == O))
                || ((gameArray[2] == O) && (gameArray[5] == O) && (gameArray[8] == O))
                || ((gameArray[0] == O) && (gameArray[4] == O) && (gameArray[8] == O))
                ||  (((gameArray[2] == O) && (gameArray[4] == O) && (gameArray[6] == O)))){
            text.setText(OWIN);
            for (ImageButton image:imageArray) {
                image.setClickable(false);
            }
        }
        else if((gameArray[0] != BLANK)&&(gameArray[1] != BLANK)
                && (gameArray[2] != BLANK) && (gameArray[3] != BLANK)
                && (gameArray[4] != BLANK) && (gameArray[5] != BLANK)
                && (gameArray[6] != BLANK) && (gameArray[7] != BLANK)
                && (gameArray[8] != BLANK)){
            text.setText(TIE);

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ibArray[0] = (ImageButton) findViewById(R.id.imageButton1);
        ibArray[1] = (ImageButton) findViewById(R.id.imageButton2);
        ibArray[2] = (ImageButton) findViewById(R.id.imageButton3);
        ibArray[3] = (ImageButton) findViewById(R.id.imageButton4);
        ibArray[4] = (ImageButton) findViewById(R.id.imageButton5);
        ibArray[5] = (ImageButton) findViewById(R.id.imageButton6);
        ibArray[6] = (ImageButton) findViewById(R.id.imageButton7);
        ibArray[7] = (ImageButton) findViewById(R.id.imageButton8);
        ibArray[8] = (ImageButton) findViewById(R.id.imageButton9);

        gameArray[0] = BLANK;
        gameArray[1] = BLANK;
        gameArray[2] = BLANK;
        gameArray[3] = BLANK;
        gameArray[4] = BLANK;
        gameArray[5] = BLANK;
        gameArray[6] = BLANK;
        gameArray[7] = BLANK;
        gameArray[8] = BLANK;


        text = (TextView) findViewById(R.id.textView2);
        text.setText(XTURN);}





    @Override
    public void onClick(View view) {
        ImageButton button = (ImageButton) view;

        if(xTurn) {
            button.setImageResource(R.drawable.tictactoex);
            text.setText(OTURN);
            if (view.getId() == R.id.imageButton1) {
                gameArray[0] = X;
            } else if (view.getId() == R.id.imageButton2) {
                gameArray[1] = X;
            } else if (view.getId() == R.id.imageButton3) {
                gameArray[2] = X;
            } else if (view.getId() == R.id.imageButton4) {
                gameArray[3] = X;
            } else if (view.getId() == R.id.imageButton5) {
                gameArray[4] = X;
            } else if (view.getId() == R.id.imageButton6) {
                gameArray[5] = X;
            } else if (view.getId() == R.id.imageButton7) {
                gameArray[6] = X;
            } else if (view.getId() == R.id.imageButton8) {
                gameArray[7] = X;
            } else {
                gameArray[8] = X;
            }
        }
        else{
            button.setImageResource(R.drawable.tictactoeo);
            text.setText(XTURN);
            if (view.getId() == R.id.imageButton1) {
                gameArray[0] = O;
            } else if (view.getId() == R.id.imageButton2) {
                gameArray[1] = O;
            } else if (view.getId() == R.id.imageButton3) {
                gameArray[2] = O;
            } else if (view.getId() == R.id.imageButton4) {
                gameArray[3] = O;
            } else if (view.getId() == R.id.imageButton5) {
                gameArray[4] = O;
            } else if (view.getId() == R.id.imageButton6) {
                gameArray[5] = O;
            } else if (view.getId() == R.id.imageButton7) {
                gameArray[6] = O;
            } else if (view.getId() == R.id.imageButton8) {
                gameArray[7] = O;
            } else {
                gameArray[8] = O;
            }
        }
        xTurn = !xTurn;
        button.setClickable(false);
        evaluateWinner(gameArray,text,ibArray);

    }

    public void newGameClick(View view) {
        xTurn = true;
        text.setText(XTURN);
        for (ImageButton ib:ibArray) {
            ib.setImageResource(0);
            ib.setClickable(true);
        }
        for (int i=0; i<gameArray.length;i++){
            gameArray[i] = BLANK;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putBoolean(TURN,xTurn);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


            xTurn = savedInstanceState.getBoolean(TURN);
            if (xTurn) {
                text.setText(XTURN);
            } else {
                text.setText(OTURN) ;
            }
            }



        }






