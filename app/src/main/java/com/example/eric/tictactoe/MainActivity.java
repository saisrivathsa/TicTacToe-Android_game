package com.example.eric.tictactoe;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public GameBoard board=new GameBoard();
    public int moveCount = 0, xloc = 0, yloc = 0;
    public String mark = "X", aiMark = "O";
    public boolean isOver = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean checkEnd(String player) {
        if (board.isWinner())
        {
            announce(true, player);
            return true;
        }
       else if (moveCount == 9)
        {
            announce(false, player);
            return true;
        }
         return false;
    }
    public void resetClick(View v) {
        clear();
    }
    public void announce(boolean endState, String player) {
       if (endState == true)
            player = player + " wins!";
        else
            player = "Draw!";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, player, Toast.LENGTH_LONG);
        toast.show();
    }
    public void cellClick(View v) {
        if (moveCount%2==0){
            mark="X";
        }
        else
        {
            mark="O";
        }
        TextView cell = (TextView) findViewById(v.getId());
        String content = (String) cell.getText();
        if (content == "" && !isOver) {
            switch (cell.getId())
            {
                case R.id.cell11:
                    xloc = 0; yloc = 0; break;
                case R.id.cell12:
                    xloc = 0; yloc = 1; break;
                case R.id.cell13:
                    xloc = 0; yloc = 2; break;
                case R.id.cell21:
                    xloc = 1; yloc = 0; break;
                case R.id.cell22:
                    xloc = 1; yloc = 1; break;
                case R.id.cell23:
                    xloc = 1; yloc = 2; break;
                case R.id.cell31:
                    xloc = 2; yloc = 0; break;
                case R.id.cell32:
                    xloc = 2; yloc = 1; break;
                case R.id.cell33:
                    xloc = 2; yloc = 2; break;
            }
            board.placeMark(xloc, yloc, mark);
            cell.setText(mark);
            moveCount++;
            isOver = checkEnd(mark);


        }
    }
    public void clear() {

        int[] idList = { R.id.cell11, R.id.cell12, R.id.cell13, R.id.cell21,
                R.id.cell22, R.id.cell23, R.id.cell31, R.id.cell32, R.id.cell33 };
        TextView cell;

        for (int item : idList) {
            cell = (TextView) findViewById(item);
            cell.setText("");
        }

        isOver = false;
        moveCount = 0;
        board.clear();
    }


}

