package com.example.android.bluetoothchat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by gustav on 2017-02-21.
 */

public class UnderlinedTextView extends TextView {

    private Rect lineBoundsRect;
    private Paint underlinePaint;

    public UnderlinedTextView(Context context) {
        this(context, null, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyle) {

        float density = context.getResources().getDisplayMetrics().density;

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, defStyle, 0);
        int mColor = typedArray.getColor(R.styleable.UnderlinedTextView_underlineColor, 0xFFFF0000);
        float mStrokeWidth = typedArray.getDimension(R.styleable.UnderlinedTextView_underlineWidth, density * 2);
        typedArray.recycle();

        lineBoundsRect = new Rect();
        underlinePaint = new Paint();
        underlinePaint.setStyle(Paint.Style.STROKE);
        underlinePaint.setColor(mColor); //color of the underline
        underlinePaint.setStrokeWidth(mStrokeWidth);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "JosefinSans-Light.ttf");
        setTypeface(tf);
    }

    @ColorInt
    public int getUnderLineColor() {
        return underlinePaint.getColor();
    }

    public void setUnderLineColor(@ColorInt int mColor) {
        underlinePaint.setColor(mColor);
        invalidate();
    }

    public float getUnderlineWidth() {
        return underlinePaint.getStrokeWidth();
    }

    public void setUnderlineWidth(float mStrokeWidth) {
        underlinePaint.setStrokeWidth(mStrokeWidth);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int count = getLineCount();
        int mStrokeWidth =10;

        final Layout layout = getLayout();
        float x_start, x_stop, x_diff;
        int firstCharInLine, lastCharInLine;

        for (int i = 0; i < count; i++) {
            int baseline = getLineBounds(i, lineBoundsRect);
            firstCharInLine = layout.getLineStart(i);
            lastCharInLine = layout.getLineEnd(i);

            x_start = layout.getPrimaryHorizontal(firstCharInLine);
            x_diff = layout.getPrimaryHorizontal(firstCharInLine + 1) - x_start;
            x_stop = layout.getPrimaryHorizontal(lastCharInLine - 1) + x_diff;

            canvas.drawLine(x_start, baseline + mStrokeWidth, x_stop, baseline + mStrokeWidth, underlinePaint);
        }

        super.onDraw(canvas);
    }
}