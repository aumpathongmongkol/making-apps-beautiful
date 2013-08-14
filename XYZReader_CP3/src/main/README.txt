Checkpoint 3

Use better whitespace (spacing + margins)

<?xml version="1.0" encoding="utf-8"?>
<resources>
    <dimen name="thumbnail_width">80dp</dimen>
    <dimen name="thumbnail_height">48dp</dimen>
    <dimen name="photo_height">200dp</dimen>
    <dimen name="list_item_vert_margin">8dp</dimen>
    <dimen name="detail_horiz_margin">16dp</dimen>
</resources>

Thumbnails + Photo Treatment 

android:scaleType = centerCrop

In fragment_article_details.xml
<ImageView
    android:id="@+id/photo"
    android:layout_width="match_parent"
    android:layout_height="@dimen/photo_height"
    android:layout_marginLeft="@dimen/detail_horiz_margin"
    android:layout_marginRight="@dimen/detail_horiz_margin" 
    android:scaleType="centerCrop" />
    
    
In list_item_article.xml
<ImageView android:id="@+id/thumbnail"
    android:layout_width="@dimen/thumbnail_width"
    android:layout_height="match_parent"
    android:scaleType="centerCrop" />
    
Typography

In fragment_article_details.xml
<TextView android:id="@+id/article_title"
    style="?android:textAppearanceMedium"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textColor="#c000"
    android:fontFamily="sans-serif-condensed"
    android:textStyle="bold"
    android:ellipsize="end"
    android:maxLines="2"
    android:lineSpacingMultiplier="0.85"
    android:paddingBottom="4dp" />

<TextView android:id="@+id/article_subtitle"
    style="?android:textAppearanceSmall"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textColor="#6000"
    android:textAllCaps="true"
    android:maxLines="1"
    android:singleLine="true"
    android:ellipsize="end" />
    
    
Custom Highlight + Font

In fragment_article_detail.xml
android:textColorLink = @color/bacon


In ArticleDetailFragment.java
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_article_detail,
            container, false);
    if (mItem != null) {
        ((TextView) rootView.findViewById(R.id.article_title))
                .setText(mItem.title);
        // Custom highlight the author
       ((TextView) rootView.findViewById(R.id.article_byline))
                .setText(Html.fromHtml(mItem.time.toUpperCase() + 
                " BY <font color='" + 
            	  getResources().getString(R.string.author_font_color) + "'>" +
            	  mItem.author.toUpperCase() + "</a>"));
        // Use custom font
        ((TextView) rootView.findViewById(R.id.article_body))
                .setTypeface(Typeface.createFromAsset(
                        getResources().getAssets(), "Rosario-Regular.ttf"));
        ...
    }
    return rootView;
}