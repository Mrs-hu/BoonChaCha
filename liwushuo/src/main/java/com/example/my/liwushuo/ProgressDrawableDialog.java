package com.example.my.liwushuo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/9.
 */
public class ProgressDrawableDialog extends AlertDialog {

    private ImageView progressIamge;

    private AnimationDrawable animationDrawable;

    private ObjectAnimator objectAnimator1;

    public ProgressDrawableDialog(Context context) {
        super(context, R.style.MyProgressDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_drawable_dialog_layout);
        setCanceledOnTouchOutside(false);
        progressIamge = (ImageView) this.findViewById(R.id.refreshing_drawable_img);
        animationDrawable = (AnimationDrawable) progressIamge.getDrawable();
         objectAnimator1 = ObjectAnimator.ofFloat(progressIamge, "rotationY", 0F, 900F).setDuration(5000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (animationDrawable != null) {
            animationDrawable.start();
            objectAnimator1.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (animationDrawable != null) {
            animationDrawable.stop();

        }
    }
}
