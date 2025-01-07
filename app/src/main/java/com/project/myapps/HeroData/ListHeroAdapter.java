package com.project.myapps.HeroData;

import static android.view.Gravity.apply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.project.myapps.R;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<HeroClass>listhero;

    public ListHeroAdapter(ArrayList<HeroClass>list){
        this.listhero=list;
    }
    @NonNull
    @Override
    public ListHeroAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdapter.ListViewHolder holder, int position) {
        HeroClass hero=listhero.get(position);
        Glide.with(holder.itemView.getContext())
                        .load(hero.getFoto())
        .apply(new RequestOptions().override(55, 55))
                .into(holder.imagePhoto);
        holder.tvName.setText(hero.getNama());
        holder.tvDetail.setText(hero.getDetail());
    }
    @Override
    public int getItemCount() {
        return listhero.size();
    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePhoto;
        TextView tvName, tvDetail;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto= itemView.findViewById(R.id.img_item_photo);
            tvName= itemView.findViewById(R.id.tv_item_name);
            tvDetail=itemView.findViewById(R.id.tv_item_detail);

        }
    }
}
