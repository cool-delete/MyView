//region Description
//<editor-fold desc="Description">
//endregion
package lovejazzie.myview.v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import lovejazzie.myview.myview.R;

/**
 * Created by Administrator on 2015/9/13.
 */
public class Myview extends View {

    private Bitmap bitmap;

    public Myview(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b1);
    }/* 以下 */

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b1);
        /* 这两段代码必须要放在构造函数中 是要告诉系统这个布局有内容的
           创造canvas实例时需要Bitmap
         * 有了bitmap就有canvas就能让系统调用ondraw函数 */

    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setTextSize(30);
        canvas.drawText("omaladgaga", 0, 30, p);
        Paint w = new Paint();
        w.setColor(Color.BLUE);
        canvas.drawLine(0, 60, 200, 60, w);

        w.setStyle(Paint.Style.STROKE);

        //        canvas.drawRect(0,90,100,190,w);

        RectF rectF = new RectF(0, 90, 200, 290);
        canvas.drawRoundRect(rectF, 30, 30, w);

        canvas.drawCircle(50, 370, 50, w);
        canvas.drawBitmap(bitmap, 0, 510, w);
    }

}
//</editor-fold>
