package com.wanghong.output;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by Neo on 2017/6/6.
 */

public class EGLOutputSurface extends GLSurfaceView {
    private static final String TAG = "EGLOutputSurface";
    private EGLOutputRenderer mEGLOutputRenderer;

    public EGLOutputSurface(Context context) {
        super(context);
        initView(context, null);
    }

    public EGLOutputSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mEGLOutputRenderer = new EGLOutputRenderer(this);
        setEGLContextClientVersion(2);
        setRenderer(mEGLOutputRenderer);
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    public void setEglOutputSurfaceCallback(EGLOutputSurfaceCallback eglOutputSurfaceCallback) {
        mEGLOutputRenderer.setEglOutputSurfaceCallback(eglOutputSurfaceCallback);
    }

    public void setStillBitmap(Bitmap stillBitmap) {
        mEGLOutputRenderer.setStillBitmap(stillBitmap);
    }

    public SurfaceTexture getSurfaceTexture() {
        return mEGLOutputRenderer.getSurfaceTexture();
    }

    public void setOutputRenderType(int outputRenderType) {
        mEGLOutputRenderer.setOutputRenderType(outputRenderType);
    }
}
