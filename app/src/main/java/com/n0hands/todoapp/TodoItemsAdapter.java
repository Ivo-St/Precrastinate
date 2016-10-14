package com.n0hands.todoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n0hands.todoapp.model.TodoItem;

import java.util.List;

class TodoItemsAdapter extends RecyclerView.Adapter<TodoItemsAdapter.MyViewHolder> {

    private List<TodoItem> todosLit;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView
                title,
                subTitle,
                category;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subTitle = (TextView) view.findViewById(R.id.sub_title);
            category = (TextView) view.findViewById(R.id.category);
        }
    }


    public TodoItemsAdapter(List<TodoItem> todosLit) {
        this.todosLit = todosLit;
    }

    @Override
    public TodoItemsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TodoItem todoItem = todosLit.get(position);
        holder.title.setText(todoItem.getTitle());
        holder.subTitle.setText(todoItem.getSubTitle());
        holder.category.setText(todoItem.getCategory().getName());
    }

    @Override
    public int getItemCount() {
        return todosLit.size();
    }
}