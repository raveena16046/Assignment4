package com.example.gupta.recyclerlist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anuj on 11/7/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<ToDoItem> mDataset;
    private Context mContext;
    private LayoutInflater mInflater;

    public ViewPagerAdapter(Context context, List<ToDoItem> myDataset) {
        mContext = context;
        mDataset = myDataset;

    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView titleTextview;
        TextView detailTextview;

        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mInflater.inflate(R.layout.viewpager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        titleTextview = (TextView) itemView.findViewById(R.id.show_title_textview);
        detailTextview = (TextView) itemView.findViewById(R.id.show_detail_textview);


        // Capture position and set to the TextViews
        titleTextview.setText((mDataset.get(position)).getTitle());
        detailTextview.setText(mDataset.get(position).getDetail());
        // Add viewpager_item.xml to ViewPager
        (container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}
