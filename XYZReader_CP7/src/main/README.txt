Checkpoint 7

Use Image Cache

/**
 * The memory cache for bitmap images
 */
private LruCache<String, Bitmap> mMemoryCache;

Update onCreate method
// Get max available VM memory, exceeding this amount will throw an
// OutOfMemory exception. Stored in kilobytes as LruCache takes an
// int in its constructor.
final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

// Use 1/8th of the available memory for this memory cache.
final int cacheSize = maxMemory / 8;

mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    protected int sizeOf(String key, Bitmap bitmap) {
        // The cache size will be measured in kilobytes rather than
        // number of items.
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR1) {
            return bitmap.getByteCount() / 1024;
        } else {
            return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
        }
    }
};

Add two methods

public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
    if (getBitmapFromMemCache(key) == null) {
        mMemoryCache.put(key, bitmap);
    }
}

public Bitmap getBitmapFromMemCache(String key) {
    return mMemoryCache.get(key);
}

Update doInBackground method to add cache

// Decode image in background.
@Override
protected Bitmap doInBackground(Integer... params) {
    resId = params[0];
    ImageView thumbnail = imageViewReference.get();
    Bitmap bitmap =  decodeSampledBitmapFromResource(getResources(), resId, thumbnail.getWidth(), thumbnail.getHeight());
    addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
    return bitmap;
}

Update loadBitmap method to get image from cache

public void loadBitmap(int resId, ImageView imageView) {
    final String imageKey = String.valueOf(resId);
    final Bitmap bitmap = getBitmapFromMemCache(imageKey);
    
    if (bitmap != null) {
        imageView.setImageBitmap(bitmap);
    } else {
        if (cancelPotentialWork(resId, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
            final AsyncDrawable asyncDrawable =
                    new AsyncDrawable(getResources(), mPlaceHolderBitmap, task);
            imageView.setImageDrawable(asyncDrawable);
            task.execute(resId);
        }
    }
}