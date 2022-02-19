package uz.pdp.tasks5_modul;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Page> pages;

    public MainAdapter(ArrayList<Page> pages) {
        this.pages = pages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Page page = pages.get(position);
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).iv_opener.setImageResource(page.image);
            ((ViewHolder) holder).tv_context.setText(page.context);
            ((ViewHolder) holder).tv_description.setText(page.description);
        }
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_opener;
        TextView tv_context;
        TextView tv_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_opener = itemView.findViewById(R.id.iv_opener);
            tv_context = itemView.findViewById(R.id.tv_context);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
