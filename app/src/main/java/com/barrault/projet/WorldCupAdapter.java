package com.barrault.projet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.master.glideimageview.GlideImageView;

import org.json.JSONArray;
import org.json.JSONException;

public class WorldCupAdapter extends RecyclerView.Adapter<WorldCupAdapter.WorldCupHolder> {

    private JSONArray worldcup;
    WorldCupAdapter(JSONArray worldcup){
        this.worldcup=worldcup;
    }


    @NonNull
    @Override
    public WorldCupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lI = LayoutInflater.from(parent.getContext());
        View view = lI.inflate(R.layout.rv_world_cup_element,parent,false);
        return new WorldCupHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldCupHolder holder, int position) {
        try {

            holder.name.setText( worldcup.getJSONObject(position).getString("name"));
            holder.iso.setText( worldcup.getJSONObject(position).getString("iso2"));
            holder.flag.loadImageUrl(worldcup.getJSONObject(position).getString("flag"));
            holder.code.setText(worldcup.getJSONObject(position).getString("fifaCode"));
            holder.id.setText(worldcup.getJSONObject(position).getString("id"));
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

    public class WorldCupHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView iso;
        GlideImageView flag;
        public TextView code;
        public TextView id;
        WorldCupHolder(View view) {
            super(view);
            this.name= view.findViewById(R.id.rv_world_cup_element_name);
            this.iso= view.findViewById(R.id.rv_world_cup_element_iso);
            this.flag = view.findViewById(R.id.rv_world_cup_element_flag);
            this.code= view.findViewById(R.id.rv_world_cup_element_fifa_code);
            this.id= view.findViewById(R.id.rv_world_cup_element_id);
        }
    }

    public void setNewWorldCup(JSONArray newWorldCup){
        this. worldcup=newWorldCup;
        notifyDataSetChanged();
        Log.d("TAG", String.valueOf(getItemCount()));
    }


}
