package com.biznis.sd.alpinazvezda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ImageViewHolder> {

    Context mContext;
    private List<Row> mdata;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public HomeAdapter2(Context mContext, List<Row> mdata, OnItemClickListener listener) {
        this.mContext = mContext;
        this.mdata = mdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item2, parent, false);
        return new ImageViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.ivMainImage.setImageResource(mdata.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMainImage;

        public ImageViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            ivMainImage=itemView.findViewById(R.id.ivMainImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}