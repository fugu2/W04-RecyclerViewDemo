package ch.hsr.mge.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public View parent;
    public TextView textView;
    public CheckBox checkBox;

    public ViewHolder(View parent, TextView textView, CheckBox checkBox) {
        super(parent);
        this.parent = parent;
        this.textView = textView;
        this.checkBox = checkBox;
    }
}
