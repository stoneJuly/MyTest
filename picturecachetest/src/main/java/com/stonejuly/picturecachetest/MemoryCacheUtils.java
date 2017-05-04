package com.stonejuly.picturecachetest;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 三级缓存之内存缓存
 */

public class MemoryCacheUtils {
    private LruCache<String, Bitmap> mMemroyCache;

    public MemoryCacheUtils() {
        //定义图片缓存内存上限
        long maxMemory = Runtime.getRuntime().maxMemory() / 8;
        mMemroyCache = new LruCache<String, Bitmap>((int) maxMemory){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getAllocationByteCount();
            }
        };
    }

    /**
     * 从内存读取图片
     * @param url
     * @return
     */
    public Bitmap getBitmapFromMemory(String url) {
        return mMemroyCache.get(url);
    }

    /**
     * 往内存中写图片
     * @param url
     * @param bitmap
     */
    public void setBitmapToMemory(String url, Bitmap bitmap) {
        mMemroyCache.put(url, bitmap);
    }
}
