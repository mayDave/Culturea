package sms.team.culturea.snake;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

import sms.team.culturea.R;

public class GameView extends View {
    private Bitmap bmGrass1, bmGrass2, bmSnake1, bmPoint;
    private ArrayList<Grass> arrGrass = new ArrayList<>();
    private int w = 12, h=21;
    public static int sizeElementMap = 75*Constants.SCREEN_WIDTH/1080;
    private Snake snake;
    private Point point;
    private Handler handler;
    private Runnable r;
    private boolean move = false;
    private float mx, my;
    public static boolean isPlaying = false;
    public static int score = 0, bestScore = 0;
    private Context context;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        SharedPreferences sp = context.getSharedPreferences("gamesetting", Context.MODE_PRIVATE);
        if(sp!=null){
            bestScore = sp.getInt("bestscore",0);
        }
        bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake_bg1);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeElementMap, sizeElementMap, true);
        bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake_bg2);
        bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, sizeElementMap, sizeElementMap, true);
        bmSnake1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake_black);
        bmSnake1 = Bitmap.createScaledBitmap(bmSnake1, 14*sizeElementMap, sizeElementMap, true);
        bmPoint = BitmapFactory.decodeResource(this.getResources(), R.drawable.pizza);
        bmPoint = Bitmap.createScaledBitmap(bmPoint, sizeElementMap, sizeElementMap, true);
        for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if((j+i)%2==0){
                    arrGrass.add(new Grass(bmGrass1, j*bmGrass1.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass1.getWidth(), i*bmGrass1.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass1.getWidth(), bmGrass1.getHeight()));
                }else{
                    arrGrass.add(new Grass(bmGrass2, j*bmGrass2.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass2.getWidth(), i*bmGrass2.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass2.getWidth(), bmGrass2.getHeight()));
                }
            }
        }
        snake = new Snake(bmSnake1,arrGrass.get(126).getX(),arrGrass.get(126).getY(), 4);
        point = new Point(bmPoint, arrGrass.get(randomPizza()[0]).getX(), arrGrass.get(randomPizza()[1]).getY());
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    private int[] randomPizza(){
        int []xy = new int[2];
        Random r = new Random();
        xy[0] = r.nextInt(arrGrass.size()-1);
        xy[1] = r.nextInt(arrGrass.size()-1);
        Rect rect = new Rect(arrGrass.get(xy[0]).getX(), arrGrass.get(xy[1]).getY(), arrGrass.get(xy[0]).getX()+sizeElementMap, arrGrass.get(xy[1]).getY()+sizeElementMap);
        boolean check = true;
        while (check){
            check = false;
            for (int i = 0; i < snake.getArrPartSnake().size(); i++){
                if(rect.intersect(snake.getArrPartSnake().get(i).getrBody())){
                    check = true;
                    xy[0] = r.nextInt(arrGrass.size()-1);
                    xy[1] = r.nextInt(arrGrass.size()-1);
                    rect = new Rect(arrGrass.get(xy[0]).getX(), arrGrass.get(xy[1]).getY(), arrGrass.get(xy[0]).getX()+sizeElementMap, arrGrass.get(xy[1]).getY()+sizeElementMap);
                }
            }
        }
        return xy;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int a = event.getActionMasked();
        switch (a){
            case  MotionEvent.ACTION_MOVE:{
                if(move==false){
                    mx = event.getX();
                    my = event.getY();
                    move = true;
                }else{
                    if(mx - event.getX() > 100 && !snake.isMove_right()){
                        mx = event.getX();
                        my = event.getY();
                        this.snake.setMove_left(true);
                        isPlaying = true;
                        SnakeActivity.img_swipe.setVisibility(INVISIBLE);
                    }else if(event.getX() - mx > 100 &&!snake.isMove_left()){
                        mx = event.getX();
                        my = event.getY();
                        this.snake.setMove_right(true);
                        isPlaying = true;
                        SnakeActivity.img_swipe.setVisibility(INVISIBLE);
                    }else if(event.getY() - my > 100 && !snake.isMove_up()){
                        mx = event.getX();
                        my = event.getY();
                        this.snake.setMove_down(true);
                        isPlaying = true;
                        SnakeActivity.img_swipe.setVisibility(INVISIBLE);
                    }else if(my - event.getY() > 100 && !snake.isMove_down()){
                        mx = event.getX();
                        my = event.getY();
                        this.snake.setMove_up(true);
                        isPlaying = true;
                        SnakeActivity.img_swipe.setVisibility(INVISIBLE);
                    }
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                mx = 0;
                my = 0;
                move = false;
                break;
            }
        }
        return true;
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(0xFF065700);
        for(int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
        if(isPlaying){
            snake.update();
            if(snake.getArrPartSnake().get(0).getX() < this.arrGrass.get(0).getX()
                    ||snake.getArrPartSnake().get(0).getY() < this.arrGrass.get(0).getY()
                    ||snake.getArrPartSnake().get(0).getY()+sizeElementMap>this.arrGrass.get(this.arrGrass.size()-1).getY() + sizeElementMap
                    ||snake.getArrPartSnake().get(0).getX()+sizeElementMap>this.arrGrass.get(this.arrGrass.size()-1).getX() + sizeElementMap){
                gameOver();
            }
            for (int i = 1; i < snake.getArrPartSnake().size(); i++){
                if (snake.getArrPartSnake().get(0).getrBody().intersect(snake.getArrPartSnake().get(i).getrBody())){
                    gameOver();
                }
            }
        }
        snake.drawSnake(canvas);
        point.draw(canvas);
        if(snake.getArrPartSnake().get(0).getrBody().intersect(point.getR())){
            SnakeActivity.audio_Eat.start();
            point.reset(arrGrass.get(randomPizza()[0]).getX(), arrGrass.get(randomPizza()[1]).getY());
            snake.addPart();
            score++;
            SnakeActivity.txt_score.setText(score+"");
            if(score > bestScore){
                bestScore = score;
                SharedPreferences sp = context.getSharedPreferences("gamesetting", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("bestscore", bestScore);
                editor.apply();
                SnakeActivity.txt_best_score.setText(bestScore+"");
            }
        }
        handler.postDelayed(r, 100);
    }

    private void gameOver() {
        isPlaying = false;
        SnakeActivity.dialogScore.show();
        SnakeActivity.txt_dialog_best_score.setText(bestScore+"");
        SnakeActivity.txt_dialog_score.setText(score+"");
        SnakeActivity.audio_GameOver.start();
    }

    public void reset(){
        for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if((j+i)%2==0){
                    arrGrass.add(new Grass(bmGrass1, j*bmGrass1.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass1.getWidth(), i*bmGrass1.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass1.getWidth(), bmGrass1.getHeight()));
                }else{
                    arrGrass.add(new Grass(bmGrass2, j*bmGrass2.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass2.getWidth(), i*bmGrass2.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass2.getWidth(), bmGrass2.getHeight()));
                }
            }
        }
        snake = new Snake(bmSnake1,arrGrass.get(126).getX(),arrGrass.get(126).getY(), 4);
        point = new Point(bmPoint, arrGrass.get(randomPizza()[0]).getX(), arrGrass.get(randomPizza()[1]).getY());
        score = 0;
    }
}