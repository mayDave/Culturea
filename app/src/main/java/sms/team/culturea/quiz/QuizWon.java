package sms.team.culturea.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sms.team.culturea.R;

public class QuizWon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_won);
    }

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(QuizWon.this, MainQuizActivity.class);
        startActivity(intent);
        finish();
    }
}
