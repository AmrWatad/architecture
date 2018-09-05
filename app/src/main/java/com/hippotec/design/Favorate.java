package com.hippotec.design;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.n2m.dynamic_seekbar.DynamicSeekBarView;

import static com.hippotec.design.CDF_Show_Image.ARGS_VIEW_ID6;


public class Favorate extends Fragment implements SeekBar.OnSeekBarChangeListener, RecyclerViewAdapter.ItemListener {
    RecyclerView recyclerView;
    ObjectsHolder objectsHolder;
    TextView mtextView2;
     private static ArrayList<DataModel> arr = new ArrayList<DataModel>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.favorate, container, false);
        objectsHolder = new ObjectsHolder();
objectsHolder.setA(2);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        mtextView2 =   v.findViewById(R.id.textView2);



        RecyclerViewAdapter adapter;
       //ArrayList<DataModel> aa= objectsHolder.getSharedStringFormDialogToFragment();

        if( objectsHolder.getSharedStringFormDialogToFragment()!=null) {
              adapter = new RecyclerViewAdapter(getContext(),  objectsHolder.getSharedStringFormDialogToFragment(), this);

            mtextView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    objectsHolder.removeall();
                    recyclerView.setAdapter(adapter);

                }
            });

          /*  for (int i = 0; i < objectsHolder.getSharedStringFormDialogToFragment().size(); i++) {
                im.setVisibility(View.INVISIBLE);



            }*/
            recyclerView.setAdapter(adapter);


        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(v.getContext(), 500);
        recyclerView.setLayoutManager(layoutManager);
        }
        //  }

        return v;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemClick(DataModel item) {
        Toast.makeText(getContext(),item.text.toString(),Toast.LENGTH_SHORT).show();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        //DialogFragment dialogFragment = new CDF_media_analog_configuretaion();
            DialogFragment dialogFragment = new CDF_Show_Image();
        Bundle args = new Bundle();
        args.putInt(ARGS_VIEW_ID6, item.drawable);
       // args.putSerializable(ARGS_VIEW_ID6, item);
        Intent intent = new Intent(getContext(), CDF_Show_Image.class);
        intent.putExtra("item", (Parcelable) item);
        dialogFragment.setArguments(args);


            dialogFragment.show(ft, "dialog");


    }


}