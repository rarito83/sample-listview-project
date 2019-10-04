package com.rarito.tenuclfootballclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClubAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Club> footballClub;

    public void setFootballClub(ArrayList<Club> footballClub) {
        this.footballClub = footballClub;
    }

    public ClubAdapter(Context context) {
        this.context = context;
        footballClub = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return footballClub.size();
    }

    @Override
    public Object getItem(int i) {
        return footballClub.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_club, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Club footballClub = (Club) getItem(i);
        viewHolder.bind(footballClub);
        return itemView;
    }

    public class ViewHolder {
        private TextView txtClubName;
        private TextView txtDescription;
        private ImageView imgClubLogo;

        ViewHolder(View view) {
            imgClubLogo = view.findViewById(R.id.club_logo);
            txtClubName = view.findViewById(R.id.club_name);
            txtDescription = view.findViewById(R.id.club_description);
        }

        void bind(Club footballClub) {
            imgClubLogo.setImageResource(footballClub.getLogo());
            txtClubName.setText(footballClub.getNameClub());
            txtDescription.setText(footballClub.getDescription());
        }
    }
}
