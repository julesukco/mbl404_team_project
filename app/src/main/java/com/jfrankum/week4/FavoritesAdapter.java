package com.jfrankum.week4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FavoritesAdapter extends ArrayAdapter<String> {

    long[] favoritesIds = {};
    String[] names = {};
    String[] locations = {};
    String[] statuses = {};
    Context context;
    LayoutInflater inflater;

    public FavoritesAdapter(Context context, long[] favoritesIds, String[] names, String[] locations,
                            String[] statuses) {
        super(context, R.layout.results_item, names);
        this.context = context;
        this.favoritesIds = favoritesIds;
        this.names = names;
        this.locations = locations;
        this.statuses = statuses;
    }

    public class ViewHolder {
        TextView typeTv;
        TextView paramTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.favorites_item, null);
        }

        final ViewHolder holder = new ViewHolder();
        holder.typeTv = (TextView) convertView.findViewById(R.id.txtSearchType);
        holder.paramTv = (TextView) convertView.findViewById(R.id.txtSearchParam);

        if (names[position] != null && !names[position].equals("")) {
            holder.typeTv.setText("name");
            holder.paramTv.setText(names[position]);
        } else if (locations[position] != null && !locations[position].equals("")) {
            holder.typeTv.setText("location");
            holder.paramTv.setText(locations[position]);
        } else if (statuses[position] != null && !statuses[position].equals("")) {
            holder.typeTv.setText("status");
            holder.paramTv.setText(statuses[position]);
        }

        return convertView;
    }
}

