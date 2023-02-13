package com.example.usingsharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Main activity1.

 *  @author    Nisim Doron Krief <nisimandroi@gmail.com>
 *  @version    1.0
 *  @since    13/02/2023 (the date of the package the class was added)
 *  @info Program that uses SharedPreferences, buttons and options menu,
 *  The Program let you write things, add number/reset it and it will save when you press Exit.*/
public class MainActivity extends AppCompatActivity {
    /**
     * The EditText eT.
     */
    EditText eT;
    /**
     * The TextView nTv.
     */
    TextView nTv;
    /**
     * The Num.
     */
    int num;
    /**
     * The etext.
     */
    String eText;
    /**
     * The SharedPreferences Sp.
     */
    SharedPreferences SP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SP= getSharedPreferences("SaveFile", MODE_PRIVATE);
        num = SP.getInt("NumberSaved", 0);
        eText = SP.getString("TextSaved", "");
        SharedPreferences.Editor editor = SP.edit();
        editor.putString("TextSaved", "");
        editor.putInt("NumberSaved", 0);
        editor.commit();
        eT = (EditText) findViewById(R.id.eT);
        nTv = (TextView) findViewById(R.id.nTv);
        eT.setHint(eText);
        nTv.setText(""+num);




    }

    /**
     * Increase.
     *
     * when pressing the button, it adds 1 to the Integer num
     */
    public void Increase(View view) {
        num++;
        nTv.setText(""+num);

    }

    /**
     * Reset.
     *
     * when pressing the button, it resets the Integer num to zero
     */
    public void Reset(View view) {
        num = 0;
        nTv.setText(""+num);
    }

    /**
     * Exit.
     *
     * when pressing the button, it saves the num and the text then close the program.
     */
    public void Exit(View view) {
        SharedPreferences.Editor editor = SP.edit();
        eText = eText + eT.getText();
        editor.putString("TextSaved", eText);
        editor.putInt("NumberSaved", num);
        editor.commit();

        finish();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getTitle().toString().equals("Credits")){
            Intent Si = new Intent(this,MainActivity2.class);
            startActivity(Si);

        }



        return true;
    }
}