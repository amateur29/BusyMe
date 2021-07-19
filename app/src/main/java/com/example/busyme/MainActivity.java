package com.example.busyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        RecyclerView rvMembers = (RecyclerView) findViewById(R.id.rvMembers);

        // Initialize contacts
        members = Member.createContactsList(20);
        // Create adapter passing in the sample user data
        MembersAdapter adapter = new MembersAdapter(members);
        // Attach the adapter to the recyclerview to populate items
        rvMembers.setAdapter(adapter);
        // Set layout manager to position the items
        rvMembers.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
