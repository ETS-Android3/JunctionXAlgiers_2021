package com.example.hamoudApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamoudApp.R;

import com.example.hamoudApp.models.myWorkersList;

import java.util.List;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.ViewHolder> {
    private List<myWorkersList> myWorkersLists;
    private Context context;

    public WorkerAdapter(List<myWorkersList> myLists, Context context) {
        this.myWorkersLists = myLists;
        this.context = context;
    }

    @NonNull
    @Override
    public WorkerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.workerelement,parent,false);
        return new WorkerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerAdapter.ViewHolder holder, int position) {
        myWorkersList myList=myWorkersLists.get(position);
        holder.workerText.setText(myList.getWorkerText());
        holder.stateText.setText(myList.getStateText());
    }

    @Override
    public int getItemCount() {
        return myWorkersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView workerText;
        private TextView stateText ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workerText = (TextView) itemView.findViewById(R.id.workerText);
            stateText = (TextView) itemView.findViewById(R.id.stateText);
        }
    }
}