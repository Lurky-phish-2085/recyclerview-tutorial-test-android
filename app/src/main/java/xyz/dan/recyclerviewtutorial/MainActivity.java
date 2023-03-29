package xyz.dan.recyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ItemModel> itemList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();
    }

    private void initData() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.people1, "Donny", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Timmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jimmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people1, "Nibab", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Yow Gaba", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jihad", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people1, "Donny", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Timmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jimmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people1, "Nibab", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Yow Gaba", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jihad", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people1, "Donny", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Timmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jimmy", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people1, "Nibab", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people2, "Yow Gaba", "Hello, There!", "5:45 AM", "___________________"));
        itemList.add(new ItemModel(R.drawable.people3, "Jihad", "Hello, There!", "5:45 AM", "___________________"));
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        adapter = new ItemAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}