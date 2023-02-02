package com.creativesky.recyclerviewsample.recyclerviewrequiredparts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.creativesky.recyclerviewsample.R;
import com.creativesky.recyclerviewsample.SecondActivity;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<ListItemModel> listItemList;


    public RecycleViewAdapter(Context context, ArrayList<ListItemModel> listItemList) {

        this.context = context;
        this.listItemList = listItemList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);

        MyViewHolder myViewholder = new MyViewHolder(view);

        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int imageResId = listItemList.get(position).imageResId;
        String title   = listItemList.get(position).title;
        String desc    = listItemList.get(position).desc;

        holder.imageView.setImageResource(imageResId);
        holder.titleTv.setText(title);
        holder.descTv.setText(desc);

        holder.listItemConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", imageResId);
                intent.putExtra("title", title);
                intent.putExtra("desc", desc);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout listItemConstraintLayout;
        ImageView imageView;
        TextView titleTv, descTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemConstraintLayout = itemView.findViewById(R.id.listItemConstraintLayout);

            imageView = itemView.findViewById(R.id.imageView);
            titleTv = itemView.findViewById(R.id.titleTv);
            descTv = itemView.findViewById(R.id.descTv);

        }
    }
}
