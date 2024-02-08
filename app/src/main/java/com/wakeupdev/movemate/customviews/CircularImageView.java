package com.wakeupdev.movemate.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class CircularImageView extends AppCompatImageView {

    private BitmapShader shader;
    private Paint paint;

    public CircularImageView(Context context) {
        super(context);
        init();
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            super.onDraw(canvas);
            return;
        }

        if (shader == null) {
            Bitmap bitmap = drawableToBitmap(getDrawable());
            shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }

        paint.setShader(shader);

        float center = getWidth() / 2f;
        canvas.drawCircle(center, center, center, paint);
    }

    private Bitmap drawableToBitmap(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
