package Utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import testapp.sergey.myapplication.R;

public class ItemsGridAdapter extends RecyclerView.Adapter<ItemsGridAdapter.MyViewHolder> {
    private ArrayList<String> mDataset;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.item_name);
            imageView = v.findViewById(R.id.item_icon);
        }
    }

    public ItemsGridAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public ItemsGridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position));
        //holder.imageView
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}