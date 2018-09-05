package com.hippotec.design;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PopUpDebriefingSideViewDialog extends AppCompatActivity implements View.OnClickListener {
    public ObjectsHolder2 objectsHolder;

    private RelativeLayout wrapperPopUpRelativeLayout;
    private ImageView openFullViewImageView;
    private View closeView;
    private TextView t1, t2, t3;

    private Dialog dialog;
    private Activity activity;

    public PopUpDebriefingSideViewDialog(Activity activity) {
        this.activity = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.debriefing_trigger_info);
        objectsHolder = new ObjectsHolder2();
        wrapperPopUpRelativeLayout = (RelativeLayout) dialog.findViewById(R.id.wrapper_pop_up_RelativeLayout);
        t1 = (TextView) dialog.findViewById(R.id.btn_1);

        t2 = (TextView) dialog.findViewById(R.id.btn_2);
        t3 = (TextView) dialog.findViewById(R.id.btn_3);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        wrapperPopUpRelativeLayout.setOnClickListener(this);
        openFullViewImageView = (ImageView) dialog.findViewById(R.id.open_full_view_ImageView);
        openFullViewImageView.setOnClickListener(this);
        closeView = (View) dialog.findViewById(R.id.close_View);
        closeView.setOnClickListener(this);

        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wmlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        dialog.getWindow().setDimAmount(0.0f);
        switch (objectsHolder.getSharedStringFormDialogToFragment()) {
            case 1:
                t1.setTextColor(Color.parseColor("#9FFFFC"));
                break;
            case 2:
                t2.setTextColor(Color.parseColor("#9FFFFC"));
                break;
            case 3:
                t3.setTextColor(Color.parseColor("#9FFFFC"));
                break;
        }
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objectsHolder.getSharedStringFormDialogToFragment()!=1){
                objectsHolder.setSharedStringFormDialogToFragment(1);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);}
                dialog.dismiss();

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objectsHolder.getSharedStringFormDialogToFragment()!=2) {

                    objectsHolder.setSharedStringFormDialogToFragment(2);
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    view.getContext().startActivity(intent);
                }
                dialog.dismiss();

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objectsHolder.getSharedStringFormDialogToFragment()!=3) {
                    objectsHolder.setSharedStringFormDialogToFragment(3);
                    Intent intent = new Intent(view.getContext(), MainActivity.class);

                    view.getContext().startActivity(intent);
                }
                dialog.dismiss();


            }
        });

        dialog.show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wrapper_pop_up_RelativeLayout:
                break;
            case R.id.close_View:
                System.out.println("ssssss");

                dialog.dismiss();
                break;

        }

    }

}