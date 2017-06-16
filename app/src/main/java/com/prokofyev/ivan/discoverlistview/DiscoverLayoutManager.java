package com.prokofyev.ivan.discoverlistview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ivanprok on 16.06.17.
 */

public class DiscoverLayoutManager extends GridLayoutManager {
    private enum WidthType {SMALL, MEDIUM, LARGE}

    private Context mContext;

    public DiscoverLayoutManager(Context context, int defStyleRes) {
        super(context, defStyleRes);
        mContext = context;
        setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                WidthType widthType = determineWidth(position);

                switch (widthType) {
                    case SMALL:
                        return 2;
                    case MEDIUM:

                        return 3;
                    case LARGE:

                        return 4;
                    default:
                        return 0;
                }
            }
        });
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    private WidthType determineWidth(int position) {
//        View view = getChildAt(position);
//        int height = view.getHeight();
//        int width = view.getWidth();

//        if(height )
        switch (position % 3) {
            case 1:
                return WidthType.SMALL;
            case 2:
                return WidthType.MEDIUM;
            case 0:
            default:
                return WidthType.LARGE;
        }
    }
}
