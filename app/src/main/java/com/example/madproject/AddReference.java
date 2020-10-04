package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddReference extends AppCompatActivity {


    EditText edtv,eddes;
    TextView adddata;

    String gid,title,des;

    private FirebaseFirestore firestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reference);

        gid=getIntent().getStringExtra("id");



      edtv=findViewById(R.id.editTextTextPersonName);
      eddes=findViewById(R.id.edid);

      adddata=findViewById(R.id.textRegister);

      firestore = FirebaseFirestore.getInstance();


        if(gid!=null)
        {
            title=getIntent().getStringExtra("title");
            des=getIntent().getStringExtra("des");

            eddes.setText(""+des);
            edtv.setText(""+title);


            ReferenceModel rf=new ReferenceModel();
            rf.setId(gid);
            rf.setTitle(title);
            rf.setDescription(des);


        }


        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title=edtv.getText().toString().trim();
                String description=eddes.getText().toString().trim();


                if(title.equals(""))
                {
                    Toast.makeText(AddReference.this, "Enter title", Toast.LENGTH_SHORT).show();
                }else if(description.equals(""))
                {
                    Toast.makeText(AddReference.this, "Enter description", Toast.LENGTH_SHORT).show();

                }else
                {

                    String id=firestore.collection("references").document().getId();

                    ReferenceModel rf=new ReferenceModel();
                    rf.setId(id);
                    rf.setTitle(title);
                    rf.setDescription(description);

                    if(gid!=null)
                    {
                        firestore.collection("references").document(gid).set(rf).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddReference.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddReference.this,ManageReference.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddReference.this, "Try again", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else
                    {
                        firestore.collection("references").document(id).set(rf).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(AddReference.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddReference.this,ManageReference.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddReference.this, "Try again", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }




                }

            }
        });
    }

}
