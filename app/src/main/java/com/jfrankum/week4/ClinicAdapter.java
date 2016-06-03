package com.jfrankum.week4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ClinicAdapter extends ArrayAdapter<String> {

    long[] clinicIds = {};
    String[] titles = {};
    String[] names = {};
    String[] statuses = {};
    String[] lats = {};
    String[] lons = {};
    Context context;
    LayoutInflater inflater;

    public ClinicAdapter(Context context, long[] clinicIds, String[] titles, String[] names,
                         String[] statuses, String[] lats, String[] lons) {
        super(context, R.layout.results_item, names);
        this.context = context;
        this.clinicIds = clinicIds;
        this.names = names;
        this.titles = titles;
        this.statuses = statuses;
        this.lats = lats;
        this.lons = lons;
    }

    public class ViewHolder {
        TextView idsTv;
        TextView titlesTv;
        TextView namesTv;
        TextView statusesTv;
        TextView latsTv;
        TextView lonsTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.results_item, null);
        }

        final ViewHolder holder = new ViewHolder();
        holder.idsTv = (TextView) convertView.findViewById(R.id.itemId);
        holder.idsTv.setText(Long.toString(clinicIds[position]));

        holder.titlesTv = (TextView) convertView.findViewById(R.id.itemTitle);
        holder.titlesTv.setText(titles[position]);

        holder.namesTv = (TextView) convertView.findViewById(R.id.itemName);
        holder.namesTv.setText(names[position]);

        holder.statusesTv = (TextView) convertView.findViewById(R.id.itemStatus);
        holder.statusesTv.setText(statuses[position]);

        holder.latsTv = (TextView) convertView.findViewById(R.id.itemLat);
        holder.latsTv.setText(lats[position]);

        holder.lonsTv = (TextView) convertView.findViewById(R.id.itemLon);
        holder.lonsTv.setText(lons[position]);

        return convertView;
    }
}
