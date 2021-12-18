package com.example.hamoudApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamoudApp.R;
import com.example.hamoudApp.models.MyList;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyList> myListList;
    private Context ct;
    private OnBoxListener mOnBoxListener;

    public MyAdapter(List<MyList> myListList, Context ct , OnBoxListener onBoxListener) {
        this.myListList = myListList;
        this.ct = ct;
        this.mOnBoxListener=onBoxListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element,parent,false);

        return new ViewHolder(view , mOnBoxListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyList myList=myListList.get(position);
        holder.imageView.setImageDrawable(ct.getResources().getDrawable(myList.getImage()));

    }

    @Override
    public int getItemCount() {
        return myListList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        OnBoxListener onBoxListener ;
        public ViewHolder(@NonNull View itemView, OnBoxListener onBoxListener) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.myimage);
            this.onBoxListener = onBoxListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onBoxListener.onBoxClick(getAdapterPosition());
        }
    }
    public interface OnBoxListener{
        void onBoxClick(int position);
    }
}

