package lovejazzie.myview.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by Administrator on 2015/10/5.
 */
public class LogicView extends BaseView {

    private float rx = 0;
    private Paint paint = new Paint();
    private int a, b, c;
    private Random rm = new Random();//随机对象
    private float sweepangle = 0;
    RectF rectF = new RectF(0, 60, 100, 160);//矩形

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogicView(Context context) {
        super(context);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText("logicView", rx, 30, paint);

        canvas.drawArc(rectF, -90, sweepangle, true, paint);//绘制弧形的方法
        //      1参数是绘制范围,2是起始角度3是扫过角度 4是绘制扇形
    }

    @Override
    protected void logic() {


        sweepangle++;
        rx += 3;
        if (rx > getWidth()) {
            rx = 0 - paint.measureText("logicview");
        }
        if (sweepangle > 360) {
            sweepangle = 0;
        }

        a = rm.nextInt(265);//赋值随机数
        b = rm.nextInt(256);
        c = rm.nextInt(256);
        paint.setARGB(255, a, b, c);

    }
}
