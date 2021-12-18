package com.example.hamoudApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamoudApp.R;
import com.example.hamoudApp.models.workersChecker;

import java.util.ArrayList;

public class wCheckersAdapter extends RecyclerView.Adapter<wCheckersAdapter.ViewHolder>{
    private ArrayList<workersChecker> myWorkersLists;
    private Context context;
    checkWorkerListener mcheckWorkerListener ;
    View view;

    ArrayList<String> arrayContainer = new ArrayList<>();

    public wCheckersAdapter(ArrayList<workersChecker> myWorkersLists, Context context, checkWorkerListener mcheckWorkerListener) {
        this.myWorkersLists = myWorkersLists;
        this.context = context;
        this.mcheckWorkerListener = mcheckWorkerListener;
    }

    public View getView(){
        return view ;
    }

    @NonNull
    @Override
    public wCheckersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.workercheck,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wCheckersAdapter.ViewHolder holder, int position) {
        workersChecker myList=myWorkersLists.get(position);
        holder.workerText.setText(myList.getUsername());
        holder.phone.setText(myList.getPhone());
        if (myWorkersLists != null && myWorkersLists.size() > 0){
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.checkBox.isChecked()){
                        arrayContainer.add(myList.getUsername());
                    }else {
                        arrayContainer.remove(myList.getUsername());
                    }
                    mcheckWorkerListener.onnbrChange(arrayContainer);
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return myWorkersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView workerText;
        private TextView phone ;
        private CheckBox checkBox ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workerText = (TextView) itemView.findViewById(R.id.workerText);
            phone = (TextView) itemView.findViewById(R.id.phoneText);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
