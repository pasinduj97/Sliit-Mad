package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaapterReferece extends RecyclerView.Adapter<AdaapterReferece.ViewholderReference> {
    private Context mcontext;
    private List<ReferenceModel> mlist;
    public Onclicklistener listener;

    public AdaapterReferece(Context mcontext, List<ReferenceModel> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewholderReference onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.referencelayout,parent,false);

        return new ViewholderReference(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderReference holder, int position) {
        ReferenceModel rf=mlist.get(position);

        holder.tvtitle.setText(""+rf.getTitle());
        holder.tvdescription.setText(""+rf.getDescription());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    class ViewholderReference extends RecyclerView.ViewHolder {

        private TextView tvtitle,tvdescription;
        private Button btnedit,btndelete;

        public ViewholderReference(@NonNull View itemView) {
            super(itemView);

            tvtitle=itemView.findViewById(R.id.titleid);
            tvdescription=itemView.findViewById(R.id.desid);

            btnedit=itemView.findViewById(R.id.btn_edit);
            btndelete=itemView.findViewById(R.id.btn_delete);

            btnedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.update(position);
                        }
                    }
                }
            });

            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.delete(position);
                        }
                    }
                }
            });



        }
    }

    public interface Onclicklistener
    {
        void delete(int position);
        void update(int position);
    }

    public void setOnitemclicklistener(Onclicklistener mlistener)
    {
        listener=mlistener;
    }
}
