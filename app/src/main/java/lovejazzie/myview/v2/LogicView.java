package lovejazzie.myview.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Administrator on 2015/9/29.
 */
public class LogicView extends View {
    private float rx = 0;
    private Paint paint = new Paint();
    private MyThread myThread;
    private RectF rectf = new RectF(0, 60, 100, 160);
    private float px;
    private int r;
    private int g;
    private int b;

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogicView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText("logicView", rx, 30, paint);
        canvas.drawArc(rectf, 0, px, true, paint);


        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        }
    }

    class MyThread extends Thread {
        Random random = new Random();

        @Override
        public void run() {

            while (true) {
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (rx > getWidth()) {
                    rx = (0 - paint.measureText("logicView"));
                }
                if (px > 360) {
                    px = 0;
                }

                rx += 3;
                px++;
                r = random.nextInt(256);
                g = random.nextInt(256);
                b = random.nextInt(256);
                paint.setARGB(255, r, g, b);
                postInvalidate();
            }
        }
    }
}








