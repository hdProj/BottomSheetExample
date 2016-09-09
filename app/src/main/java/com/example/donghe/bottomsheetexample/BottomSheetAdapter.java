package com.example.donghe.bottomsheetexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dong.he on 2016/9/6.
 */
public class BottomSheetAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public BottomSheetAdapter(Context context) {
        mContext = context;
    }

    MyItemClickListener itemClickListener = new MyItemClickListener() {
        @Override
        public void onItemClick(View view, int postion) {
            Toast.makeText(mContext, postion + "", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new BottomSheetViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof BottomSheetViewHolder) {
            BottomSheetViewHolder viewHolder = (BottomSheetViewHolder) holder;
            viewHolder.tvItem.setText(position + "item");
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class BottomSheetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tv_item)
        TextView tvItem;

        private MyItemClickListener mListener;

        public BottomSheetViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mListener = listener;
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view, getPosition());
            }
        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int postion);
    }

}
