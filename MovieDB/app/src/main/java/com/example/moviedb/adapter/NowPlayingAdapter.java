package com.example.moviedb.adapter;

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

import com.bumptech.glide.Glide;
import com.example.moviedb.R;
import com.example.moviedb.helper.Const;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.view.MovieDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.CardViewViewHolder>{
private Context contex;
private List<NowPlaying.Results> ListNowPlaying;
private List<NowPlaying.Results> getListNowPlaying(){
    return ListNowPlaying;
}
public void setListNowPlaying(List<NowPlaying.Results>ListNowPlaying){
    this.ListNowPlaying=ListNowPlaying;
}
public NowPlayingAdapter(Context contex){
    this.contex=contex;
}

    @NonNull
    @Override
    public NowPlayingAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing,parent, false);
    return new NowPlayingAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingAdapter.CardViewViewHolder holder, int position) {
final NowPlaying.Results results=getListNowPlaying().get(position);
holder.lbl_title.setText(results.getTitle());
holder.lbl_overview.setText(results.getOverview());
holder.lbl_release_date.setText(results.getRelease_date());
Glide.with(contex).load(Const.IMG_URL+ results.getPoster_path()).into(holder.img_poster);
holder.cv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent (contex, MovieDetailsActivity.class);
        intent.putExtra("movie_id",""+results.getId());
      //  intent.putExtra("movie_title",""+results.getTitle());
        //intent.putExtra("movie_overview",""+results.getOverview());
        //intent.putExtra("movie_release_date",""+results.getRelease_date());
        //intent.putExtra("movie_gambar",""+results.getPoster_path());
        contex.startActivity(intent);
    }
});
}

    @Override
    public int getItemCount() {
        return getListNowPlaying().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
    ImageView img_poster;
    TextView lbl_title,lbl_overview,lbl_release_date;
    CardView cv;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            img_poster=itemView.findViewById((R.id.img_poster_card_nowplaying));
            lbl_title=itemView.findViewById(R.id.lbl_title_card_nowplaying);
            lbl_overview=itemView.findViewById(R.id.lbl_overview_card_nowplaying);
            lbl_release_date=itemView.findViewById(R.id.lbl_releasdate_card_nowplaying);
            cv=itemView.findViewById(R.id.cv_card_nowplaying);
        }
    }
}
