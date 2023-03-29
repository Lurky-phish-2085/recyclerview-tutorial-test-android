# RecyclerView sample

A sample app that uses `RecyclerView` to display it's items.

Here is the tutorial I followed:
[tutorial](https://youtu.be/4cFL7CMd5QY)

# Rough Steps

# RecyclerView

1. Add dependencies first!
  - Go to `File > Project Structure > Dependencies > Add button`
  - recyclerview
  - cardview

2. Prepare your images for the items and put it to the drawable folder

3. add the recyclerview element to the `activty_main.xml` xml layout file and add this attribs:

```xml
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white">

       <!-- XD -->

    </androidx.recyclerview.widget.RecyclerView>
```

4. Design the RecyclerView item view
  - use RelativeLayout as root element
  - the height must be set to `wrap_content`
  - Another RelativeLayout inside the RelativeLayout
    - height depends on you
  - add background color
  - Now put elements for the Design

  - use cardview for circular image
    - height and width depends on you

```xml
        <androidx.cardview.widget.CardView
            android:id="@+id/image_view"
            android:layout_width="60dp"
            android:layout_height="60dp"
            app:cardCornerRadius="60dp"
            android:layout_marginTop="20dp"
            android:layout_marginStart="20dp">
            
            
        </androidx.cardview.widget.CardView>
```

  - now, add an image view for this CardView
    - ImageView height and width must be equal to the CardView
    - set scaleType to "centerCrop"
    - give it image
    - assign id
    - the image will be changed later by the Activity, so it's just a
      placeholder for now

```xml
            <ImageView
                android:id="@+id/item_image_view_1"
                android:layout_width="60dp"
                android:layout_height="60dp"
                android:scaleType="centerCrop"
                android:src="@drawable/people1" />
```

    - Now, add TextViews give id to them to be accessed by adapter class later
    - Might as well add divider line via text view

```xml
        <TextView
            android:id="@+id/name_textview"
            android:layout_width="120dp"
            android:layout_height="30dp"
            android:text="Jimmy"
            android:textColor="@color/black"
            android:textSize="20sp"
            android:layout_toRightOf="@id/item_image_cardview"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="20dp" />

        <TextView
            android:id="@+id/time_textview"
            android:layout_width="80dp"
            android:layout_height="30dp"
            android:text="10:43 am"
            android:textSize="12sp"
            android:layout_toRightOf="@id/name_textview"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="75dp" />

        <TextView
            android:id="@+id/message_textview"
            android:layout_width="140dp"
            android:layout_height="30dp"
            android:text="Hi!"
            android:textSize="15sp"
            android:layout_toRightOf="@id/item_image_cardview"
            android:layout_below="@id/name_textview"
            android:layout_marginLeft="20dp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:text="----------------------------------"
            android:textColor="#CDC7C7"
            android:textSize="15sp"
            android:layout_toRightOf="@id/item_image_cardview"
            android:layout_below="@id/name_textview"
            android:layout_marginTop="-5dp"
            android:layout_marginLeft="20dp" />
```

5. Create a model class for those items
  - Acts as a structure for holding every data on each item
  - Like a Data source

  - Declare variables that corresponds to each values the item holds (e.g pfp,
    message, time, etc)

  - create getters for each vars (use alt + insert)

```java
package xyz.dan.recyclerviewtutorial;

public class ItemModel {

    private int image;
    private String name;
    private String message;
    private String time;
    private String divider;

    public ItemModel(int image, String message, String time, String divider) {
        this.image = image;
        this.message = message;
        this.time = time;
        this.divider = divider;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getDivider() {
        return divider;
    }
}
```

6. create an adpater (VERY IMPORTANT)
    - adapters are responsible for the functionality of the recyclerview
    - extends `RecyclerView.Adapter<Adapter.ViewHolder>` and use alt + enter to
      implement it's methods

    - Create the ViewHolder class within the adapter
    - declare vars
      - List<YourModelClass> varName;

    - create the constructor that just sets the variable

    - override `onCreateViewHolder()` to use the created layout file for the
      items. Uses the design to inflate the view object.

```java
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
```

    - `onBindViewHolder()` will be used to bind data from the Model to the this adapter????

```java
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int itemImage = itemList.get(position).getImageItemView();
        String name = itemList.get(position).getNameTextView();
        String message = itemList.get(position).getMessageTextView();
        String time = itemList.get(position).getTimeTextView();
        String line = itemList.get(position).getDividerTextView();

        holder.setData(itemImage, name, message, time, line);
    }
```

    - `getItemCount()` return the size of the `List`

    - Continue to implement the nested class `ViewHolder` and should extends
      RecyclerView.ViewHolder and must create constructor matching super

    - Assign the resource id of the xml layout of the item to the adapter class
      - To do that declare vars for each elements of the xml and assign the values

```java
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
         itemTimeView = itemView.findViewById(R.id.time_textview);
         itemDividerView= itemView.findViewById(R.id.item_divider_textview);
     }

     // sets the data of the item in the RecyclerView
     public void setData(int itemImage, String name, String message, String time, String line) {
            itemImageView.setImageResource(itemImage);
            itemNameView.setText(name);
            itemMessageView.setText(message);
            itemTimeView.setText(time);
            itemDividerView.setText(line);
     }
}
```

    - The RecyclerView is now complete and ready to use!

7. In the Activity, to dis: 

  - declare var for 
    - 1. `RecyclerView` 
    - 2. `LinearLayoutManager`
    - 3. List of the Model Class created lately
    - 4. the adapter

  - create method that will initialize the recyclerview


```java
private void initRecyclerView() {
     recyclerView = findViewById(R.id.recycler_view);
     layoutManager = new LinearLayoutManager(this);
     layoutManager.setOrientation(RecyclerView.VERTICAL);
     adapter = new ItemAdapter(itemList);

     recyclerView.setLayoutManager(layoutManager);
     recyclerView.setAdapter(adapter);
     adapter.notifyDataSetChanged();
}
```

   - create method that will initialize the contents of the recyclerView (the items)

```java
initData() {
 // simply initialize the array of the item
 // then instantiate the models
}
```
