package com.hippotec.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Home extends Fragment implements RecyclerViewAdapter.ItemListener {
    RecyclerView recyclerView;
    ObjectsHolder2 objectsHolder;
    public ObjectsHolder objectsHolder2;
    private ArrayList<DataModel> imagesLikedByUser;

    ImageView image;
    public ArrayList<DataModel> arrayList;
    public ArrayList<DataModel> arrayList2;
    public ArrayList<DataModel> arrayList3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.stam, container, false);


        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        image =   v.findViewById(R.id.imageView4);
        objectsHolder2=new ObjectsHolder();
        arrayList = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList.add(new DataModel("Item 1", R.drawable.a6, "#09A9FF"));
        arrayList.add(new DataModel("Item 2", R.drawable.a22, "#3E51B1"));
        arrayList.add(new DataModel("Item 3", R.drawable.az, "#673BB7"));
        arrayList.add(new DataModel("Item 4", R.drawable.ac, "#4BAA50"));
        arrayList.add(new DataModel("Item 5", R.drawable.ad, "#F94336"));
        arrayList.add(new DataModel("Item 6", R.drawable.aa, "#0A9B88"));
        //arrayList.add(new DataModel("Item 6", R.drawable.a33, "#09A9FF"));
        arrayList.add(new DataModel("Item 7", R.drawable.az, "#3E51B1"));
        arrayList.add(new DataModel("Item 8", R.drawable.a6, "#673BB7"));
        arrayList.add(new DataModel("Item 9", R.drawable.a1, "#4BAA50"));
        arrayList.add(new DataModel("Item 10", R.drawable.a2, "#F94336"));
        arrayList.add(new DataModel("Item 11", R.drawable.ac, "#0A9B88"));
        arrayList3.add(new DataModel("Item 11", R.drawable.ac, "#0A9B88"));
        /****************/
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), arrayList, this);

        arrayList2.add(new DataModel("Item 7", R.drawable.az, "#3E51B1"));
        arrayList2.add(new DataModel("Item 8", R.drawable.a6, "#673BB7"));
        arrayList2.add(new DataModel("Item 9", R.drawable.a1, "#4BAA50"));
        arrayList2.add(new DataModel("Item 10", R.drawable.a2, "#F94336"));
        arrayList2.add(new DataModel("Item 11", R.drawable.ac, "#0A9B88"));
        objectsHolder = new ObjectsHolder2();

        switch (objectsHolder.getSharedStringFormDialogToFragment()) {
            case 1:
                adapter.setmValues(arrayList);
                break;
            case 2:
                adapter.setmValues(arrayList2);
                break;
            case 3:
                adapter.setmValues(arrayList3);
                break;


        }

        objectsHolder2.setA(1);

        recyclerView.setAdapter(adapter);


        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(v.getContext(), 600);
        recyclerView.setLayoutManager(layoutManager);


        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        // Check should we need to refresh the fragment

    }
    public void setImagesLikedByUser(DataModel imagesLikedByUser) {
        this.imagesLikedByUser.add(imagesLikedByUser);
    }
    @Override
    public void onItemClick(DataModel item) {
        Toast.makeText(getContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ViewPhoto.class);
        intent.putExtra("item", (Parcelable) item);

        startActivity(intent);

    }


}