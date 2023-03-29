package xyz.dan.recyclerviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<ItemModel> itemList;

    public ItemAdapter(List<ItemModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        int itemImage = itemList.get(position).getImageItemView();
        String name = itemList.get(position).getNameTextView();
        String message = itemList.get(position).getMessageTextView();
        String time = itemList.get(position).getTimeTextView();
        String line = itemList.get(position).getDividerTextView();

        holder.setData(itemImage, name, message, time, line);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private ImageView itemImageView;
        private TextView itemNameView;
        private TextView itemMessageView;
        private TextView itemTimeView;
        private TextView itemDividerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.item_image_view_1);
            itemNameView = itemView.findViewById(R.id.name_textview);
            itemMessageView = itemView.findViewById(R.id.message_textview);
            itemTimeView = itemView.findViewById(R.id.time_textview);
            itemDividerView= itemView.findViewById(R.id.item_divider_textview);
        }

        public void setData(int itemImage, String name, String message, String time, String line) {
            itemImageView.setImageResource(itemImage);
            itemNameView.setText(name);
            itemMessageView.setText(message);
            itemTimeView.setText(time);
            itemDividerView.setText(line);
        }
    }
}

