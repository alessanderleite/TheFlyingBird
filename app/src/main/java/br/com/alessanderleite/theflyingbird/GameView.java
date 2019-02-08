package br.com.alessanderleite.theflyingbird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GameView extends View {

    //Bird
    private Bitmap bird;

    public GameView(Context context) {
        super(context);

        bird = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(bird,0,0,null);
    }
}
