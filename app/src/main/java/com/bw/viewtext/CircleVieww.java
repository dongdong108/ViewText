package com.bw.viewtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by asus on 2016/11/1.
 */
public class CircleVieww extends View {

    private int sweepAngle;
    private int startAngle;
//    private int textColor;
//    private int arcColor;
//    private int circleColor;
    private String text;
    private float textSize;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private RectF mRectF;
    private Paint mArcPaint;
    private Paint mTextPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
//        canvas.drawText(text, 0, text.length(), mCircleXY, mCircleXY + textSize
//                / 4, mTextPaint);
        canvas.drawText("勾燕琪妹妹", mCircleXY, mCircleXY + textSize / 4, mTextPaint);
    }
    public CircleVieww(Context context) {
        super(context);
    }

    public CircleVieww(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.circleView);
        if (ta != null) {
//            circleColor = ta.getColor(R.styleable.circleView_circleColor, 0);
//            arcColor = ta.getColor(R.styleable.circleView_arcColor, 0);
//            textColor = ta.getColor(R.styleable.circleView_textColor, 0);
            textSize = ta.getDimension(R.styleable.circleView_textSize, 50);
            text = ta.getString(R.styleable.circleView_text);
            startAngle = ta.getInt(R.styleable.circleView_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.circleView_sweepAngle, 270);
            ta.recycle();
        }
    }

    public CircleVieww(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init(w,h);

    }
    private void init(int width,int height) {
        int length = Math.min(width, height);
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.RED);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((width * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }
}
