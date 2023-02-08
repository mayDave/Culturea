package sms.team.culturea.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import sms.team.culturea.R;
import sms.team.culturea.snake.SnakeActivity;
import sms.team.culturea.alpaca.AlpacaActivity;

public class MenuActivity extends AppCompatActivity {

    private ImageButton btnStartAlpaca, btnStartSnake;

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
    }

    private void initViews()
    {
        btnStartAlpaca = findViewById(R.id.btnStartAlpaca);
        btnStartSnake = findViewById(R.id.btnStartSnake);
    }
}