package com.n0hands.todoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.n0hands.todoapp.model.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>  {
    private List<Category> categories;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView
                title,
                description;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.category_name);
            description = (TextView) view.findViewById(R.id.category_description);
            image = (ImageView) view.findViewById(R.id.category_image);
        }
    }


    public CategoriesAdapter(java.util.List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public CategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_row, parent, false);

        return new CategoriesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.MyViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.title.setText(category.getName());
        holder.description.setText(category.getDescription());
        holder.image.setImageResource(R.mipmap.ic_launcher); // FIXME: fix this
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
