package com.hippotec.design;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CDF_Show_Image.OnFragmentInteractionListener {

    private TextView mTextMessage;
    private ImageView mbtn_settings;
    private ImageView mbtnHome;
    private ImageView mbtnfile;
    private ImageView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mbtn_settings = findViewById(R.id.imageButton_setting);
        mbtnfile = findViewById(R.id.imageButton_file);
        mbtnHome = findViewById(R.id.textView);
        m = findViewById(R.id.ii);


        Home homeFragment = new Home();
         setSelected(1);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, homeFragment).
                commit();
        mbtnHome.setOnClickListener(v -> {

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().
                    replace(R.id.container, homeFragment).
                    commit();
            setSelected(1);


        });
        mbtn_settings.setOnClickListener(v -> {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new Favorate()).
                    commit();
            setSelected(2);

        });
        mbtnfile.setOnClickListener(v -> {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new Favorate()).
                    commit();
            setSelected(3);

        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                     new PopUpDebriefingSideViewDialog(MainActivity.this);

                    setSelected(4);


            }

        });


    }

    private void setSelected(int i) {
        if(i!=4) {
            mbtnHome.setSelected(false);
            mbtn_settings.setSelected(false);
            mbtnfile.setSelected(false);
        }
        m.setPressed(false);

        switch (i) {
            case 1:
                mbtnHome.setSelected(true);
                break;
            case 2:
                mbtn_settings.setSelected(true);
                break;
            case 3:
                mbtnfile.setSelected(true);
                break;
            case 4:
                m.setPressed(true);
                break;

        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
