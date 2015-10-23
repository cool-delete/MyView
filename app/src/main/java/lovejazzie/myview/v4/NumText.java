package lovejazzie.myview.v4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import lovejazzie.myview.myview.R;
import lovejazzie.myview.v3.BaseView;

/**
 * Created by Administrator on 2015/10/6.
 */
public class NumText extends BaseView {
    private Paint paint = new Paint();
    private int LineNum, mx;
    private boolean xScroll = false;
    private String mtext="就是你";

    @Override
    protected void drawSub(Canvas canvas) {
        for (int i = 0; i < LineNum; i++) {
            int TextSize = 30 + i;
            paint.setTextSize(TextSize);
            canvas.drawText(mtext, mx, TextSize + TextSize * i, paint);
        }

    }

    @Override
    protected void logic() {

        if (xScroll) {
            mx += 3;
            if (mx > getWidth()) {
                mx = (int) (0 - paint.measureText(mtext));
            }
        }
    }

    public NumText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NumText);
        LineNum = ta.getInteger(R.styleable.NumText_LineNum, 1);
        xScroll=ta.getBoolean(R.styleable.NumText_xScorll,false);
        ta.recycle();//共享资源
    }

    public NumText(Context context) {

        super(context);
    }
}
