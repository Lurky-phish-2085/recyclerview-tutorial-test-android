package xyz.dan.recyclerviewtutorial;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView itemImageView;
    private TextView itemNameView;
    private TextView itemMessageView;
    private TextView itemTimeView;
    private TextView itemDividerView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        itemImageView = itemView.findViewById(R.id.item_image_view_1);
        itemNameView = itemView.findViewById(R.id.name_textview);
        itemTimeView = itemView.findViewById(R.id.time_textview);
        itemDividerView = itemView.findViewById(R.id.item_divider_textview);
    }
}
