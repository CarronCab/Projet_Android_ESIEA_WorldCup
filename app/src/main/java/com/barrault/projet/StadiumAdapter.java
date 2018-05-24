package com.barrault.projet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.master.glideimageview.GlideImageView;

import org.json.JSONArray;
import org.json.JSONException;


public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumHolder>  {

    private JSONArray worldcup;

    StadiumAdapter(JSONArray worldcup){
        this.worldcup=worldcup;
    }

    @NonNull
    @Override
    public StadiumAdapter.StadiumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lI = LayoutInflater.from(parent.getContext());
        View view = lI.inflate(R.layout.rv_stadium_element,parent,false);
        return new StadiumAdapter.StadiumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StadiumAdapter.StadiumHolder holder, final int position) {
        try {
            holder.name.setText( worldcup.getJSONObject(position).getString("name"));
            holder.id.setText( worldcup.getJSONObject(position).getString("id"));
            holder.city.setText( worldcup.getJSONObject(position).getString("city"));
            final String lat = worldcup.getJSONObject(position).getString("lat");
            final String lng = worldcup.getJSONObject(position).getString("lng");
            final String id_stade = worldcup.getJSONObject(position).getString("id");
            holder.image.loadImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/900px-Flag_of_Russia.png");
            holder.bt_map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context=view.getContext();
                    Uri geo = Uri.parse("geo:" + lat + ", " + lng);
                    Intent i = new Intent(Intent.ACTION_VIEW, geo);
                    context.startActivity(i);

                }
            });

/*
            switch(id_stade){
                case "0":
                    holder.image.loadImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/900px-Flag_of_Russia.png");
                    break;
                case "1":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "2":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "3":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "4":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "5":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "6":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "7":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "8":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "9":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "10":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
                case "11":
                    holder.image.loadImageUrl("https://en.wikipedia.org/wiki/Krestovsky_Stadium#/media/File:Spb_06-2017_img40_Krestovsky_Stadium.jpg");
                    break;
            }

*/

            holder.bt_wiki.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context=view.getContext();

                    switch(id_stade){
                        case "12":
                            Uri link = Uri.parse("https://en.wikipedia.org/wiki/Central_Stadium_(Yekaterinburg)");
                            Intent i = new Intent(Intent.ACTION_VIEW, link);
                            context.startActivity(i);
                            break;
                        case "1":
                            Uri link2 = Uri.parse("https://en.wikipedia.org/wiki/Luzhniki_Stadium");
                            Intent i2 = new Intent(Intent.ACTION_VIEW, link2);
                            context.startActivity(i2);
                            break;
                        case "2":
                            Uri link3 = Uri.parse("https://en.wikipedia.org/wiki/Otkrytie_Arena");
                            Intent i3 = new Intent(Intent.ACTION_VIEW, link3);
                            context.startActivity(i3);
                            break;
                        case "3":
                            Uri link4 = Uri.parse("https://en.wikipedia.org/wiki/Krestovsky_Stadium");
                            Intent i4 = new Intent(Intent.ACTION_VIEW, link4);
                            context.startActivity(i4);
                            break;
                        case "4":
                            Uri link5 = Uri.parse("https://en.wikipedia.org/wiki/Kaliningrad_Stadium");
                            Intent i5 = new Intent(Intent.ACTION_VIEW, link5);
                            context.startActivity(i5);
                            break;
                        case "5":
                            Uri link6 = Uri.parse("https://en.wikipedia.org/wiki/Kazan_Arena");
                            Intent i6 = new Intent(Intent.ACTION_VIEW, link6);
                            context.startActivity(i6);
                            break;
                        case "6":
                            Uri link7 = Uri.parse("https://en.wikipedia.org/wiki/Nizhny_Novgorod_Stadium");
                            Intent i7 = new Intent(Intent.ACTION_VIEW, link7);
                            context.startActivity(i7);
                            break;
                        case "7":
                            Uri link8 = Uri.parse("https://en.wikipedia.org/wiki/Cosmos_Arena");
                            Intent i8 = new Intent(Intent.ACTION_VIEW, link8);
                            context.startActivity(i8);
                            break;
                        case "8":
                            Uri link9 = Uri.parse("https://en.wikipedia.org/wiki/Volgograd_Arena");
                            Intent i9 = new Intent(Intent.ACTION_VIEW, link9);
                            context.startActivity(i9);
                            break;
                        case "9":
                            Uri link10 = Uri.parse("https://en.wikipedia.org/wiki/Mordovia_Arena");
                            Intent i10 = new Intent(Intent.ACTION_VIEW, link10);
                            context.startActivity(i10);
                            break;
                        case "10":
                            Uri link11 = Uri.parse("https://en.wikipedia.org/wiki/Rostov_Arena");
                            Intent i11 = new Intent(Intent.ACTION_VIEW, link11);
                            context.startActivity(i11);
                            break;
                        case "11":
                            Uri link12 = Uri.parse("https://en.wikipedia.org/wiki/Fisht_Olympic_Stadium");
                            Intent i12 = new Intent(Intent.ACTION_VIEW, link12);
                            context.startActivity(i12);
                            break;

                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if( worldcup != null) {
            return  worldcup.length();
        }
        else{
            return 0;
        }
    }

    public class StadiumHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView id;
        TextView city;
        Button bt_map;
        Button bt_wiki;
        public GlideImageView image;
        StadiumHolder(View view) {
            super(view);
            this.name= view.findViewById(R.id.rv_stadium_element_name);
            this.id= view.findViewById(R.id.rv_stadium_element_id);
            this.city= view.findViewById(R.id.rv_stadium_element_city);
            this.bt_map= view.findViewById(R.id.rv_stadium_element_button);
            this.bt_wiki= view.findViewById(R.id.rv_stadium_element_wiki);
            this.image = view.findViewById(R.id.rv_stadium_element_image);
        }
    }

    public void setNewWorldCup(JSONArray newWorldCup){
        this. worldcup=newWorldCup;
        notifyDataSetChanged();
        Log.d("TAG", String.valueOf(getItemCount()));
    }
}