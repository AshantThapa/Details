package com.m.details.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.m.details.R;
import com.m.details.model.UserDetail;

import java.util.List;

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailAdapter.UserDetailViewHolder> {
    Context context;


    List<UserDetail> userDetailList;


    public UserDetailAdapter(Context context, List<UserDetail> userDetailList) {
        this.context = context;
        this.userDetailList = userDetailList;
    }

    @NonNull
    @Override
    public UserDetailAdapter.UserDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userview, parent, false);
        return new UserDetailViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull UserDetailAdapter.UserDetailViewHolder holder, int position) {
        final UserDetail userDetail = userDetailList.get(position);



        int image_id = userDetail.getImageId();
        int age = userDetail.getAge();

        holder.ivImage.setImageResource(image_id);
        holder.tvName.setText(userDetail.getName().toString());
        holder.tvAge.setText(String.valueOf(age));
        holder.tvGender.setText(userDetail.getGender().toString());
        //holder.ivImage.setImageResource(2131099747);

    }

    @Override
    public int getItemCount() {
        return userDetailList.size();
    }


    public  class UserDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvName, tvGender, tvAge;
        Button btndelete;


        public UserDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            btndelete = itemView.findViewById(R.id.btndelete);
        }



    }

}