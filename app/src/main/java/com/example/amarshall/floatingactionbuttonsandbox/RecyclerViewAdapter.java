package com.example.amarshall.floatingactionbuttonsandbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * This adapter will show all the Phone Numbers and EmailAddresses for the Contact
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private GroupClickListener clickListener;

    /**
     * The Phone Numbers of the Contact in order of Valid to Invalid contacts.
     */
    private ArrayList<String> groups = new ArrayList<>();


    public interface GroupClickListener {
        void onGroupClicked(String group);
    }

    public RecyclerViewAdapter(List<String> groups_in, GroupClickListener clickListener) {
        this.clickListener = clickListener;

        this.groups = new ArrayList<>(groups_in);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View groupTextView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new GroupViewHolder(groupTextView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        GroupViewHolder contactDetailsViewHolder = (GroupViewHolder) holder;

        TextView contactDetailsView = contactDetailsViewHolder.groupTextView;

        contactDetailsView.setText(groups.get(holder.getAdapterPosition()));

        contactDetailsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onGroupClicked(groups.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {

        return groups.size();
    }

    //********************************************************************
    //********************** View Holders Below **************************
    //********************************************************************

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView groupTextView;

        GroupViewHolder(View itemView) {
            super(itemView);

            groupTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
