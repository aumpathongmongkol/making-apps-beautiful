Checkpoint 4

Two-Pane UI

Create values-sw600dp-land and add refs.xml

<resources>
    <!--
    For more on layout aliases, see:
    http://developer.android.com/training/multiscreen/screensizes.html#TaskUseAliasFilters
    -->
    <item name="activity_article_list" type="layout">
        @layout/activity_article_twopane
    </item>
</resources>

Update dimens.xml in values-sw600dp

<?xml version="1.0" encoding="utf-8"?>
<resources>
    <dimen name="thumbnail_width">96dp</dimen>
    <dimen name="photo_height">200dp</dimen>
    <dimen name="list_item_vert_margin">16dp</dimen>
    <dimen name="detail_horiz_margin">80dp</dimen>
</resources>