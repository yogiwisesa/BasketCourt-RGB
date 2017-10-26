package com.rubydev.basketcourtrgb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yogi Wisesa on 10/26/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private List<Score> list = new ArrayList<>();

    public HistoryAdapter(Context context, List<Score> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, final int position) {
        holder.tvScoreA.setText(String.valueOf(list.get(position).getScoreA()));
        holder.tvScoreB.setText(String.valueOf(list.get(position).getScoreB()));
        holder.tvTeamA.setText(list.get(position).getTeamA());
        holder.tvTeamB.setText(list.get(position).getTeamB());
        holder.tvTanggal.setText(list.get(position).getTanggal());
        String pertandingan = list.get(position).getTeamA() + " VS " + list.get(position).getTeamB();
        holder.tvPertandingan.setText(pertandingan);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvScoreA, tvScoreB, tvTeamA, tvTeamB, tvTanggal, tvPertandingan;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvScoreA = (TextView) itemView.findViewById(R.id.tvScoreA);
            tvScoreB = (TextView) itemView.findViewById(R.id.tvScoreB);
            tvTeamA = (TextView) itemView.findViewById(R.id.tvTeamA);
            tvTeamB = (TextView) itemView.findViewById(R.id.tvTeamB);
            tvTanggal = (TextView) itemView.findViewById(R.id.tvTanggal);
            tvPertandingan = (TextView) itemView.findViewById(R.id.tvPertandingan);
        }

        @Override
        public void onClick(View view) {
            // kalau mau onclick
        }

    }

}