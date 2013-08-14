/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.xyzreader.cp6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.example.xyzreader.cp6.dummy.DummyContent;

/**
 * An activity representing a single Article detail screen. This activity is
 * only used on handset devices. On tablet-size devices, item details are
 * presented side-by-side with a list of items in a {@link ArticleListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link ArticleDetailFragment}.
 */
public class ArticleDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Bundle arguments = new Bundle();
                arguments.putString(ArticleDetailFragment.ARG_ITEM_ID, DummyContent.ITEMS.get(i).id);
                ArticleDetailFragment fragment = new ArticleDetailFragment();
                fragment.setArguments(arguments);
                return fragment;
            }

            @Override
            public int getCount() {
                return DummyContent.ITEMS.size();
            }
        });
        pager.setPageMarginDrawable(getResources().getDrawable(R.drawable.list_divider_holo_light));
        pager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1,
                getResources().getDisplayMetrics()));

        String startId = getIntent().getStringExtra(ArticleDetailFragment.ARG_ITEM_ID);
        for (int i = 0; i < DummyContent.ITEMS.size(); i++) {
            if (DummyContent.ITEMS.get(i).id.equals(startId)) {
                pager.setCurrentItem(i);
                return;
            }
        }
    }

}
