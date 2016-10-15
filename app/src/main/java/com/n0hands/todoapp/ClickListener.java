package com.n0hands.todoapp;

import android.view.View;

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);

    void onFling(View view, int position);
}
