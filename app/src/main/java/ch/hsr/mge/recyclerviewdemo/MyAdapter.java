package ch.hsr.mge.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Module> dataset;

    public MyAdapter(ArrayList<Module> modules) {
        dataset = modules;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);
        ViewHolder viewHolder = new ViewHolder(v, textView, checkBox);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Module module = dataset.get(position);
        holder.textView.setText(" (" + module.getCode() + ")");
        holder.checkBox.setText(module.getName());
        holder.checkBox.setChecked(module.isSelected());

        holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(module);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(int position, Module module) {
        dataset.add(position, module);
        notifyItemInserted(position);
    }

    public void remove(Module module) {
        int position = dataset.indexOf(module);
        dataset.remove(position);
        notifyItemRemoved(position);
    }
}