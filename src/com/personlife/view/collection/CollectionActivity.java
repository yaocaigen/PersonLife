package com.personlife.view.collection;

import java.util.ArrayList;
import java.util.List;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.personlifep.R;
import com.personlife.adapter.ViewPagerTabAdapter;
import com.personlife.bean.App;
import com.personlife.bean.User;
import com.personlife.widget.CircleImageView;
import com.personlife.widget.PagerSlidingTabStrip;

public class CollectionActivity extends FragmentActivity implements
		OnClickListener {
	private TextView mTitle;
	private Button mBack;
	private Button mEdit;
	private RelativeLayout layout_bottom;
	private ImageView mDelete;
	CircleImageView staricon;
	TextView starname, signature, tabviews[];
	ViewPager pager;
	ViewPagerTabAdapter adapter;
	PagerSlidingTabStrip tabs;
	LinearLayout view;
	CharSequence Titles[] = { "分享收藏", "APP收藏", "关注明星" };
	ColorStateList colors[];
	Fragment fragments[];
	CollectionSharesFragment sharesfragment;
	CollectionAppsFragment appsfragment;
	CollectionStarsFragment starsfragment;
	int lastTab = 0;
	int currentTab = 0;
	List<App> mApps;
	List<User> mStars;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		mBack = (Button) findViewById(R.id.txt_left);
		mBack.setVisibility(View.VISIBLE);
		mBack.setOnClickListener(this);
		mTitle = (TextView) findViewById(R.id.txt_title);
		mTitle.setText("我的收藏");
		mEdit = (Button) findViewById(R.id.txt_save);
		mEdit.setVisibility(View.VISIBLE);
		mEdit.setText("编辑");
		mEdit.setOnClickListener(this);
		layout_bottom = (RelativeLayout) findViewById(R.id.rl_collection_bottom);
		mDelete = (ImageView) findViewById(R.id.iv_collection_delete);
		mDelete.setOnClickListener(this);

		sharesfragment = new CollectionSharesFragment();

		mApps = new ArrayList<App>();
		mApps.add(new App("飞帅"));
		mApps.add(new App("徐飞"));
		mApps.add(new App("刘刚"));
		mApps.add(new App("大伟"));
		mApps.add(new App("威少"));
		mApps.add(new App("赵朗"));
		mApps.add(new App("徐总"));
		mApps.add(new App("伟哥"));

		appsfragment = new CollectionAppsFragment(mApps);

		mStars = new ArrayList<User>();
		mStars.add(new User());
		mStars.add(new User());
		mStars.add(new User());
		mStars.add(new User());
		
		starsfragment = new CollectionStarsFragment(mStars);

		fragments = new Fragment[] { sharesfragment, appsfragment,
				starsfragment };
		// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles
		// fot the Tabs and Number Of Tabs.
		adapter = new ViewPagerTabAdapter(getSupportFragmentManager(), Titles,
				fragments);
		// Assigning ViewPager View and setting the adapter
		pager = (ViewPager) findViewById(R.id.pager_collection);
		pager.setAdapter(adapter);

		// Assiging the Sliding Tab Layout View
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs_collection);

		// Setting the ViewPager For the SlidingTabsLayout
		tabs.setViewPager(pager);

		tabs.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.i("selected tab", "" + arg0);
				currentTab = arg0;
				switch (arg0) {
				case 0:
					tabviews[arg0].setTextColor(colors[0]);
					tabviews[2 - arg0].setTextColor(colors[1]);
					tabviews[1 - arg0].setTextColor(colors[1]);
					break;
				case 1:
					tabviews[arg0].setTextColor(colors[0]);
					tabviews[arg0 - 1].setTextColor(colors[1]);
					tabviews[arg0 + 1].setTextColor(colors[1]);
					break;
				case 2:
					tabviews[arg0].setTextColor(colors[0]);
					tabviews[arg0 - 1].setTextColor(colors[1]);
					tabviews[arg0 - 2].setTextColor(colors[1]);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		initData();
	}

	public void initData() {
		view = (LinearLayout) tabs.getChildAt(0);

		tabviews = new TextView[3];
		colors = new ColorStateList[2];

		colors[0] = getResources().getColorStateList(R.color.bg);
		colors[1] = getResources().getColorStateList(R.color.black);
		tabviews[0] = (TextView) view.getChildAt(0);
		tabviews[0].setTextColor(colors[0]);
		tabviews[1] = (TextView) view.getChildAt(1);
		tabviews[1].setTextColor(colors[1]);
		tabviews[2] = (TextView) view.getChildAt(2);
		tabviews[2].setTextColor(colors[1]);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.txt_left:
			finish();
			break;
		case R.id.txt_save:
			lastTab = currentTab;
			layout_bottom.setVisibility(View.VISIBLE);
			mEdit.setVisibility(View.GONE);
			if (currentTab == 0) {
				
			}

			if (currentTab == 1) {
				appsfragment.setDeleteMode();
			}

			if (currentTab == 2) {
				starsfragment.setDeleteMode();
			}
			break;
		case R.id.iv_collection_delete:
			layout_bottom.setVisibility(View.GONE);
			mEdit.setVisibility(View.VISIBLE);
			if (lastTab == 0) {

			}

			if (lastTab == 1) {
				appsfragment.setNormalMode();
			}

			if (lastTab == 2) {
				starsfragment.setNormalMode();
			}
			break;
		}
	}

}