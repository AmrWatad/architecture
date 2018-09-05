package com.hippotec.design;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class CDF_Show_Image extends DialogFragment {
    ImageView mbtn_clos;
    private OnFragmentInteractionListener mListener;
    public static final String ARGS_VIEW_ID6 = "id4";

    public CDF_Show_Image() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting_show_image, container, false);
        mbtn_clos=v.findViewById(R.id.clos);
        final PhotoView  imageView=v.findViewById(R.id.iv_photo);
        mbtn_clos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();

            }
        });
        Bundle args = getArguments();

        int viewId = args.getInt(ARGS_VIEW_ID6);
        Toast.makeText(getContext(),"sss"+viewId,Toast.LENGTH_SHORT).show();
        ObjectsHolder objectsHolder = new ObjectsHolder();
       // int width = getResources().getDimensionPixelSize(R.dimen.);
        //int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
       // getDialog().getWindow().setLayout(1000, 500);

        imageView.setImageResource((viewId));


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
