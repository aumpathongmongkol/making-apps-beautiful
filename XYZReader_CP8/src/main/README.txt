Checkpoint 8

Use ActionBarCompat

Extends from ActionBarActivity instead of FragmentActivity

public class ArticleListActivity extends ActionBarActivity implements
        ArticleListFragment.Callbacks {
    ...
}

public class ArticleDetailActivity extends ActionBarActivity {
    ...
}

Inside your Fragments, override the onCreateOptionsMenu and onOptionsItemSelected methods

@Override
public void onCreateSupportOptionsMenu(Menu menu, MenuInflater inflater) {
    ...
}

@Override
public boolean onSupportOptionsItemSelected(MenuItem item) {
    ...
}

Update res/menu/main.xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto" >
    <item
        android:id="@+id/refresh"
        android:title="@string/refresh"
        android:icon="@drawable/ic_refresh"
        app:showAsAction="always|withText" />
    <item android:id="@+id/settings"
        app:showAsAction="never"
        android:title="@string/settings"/>
</menu>

Update res/menu/article.xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/share"
        app:showAsAction="always"
        android:title="@string/share"
        android:icon="@drawable/ic_share"
        android:actionProviderClass="android.widget.ShareActionProvider"/>
    <item android:id="@+id/settings"
        app:showAsAction="never"
        android:title="@string/settings"/>
</menu>

Theme changes for Action Bar Compat