package com.stonejuly.picturecachetest;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

/**
 * 自定义BitmapUtils实现三级缓存
 */

public class BitmapUtils {
    private static final String TAG = "BitmapUtils";
    private NetCacheUtils mNetCache;
    private LocalCacheUtils mLocalCache;
    private MemoryCacheUtils mMemoryCache;

    public BitmapUtils() {
        mMemoryCache = new MemoryCacheUtils();
        mLocalCache = new LocalCacheUtils();
        mNetCache = new NetCacheUtils(mLocalCache, mMemoryCache);
    }

    public void display(ImageView imageView, String url) {
        imageView.setImageResource(R.mipmap.ic_launcher);
        Bitmap bitmap;
        bitmap = mMemoryCache.getBitmapFromMemory(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            Log.d(TAG, "display: 从内存获取图片");
            return;
        }
        bitmap = mLocalCache.getBitmapFromLocal(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            Log.d(TAG, "display: 从本地获取图片");
            mMemoryCache.setBitmapToMemory(url, bitmap);
            return;
        }
        mNetCache.getBitmapFromNet(imageView, url);
    }
}
