package com.hippotec.design;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Integer.parseInt;

public class ViewPhoto extends AppCompatActivity {
    private ImageView mloveOnPhoto;
    static public Hashtable<DataModel, DataModel> sTable;
    public ObjectsHolder objectsHolder;
    static public int count = 0;
    private ArrayList<DataModel> imagesLikedByUser;

    public ArrayList<DataModel> getImagesLikedByUser() {
        return imagesLikedByUser;
    }

    public void setImagesLikedByUser(DataModel imagesLikedByUser) {
        this.imagesLikedByUser.add(imagesLikedByUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        imagesLikedByUser = new ArrayList<DataModel>();
        objectsHolder = new ObjectsHolder();
        final PhotoView photoView = findViewById(R.id.iv_photo);
        DataModel item = (DataModel) getIntent().getSerializableExtra("item");

        Picasso.with(this)
                .load(item.drawable)
                .into(photoView);
        mloveOnPhoto = findViewById(R.id.imageView2);
        for (int i = 0; i < objectsHolder.getSharedStringFormDialogToFragment().size(); i++) {
            if (item.text.equals(objectsHolder.getSharedStringFormDialogToFragment().get(i).text  )) {

                mloveOnPhoto.setBackgroundResource(R.drawable.shape_37_copy_3);

            }


        }
//            if (item.text.equals(objectsHolder.getSharedStringFormDialogToFragment().get(i).text  ) && (mloveOnPhoto.getBackground().equals(R.drawable.shape_37_copy_2))) {
        mloveOnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mloveOnPhoto.getBackground().getConstantState().equals
                        (getResources().getDrawable(R.drawable.shape_37_copy_3).getConstantState())) {
               Toast.makeText(view.getContext(),"zzz"+mloveOnPhoto.getBackground().equals(getResources().getDrawable(R.drawable.shape_37_copy_3)),Toast.LENGTH_LONG).show();
                    objectsHolder.setSharedStringFormDialogToFragment2(item);
                    mloveOnPhoto.setBackgroundResource(R.drawable.shape_37_copy_2);

                } else {
                    mloveOnPhoto.setBackgroundResource(R.drawable.shape_37_copy_3);
                    setImagesLikedByUser(item);
                    objectsHolder.setSharedStringFormDialogToFragment(item);

                }

            }

        });


    }


}

