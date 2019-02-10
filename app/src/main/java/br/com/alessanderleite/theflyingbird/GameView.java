package br.com.alessanderleite.theflyingbird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    //Canvas
    private int canvasWidth;
    private int canvasHeight;

    //Bird
    //private Bitmap bird;
    private Bitmap bird[] = new Bitmap[2];
    private int birdX = 10;
    private int birdY;
    private int birdSpeed;

    //Blue Ball
    private int blueX;
    private int blueY;
    private int blueSpeed = 15;
    private Paint bluePaint = new Paint();

    //Background
    private Bitmap bgImage;

    //Score
    private Paint scorePaint = new Paint();

    //Level
    private Paint levelPaint = new Paint();

    //Life
    private Bitmap life[] = new Bitmap[2];

    //Status Check
    private boolean touch_flg = false;

    public GameView(Context context) {
        super(context);

        bird[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
        bird[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird2);

        bgImage = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(32);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        levelPaint.setColor(Color.DKGRAY);
        levelPaint.setTextSize(32);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setTextAlign(Paint.Align.CENTER);
        levelPaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart_g);

        //First position
        birdY = 500;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(bgImage,0,0,null);

        //Bird
        int minBirdY = bird[0].getHeight();
        int maxBirdY = canvasHeight - bird[0].getHeight() * 4 - bird[0].getHeight()/3;
        Log.d("MAXMIN", "minBirdY====>>> " + minBirdY);
        Log.d("MAXMIN", "maxBirdY====>>> " + maxBirdY);

        birdY += birdSpeed;
        if (birdY < minBirdY) birdY = minBirdY;
        if (birdY > maxBirdY) birdY = maxBirdY;
        birdSpeed +=2;

        if (touch_flg) {
            //Flap wings
            canvas.drawBitmap(bird[1], birdX, birdY, null);
            touch_flg = false;

        } else {
            canvas.drawBitmap(bird[0], birdX, birdY, null);
        }


        canvas.drawText("Score: 0", 20, 60, scorePaint);
        canvas.drawText("Lv.1", canvasWidth/2, 60, levelPaint);

        canvas.drawBitmap(life[0], canvas.getWidth() - 200, 30,null);
        canvas.drawBitmap(life[0], canvas.getWidth() - 130, 30,null);
        canvas.drawBitmap(life[1], canvas.getWidth() -  60, 30,null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch_flg = true;
            birdSpeed = -20;
        }
        return true;
    }
}
