package com.jillandee.card;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData){
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.txt_anime_title.setText(mData.get(position).getTitle());
        holder.img_anime_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Anime_Activity.class);

                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Genre", mData.get(position).getGenre());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());

                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_anime_title;
        ImageView img_anime_thumbnail;
        CardView cardView;
        Context context;
        List<Anime> data;


        public MyViewHolder(View itemView){
            super(itemView);

            txt_anime_title = (TextView) itemView.findViewById(R.id.title_id_asuna);
            img_anime_thumbnail = (ImageView) itemView.findViewById(R.id.img_id_asuna);
            cardView= (CardView) itemView.findViewById(R.id.cardview);
            itemView.setOnClickListener(this);
            this.context = context;
            this.data = data;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("URL_NAME", data.get(getAdapterPosition()).getHref());
            context.startActivity(intent);
        }
    }


}
