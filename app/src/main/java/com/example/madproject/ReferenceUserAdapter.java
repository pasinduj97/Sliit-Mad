package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReferenceUserAdapter extends RecyclerView.Adapter<ReferenceUserAdapter.ViewholderReference> {
    private Context mcontext;
    private List<ReferenceModel> mlist;

    public ReferenceUserAdapter(Context mcontext, List<ReferenceModel> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewholderReference onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.reference_item,parent,false);

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

        public ViewholderReference(@NonNull View itemView) {
            super(itemView);

            tvtitle=itemView.findViewById(R.id.titleid);
            tvdescription=itemView.findViewById(R.id.desid);

        }
    }
}
