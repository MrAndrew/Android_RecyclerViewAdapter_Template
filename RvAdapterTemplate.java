package com.my.package.name;

import androidx.recyclerview.widget.RecyclerView; //import stuff here

public class MyDataListAdapter extends RecyclerView.Adapter<MyDataListAdapter.MyDataViewHolder> {

    private ArrayList<MyObject> mObjects;
    private Context mContext;

    //Need to declare the following in whatever activity or fragment loads the RV
    // RecyclerView myRecylerView = returnView.findViewById(R.id.my_rv); //from content layout set in activity/fragment
    // //layout manager
    // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext()); //or GridLayoutManager
    // myRecylerView.setLayoutManager(layoutManager);
    // //create and set rv adapter
    // mDataListAdapter = new MyDataListAdapter(getContext());
    // myRecylerView.setAdapter(mDataListAdapter);
    // loadDataList(); //this method should call `mDataListAdapter.setDataItems(ArrayList<MyObject>());`

    public MyDataListAdapter(Context context) {
        mContext =context;
    }

    @Override
    public MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_item_layout, parent, false); //inflate and set our custom layout
        return new MyDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyDataViewHolder viewHolder, int position) {
        final MyObject obj = mObjects.get(position);

        //Set data of views from viewHolder with values from Objects
        //ex:  `viewHolder.myTextView.setText(obj.getText());`
        // or set a pic with Glide and url:
        // Glide.with(mContext)
        //        .asBitmap()
        //        .load(obj.getImageUrl())
        //        .into(viewHolder.myImageView);

    }

    //needed because we declare the adapter in an activity or fragment to a RV in a layout
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        if (mObjects == null) {
            return 0;
        } else {
            return mObjects.size();
        }
    }

    public void setDataItems(@Nullable ArrayList<MyObject> inObjects) {
        if (mObjects!=null) {
            mObjects.clear();
        }
        mObjects = inObjects;
        this.notifyDataSetChanged(); //so new list is loaded into RV
    }


    // Inner class for creating ViewHolders
    class MyDataViewHolder extends RecyclerView.ViewHolder {
        //variables for views
        TextView myTextView;
        ImageView myImageView;
        //constructor
        MyDataViewHolder(View view) {
            super(view);
            myTextView = view.findViewById(R.id.my_text_view_in_item_layout);
            myImageView  = view.findViewById(R.id.my_image_view_in_item_layout);
        }
    }

}
