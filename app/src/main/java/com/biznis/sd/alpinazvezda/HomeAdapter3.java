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


public class HomeAdapter3 extends RecyclerView.Adapter<HomeAdapter3.ImageViewHolder> {

    Context mContext;
    private List<Artikal> mdata;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public HomeAdapter3(Context mContext, List<Artikal> mdata, OnItemClickListener listener) {
        this.mContext = mContext;
        this.mdata = mdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item3, parent, false);
        return new ImageViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.ivMainImage.setImageResource(mdata.get(position).getImg());
        holder.tvTnaziv.setText(mdata.get(position).getNaziv());
        holder.tvTgrupa.setText(mdata.get(position).getPodgrupa());
        holder.tvTcena.setText(mdata.get(position).getCena()+"0 din");
    }

    @Override
    public int getItemCount() {
        return ArtikalProvider.getArtikle().size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMainImage;
        TextView tvTnaziv,tvTgrupa,tvTcena;

        public ImageViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            ivMainImage=itemView.findViewById(R.id.ivMainImage);
            tvTnaziv=itemView.findViewById(R.id.tvTnaziv);
            tvTgrupa=itemView.findViewById(R.id.tvTgrupa);
            tvTcena=itemView.findViewById(R.id.tvTcena);

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