package com.example.xyzreader.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.android.volley.toolbox.NetworkImageView;

public class FixedAspectRatioNetworkImageView extends NetworkImageView {

    private final static float DEFAULT_ASPECT_RATIO = 1.618033989f;

    private float aspectRatio;

    public FixedAspectRatioNetworkImageView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public FixedAspectRatioNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public FixedAspectRatioNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle, 0);
    }

    private void init(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        aspectRatio = DEFAULT_ASPECT_RATIO;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        final int height = (int) (measuredWidth / aspectRatio);
        setMeasuredDimension(widthMeasureSpec, height);
    }
}
