package com.example.hamoudApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamoudApp.R;
import com.example.hamoudApp.models.myTaskModelList;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<myTaskModelList>myTaskLists;
    private Context context;
    private OnTaskListener mOnTaskListener;

    public TaskAdapter(List<myTaskModelList> myLists, Context context, OnTaskListener onTaskListener) {
        this.myTaskLists = myLists;
        this.context = context;
        this.mOnTaskListener = onTaskListener ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.taskelement,parent,false);

        return new ViewHolder(view , mOnTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        myTaskModelList myList=myTaskLists.get(position);
        holder.textView.setText(myList.getDesc());
        holder.img.setImageDrawable(context.getResources().getDrawable(myList.getImage()));
        holder.dateText.setText(myList.getdateText());
        holder.timeText.setText(myList.gettimeText());
    }

    @Override
    public int getItemCount() {
        return myTaskLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView textView;
        private TextView dateText ;
        private  TextView timeText ;
        OnTaskListener onTaskListener;
        public ViewHolder(@NonNull View itemView , OnTaskListener onTaskListener) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.image);
            textView=(TextView)itemView.findViewById(R.id.desc);
            dateText = (TextView) itemView.findViewById(R.id.dateText);
            timeText = (TextView) itemView.findViewById(R.id.timeText);
            this.onTaskListener=onTaskListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition());
        }
    }
    public interface OnTaskListener{
        void onTaskClick(int position);
    }
}