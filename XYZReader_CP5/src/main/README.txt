Checkpoint 5

Bitmap performance tuning

@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            DummyContent.DummyItem dummy = DummyContent.ITEMS.get(0);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 16;