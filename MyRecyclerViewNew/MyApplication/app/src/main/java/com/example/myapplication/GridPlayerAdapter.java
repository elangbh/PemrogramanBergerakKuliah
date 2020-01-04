package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridPlayerAdapter extends RecyclerView.Adapter<GridPlayerAdapter.GridViewHolder> {

    private ArrayList<Player> listPlayer;

    public void setOnItemClickCallback(ListPlayerAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ListPlayerAdapter.OnItemClickCallback onItemClickCallback;

    public GridPlayerAdapter(ArrayList<Player> list) {
        this.listPlayer = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_player, viewGroup, false);
        return new GridViewHolder(view);
    }

//    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        final Player player = listPlayer.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listPlayer.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
//        holder.tvName.setText(player.getName());
//        holder.tvDetail.setText(player.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailPage.class);
                intent.putExtra("judul",player.getName());
                intent.putExtra("isi",player.getDetail());
                intent.putExtra("image_url",player.getPhoto());
                holder.itemView.getContext().startActivity(intent);
            }
        });
   }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Player data);

    }
}
