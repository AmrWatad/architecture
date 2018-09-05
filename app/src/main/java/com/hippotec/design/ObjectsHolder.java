package com.hippotec.design;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by amr on 22/7/2018.
 */

public class ObjectsHolder {
    private static ObjectsHolder instance = null;

    public static void setA(int a) {
        ObjectsHolder.a = a;
    }

    public static int getA() {

        return a;
    }

    private static int a=1;
    private static ArrayList<DataModel> sharedStringFormDialogToFragment = new ArrayList<DataModel>();


    ObjectsHolder() {
    }

    public synchronized static ObjectsHolder getInstance() {
        if (instance == null) {
            instance = new ObjectsHolder();
        }
        return instance;
    }


    public ArrayList<DataModel> getSharedStringFormDialogToFragment() {


        return this.sharedStringFormDialogToFragment;
    }

    public void setSharedStringFormDialogToFragment(DataModel sharedStringFormDialogToFragment) {

        this.sharedStringFormDialogToFragment.add(sharedStringFormDialogToFragment);
        for (int i = 0; i < this.sharedStringFormDialogToFragment.size(); i++) {
            for (int j = this.sharedStringFormDialogToFragment.size() - 1; j > 0; j--) {
                if ((this.sharedStringFormDialogToFragment.get(i).text.toString().equals(this.sharedStringFormDialogToFragment.get(j).text.toString())) && i != j)
                    this.sharedStringFormDialogToFragment.remove(j);
            }

        }
    }

    public void setSharedStringFormDialogToFragment2(DataModel sharedStringFormDialogToFragment) {

        for (int i = 0; i < this.sharedStringFormDialogToFragment.size(); i++) {
            if ((this.sharedStringFormDialogToFragment.get(i).text.toString().equals(sharedStringFormDialogToFragment.text.toString())))
                this.sharedStringFormDialogToFragment.remove(i);


        }
    }

    public void removeall() {

        for (int i = 0; i < this.sharedStringFormDialogToFragment.size(); i++)
            this.sharedStringFormDialogToFragment.remove(i);
        this.sharedStringFormDialogToFragment.clear();
    }


}

