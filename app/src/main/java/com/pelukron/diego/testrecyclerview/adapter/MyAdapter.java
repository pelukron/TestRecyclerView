package com.pelukron.diego.testrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pelukron.diego.testrecyclerview.R;

import java.util.ArrayList;

/**
 * Created by diego on 6/20/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mDataset;
    private LayoutInflater inflater;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.header);
            txtFooter = (TextView) v.findViewById(R.id.footer);
        }
    }

    public void add(int position, String item){
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item){
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(Context context, ArrayList<String> mDataset){
        inflater = LayoutInflater.from(context);
        this.mDataset = mDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_test, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder viewHolder, int i) {
        final String name = mDataset.get(i);
        viewHolder.txtHeader.setText(mDataset.get(i));
        viewHolder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });

        viewHolder.txtFooter.setText("Footer: "+mDataset.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
