package com.example.madproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ReferenceUser extends AppCompatActivity {

    RecyclerView recyclerView;
    ReferenceUserAdapter madapter;
    List<ReferenceModel> mlist;
    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_user);

        recyclerView=findViewById(R.id.recyclerviewid);


        firestore=FirebaseFirestore.getInstance();

        Query query=firestore.collection("references").orderBy("title", Query.Direction.ASCENDING);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mlist=new ArrayList<>();


        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange doc: value.getDocumentChanges())
                {
                    ReferenceModel rf=doc.getDocument().toObject(ReferenceModel.class);

                    mlist.add(rf);
                }

                madapter=new ReferenceUserAdapter(ReferenceUser.this,mlist);

                recyclerView.setAdapter(madapter);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, UserDashboard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}