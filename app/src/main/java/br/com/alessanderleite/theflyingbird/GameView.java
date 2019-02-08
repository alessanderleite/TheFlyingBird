package br.com.alessanderleite.theflyingbird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class GameView extends View {

    //Bird
    private Bitmap bird;

    //Background
    private Bitmap bgImage;

    //Score
    private Paint scorePaint = new Paint();

    //Level
    private Paint levelPaint = new Paint();

    //Life
    private Bitmap[] life = new Bitmap[2];

    public GameView(Context context) {
        super(context);

        bird = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
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
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(bgImage,0,0,null);
        canvas.drawBitmap(bird,0,0,null);
        canvas.drawText("Score: 0", 20, 60, scorePaint);
        canvas.drawText("Lv.1", canvas.getWidth()/2, 60, levelPaint);

        canvas.drawBitmap(life[0], canvas.getWidth() -200, 30, null);
        canvas.drawBitmap(life[0], canvas.getWidth() -130, 30,null);
        canvas.drawBitmap(life[1], canvas.getWidth()-60, 30,null);

    }
}
