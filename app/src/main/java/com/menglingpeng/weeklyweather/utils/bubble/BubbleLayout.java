package com.menglingpeng.weeklyweather.utils.bubble;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.menglingpeng.weeklyweather.R;


/**
 * 气泡布局
 */
public class BubbleLayout extends RelativeLayout{

    public static int PADDING = 30;
    public static int LEG_HALF_BASE = 30;
    public static float STROKE_WIDTH = 2.0f;
    public static float CORNER_RADIUS = 8.0f;
    public static int SHADOW_COLOR = Color.argb(100, 0, 0, 0);
    public static float MIN_LEG_DISTANCE = PADDING + LEG_HALF_BASE;

    private Paint fillPaint = null;
    private final Path path = new Path();
    private final Path bubbleLegPrototype = new Path();
    private final Paint paint = new Paint(Paint.DITHER_FLAG);

    private float bubbleLegOffset = 0.75f;
    private BubbleOrientation bubbleOrientation = BubbleOrientation.RIGHT;

    public BubbleLayout(Context context) {
        this(context, null);
    }

    public BubbleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attrs) {

        //setGravity(Gravity.CENTER);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.bubble);

            try {
                PADDING = a.getDimensionPixelSize(R.styleable.bubble_padding, PADDING);
                SHADOW_COLOR = a.getInt(R.styleable.bubble_shadowColor, SHADOW_COLOR);
                LEG_HALF_BASE = a.getDimensionPixelSize(R.styleable.bubble_halfBaseOfLeg, LEG_HALF_BASE);
                MIN_LEG_DISTANCE = PADDING + LEG_HALF_BASE;
                STROKE_WIDTH = a.getFloat(R.styleable.bubble_strokeWidth, STROKE_WIDTH);
                CORNER_RADIUS = a.getFloat(R.styleable.bubble_cornerRadius, CORNER_RADIUS);
            } finally {
                if (a != null) {
                    a.recycle();
                }
            }
        }

        paint.setColor(SHADOW_COLOR);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setPathEffect(new CornerPathEffect(CORNER_RADIUS));

        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(LAYER_TYPE_SOFTWARE, paint);
        }

        fillPaint = new Paint(paint);
        fillPaint.setColor(Color.WHITE);
        fillPaint.setShader(new LinearGradient(100f, 0f, 100f, 200f, Color.WHITE, Color.WHITE,
                Shader.TileMode.CLAMP));

        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(LAYER_TYPE_SOFTWARE, fillPaint);
        }
        paint.setShadowLayer(2f, 2F, 5F, SHADOW_COLOR);

        renderBubbleLegPrototype();

        setPadding(PADDING, PADDING, PADDING, PADDING);

    }



    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 尖角path
     */
    private void renderBubbleLegPrototype() {
        bubbleLegPrototype.moveTo(0, 0);
        bubbleLegPrototype.lineTo(PADDING * 1.5f, -PADDING / 1.5f);
        bubbleLegPrototype.lineTo(PADDING * 1.5f, PADDING / 1.5f);
        bubbleLegPrototype.close();
    }

    public void setBubbleParams(BubbleOrientation bubbleOrientation, final float bubbleOffset) {
        bubbleLegOffset = bubbleOffset;
        bubbleOrientation = bubbleOrientation;
    }

    /**
     * 根据显示方向，获取尖角位置矩阵
     * @param width
     * @param height
     * @return
     */
    private Matrix renderBubbleLegMatrix(final float width, final float height) {

        final float offset = Math.max(bubbleLegOffset, MIN_LEG_DISTANCE);

        float dstX = 0;
        float dstY = Math.min(offset, height - MIN_LEG_DISTANCE);
        final Matrix matrix = new Matrix();

        switch (bubbleOrientation) {

            case TOP:
                dstX = Math.min(offset, width - MIN_LEG_DISTANCE);
                dstY = 0;
                matrix.postRotate(90);
                break;

            case RIGHT:
                dstX = width;
                dstY = Math.min(offset, height - MIN_LEG_DISTANCE);
                matrix.postRotate(180);
                break;

            case BOTTOM:
                dstX = Math.min(offset, width - MIN_LEG_DISTANCE);
                dstY = height;
                matrix.postRotate(270);
                break;

        }

        matrix.postTranslate(dstX, dstY);
        return matrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        final float width = canvas.getWidth();
        final float height = canvas.getHeight();

        path.rewind();
        path.addRoundRect(new RectF(PADDING, PADDING, width - PADDING, height - PADDING),
                CORNER_RADIUS, CORNER_RADIUS, Path.Direction.CW);
        path.addPath(bubbleLegPrototype, renderBubbleLegMatrix(width, height));

        canvas.drawPath(path, paint);
        canvas.scale((width - STROKE_WIDTH) / width, (height - STROKE_WIDTH) / height, width / 2f,
                height / 2f);

        canvas.drawPath(path, fillPaint);
    }

}
