package xyz.dan.recyclerviewtutorial;

public class ItemModel {

    private int imageItemView;
    private String nameTextView;
    private String messageTextView;
    private String timeTextView;
    private String dividerTextView;

    public ItemModel(int image, String name, String message, String time, String divider) {
        this.imageItemView = image;
        this.nameTextView = name;
        this.messageTextView = message;
        this.timeTextView = time;
        this.dividerTextView = divider;
    }

    public int getImageItemView() {
        return imageItemView;
    }

    public String getNameTextView() {
        return nameTextView;
    }

    public String getMessageTextView() {
        return messageTextView;
    }

    public String getTimeTextView() {
        return timeTextView;
    }

    public String getDividerTextView() {
        return dividerTextView;
    }
}
