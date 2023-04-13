package com.ahmed.test2sqldatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.studentViewHolder> {
    Context context;
    ArrayList<student> StudentArrayList ;

    public studentAdapter(Context context, ArrayList<student> studentArrayList) {
        this.context = context;
        StudentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public studentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.studentlayout, null);
        return  new studentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull studentViewHolder holder, int position) {
        student studentobject= StudentArrayList.get(position);
        holder.nameET.setText(studentobject.getName());
        holder.addressET.setText(studentobject.getAddress());
        holder.phoneET.setText(studentobject.getPhone());
        holder.stuedntImage.setImageResource(studentobject.getImage());
        holder.studentRate.setRating(studentobject.getRate());




    }

    @Override
    public int getItemCount() {
        return StudentArrayList.size();
    }

    public class studentViewHolder extends RecyclerView.ViewHolder{
        TextView nameET, addressET, phoneET;
        CircleImageView stuedntImage;
        RatingBar studentRate;
        public studentViewHolder(@NonNull View itemView) {
            super(itemView);


            nameET=itemView.findViewById(R.id.studentName);
            addressET=itemView.findViewById(R.id.studentAddress);
            phoneET=itemView.findViewById(R.id.studentPhone);
            stuedntImage=itemView.findViewById(R.id.studentImage);
            studentRate=itemView.findViewById(R.id.studentRate);




        }
    }
}
