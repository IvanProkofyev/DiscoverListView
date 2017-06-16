package com.prokofyev.ivan.discoverlistview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prokofyev.ivan.discoverlistview.databinding.ItemGridBinding;

import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by ivanprok on 16.06.17.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {


    private List<String> headers;
    private Context mContext;

    public ImagesAdapter(Context context, List<String> headers) {
        this.headers = headers;
        mContext = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int randHeight = new Random(System.currentTimeMillis()).nextInt(1000);
        int randWidth = new Random(System.currentTimeMillis()).nextInt(1000);
        Log.d(TAG, "onBindViewHolder: " + randWidth);
        holder.mBinding.header.setText(headers.get(position));
        GlideApp.with(mContext)
                .load("http://lorempixel.com/"+ randWidth+"/"+ randHeight +"/")
                .into(holder.mBinding.imageHolder);
    }

    @Override
    public int getItemCount() {
        return headers != null ? headers.size() : 0;
    }


    class ImageViewHolder extends RecyclerView.ViewHolder {
        private ItemGridBinding mBinding;

        public ImageViewHolder(ItemGridBinding itemBinding) {
            super(itemBinding.getRoot());
            mBinding = itemBinding;
        }

    }
}
