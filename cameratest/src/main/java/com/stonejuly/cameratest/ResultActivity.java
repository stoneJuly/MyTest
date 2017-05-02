package com.stonejuly.cameratest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResultActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String path = getIntent().getStringExtra("picPath");
        ImageView imageView = (ImageView) findViewById(R.id.iv_result);
        try {
            FileInputStream fis = new FileInputStream(path);
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            Matrix  matrix = new Matrix();
            matrix.setRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            imageView.setImageBitmap(drawText2Bitmap(bitmap, "这是我制作的水印相机"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Bitmap bitmap = BitmapFactory.decodeFile(path);
//        imageView.setImageBitmap(bitmap);
    }

    private Bitmap drawText2Bitmap(Bitmap bitmap, String text) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(240);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        paint.setDither(true);
        paint.setFilterBitmap(true);

        Bitmap.Config config = bitmap.getConfig();
        if(config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(config, true);

        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(text, 0, bounds.height(), paint);
        return bitmap;
    }
}
