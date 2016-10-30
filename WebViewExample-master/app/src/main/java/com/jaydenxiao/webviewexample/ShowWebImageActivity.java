package com.jaydenxiao.webviewexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * author andli
 * create at 16/10/30 下午4:18
 * 显示web大图
 **/

public class ShowWebImageActivity extends Activity {
    private TextView    imageTextView   = null;
    private ImageView   img;
    private String      imagePath       = null;

    public static void startAction(Context context, String image) {
        Intent intent = new Intent(context, ShowWebImageActivity.class);
        intent.putExtra("image", image);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show_big_photo);

        this.imagePath      = getIntent().getStringExtra("image");

        this.imageTextView  = (TextView) findViewById(R.id.tv_url);
        img = (ImageView) findViewById(R.id.img);

        imageTextView.setText(this.imagePath);

        // 使用了google提供的开源图片加载库glide
        Glide.with(this).load(imagePath).diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.1f).into(img);
    }

}


