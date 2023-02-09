package sms.team.culturea.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import sms.team.culturea.R;
import sms.team.culturea.about.AboutActivity;
import sms.team.culturea.quiz.MainQuizActivity;
import sms.team.culturea.snake.SnakeActivity;
import sms.team.culturea.alpaca.AlpacaActivity;

public class MenuActivity extends AppCompatActivity {

    private ImageView btnStartAlpaca, btnStartSnake, btnStartQuiz, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        initViews();

        btnStartSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SnakeActivity.class);
                startActivity(intent);
            }
        });

        btnStartAlpaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AlpacaActivity.class);
                startActivity(intent);
            }
        });

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainQuizActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews()
    {
        btnStartAlpaca = findViewById(R.id.btnStartAlpaca);
        btnStartSnake = findViewById(R.id.btnStartSnake);
        btnStartQuiz = findViewById(R.id.btnStartQuiz);
        btnAbout = findViewById(R.id.btnAbout);
    }
}