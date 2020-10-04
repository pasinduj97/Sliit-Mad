package com.example.madproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ManageReference extends AppCompatActivity {

    RecyclerView recyclerView;
    AdaapterReferece madapter;
    List<ReferenceModel> mlist;
    FirebaseFirestore firestore;


    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_reference);

        recyclerView=findViewById(R.id.recyclerviewid);
        fab=findViewById(R.id.fabid);

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

                madapter=new AdaapterReferece(ManageReference.this,mlist);

                recyclerView.setAdapter(madapter);

            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intent=new Intent(ManageReference.this,AddReference.class);
                startActivity(intent);

            }
        });



    }
}