package com.example.busyme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.busyme.Member;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {
    // Store a member variable for the contacts
    private List<Member> mMembers;

    // Pass in the contact array into the constructor
    public MembersAdapter(ArrayList<Member> members) {
        mMembers = members;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View memberView = inflater.inflate(R.layout.item_member, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(memberView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        Member member = mMembers.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(member.getName());
        Button button = holder.changeStatusButton;
        button.setText(member.getStatus() ? "Message" : "Offline");
        button.setEnabled(member.getStatus());
    }

    @Override
    public int getItemCount() {
        return mMembers.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button changeStatusButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.member_name);
            changeStatusButton = (Button) itemView.findViewById(R.id.change_status);
        }
    }
}