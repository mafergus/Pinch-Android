package com.pinch.android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinch.android.model.Cause;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewferguson on 6/15/16.
 */

public class CausesAdapter extends RecyclerView.Adapter<CausesAdapter.ViewHolder> {
    private Context context;
    private List<Cause> causes = new ArrayList<>();

    public CausesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CausesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cause, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CausesAdapter.ViewHolder holder, int position) {
        Cause cause = causes.get(position);
        holder.populate(context, cause);
    }

    @Override
    public int getItemCount() {
        return causes.size();
    }

    public void setCauses(List<Cause> causes) {
        this.causes.clear();
        this.causes.addAll(causes);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private View rootView;
        private ImageView causeImage;
        private TextView title;
        private TextView text;
        private TextView circles;
        private TextView events;
        private TextView raised;

        public ViewHolder(View view) {
            super(view);

            this.rootView = view;
            this.causeImage = (ImageView)view.findViewById(R.id.causeImage);
            this.title = (TextView)view.findViewById(R.id.title);
            this.text = (TextView)view.findViewById(R.id.text);
            this.circles = (TextView)view.findViewById(R.id.circles);
            this.events = (TextView)view.findViewById(R.id.events);
            this.raised = (TextView)view.findViewById(R.id.raised);
        }

        public void populate(Context context, Cause cause) {
            Picasso.with(context).load(cause.leadingImage).into(this.causeImage);
            this.title.setText(cause.title);
            this.text.setText(cause.detail);
        }

    }
}
