package lovejazzie.myview.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Administrator on 2015/9/29.
 */
public abstract class BaseView extends View {

    private MyThread myThread;
    private RectF rectf = new RectF(0, 60, 100, 160);
    private float px;
    private Random random = new Random();

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context) {
        super(context);
    }

    protected abstract void logic();

    protected abstract void drawSub(Canvas canvas);

    @Override
    protected final void onDraw(Canvas canvas) {


        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        } else {
            drawSub(canvas);
        }

    }


    class MyThread extends Thread {


        @Override
        public void run() {

            while (true) {
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                logic();
                postInvalidate();
            }
        }
    }
}








