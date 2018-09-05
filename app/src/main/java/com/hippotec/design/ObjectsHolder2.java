package com.hippotec.design;

/**
 * Created by rami on 22/7/2018.
 */

public class ObjectsHolder2 {
    private static ObjectsHolder instance;

    public static int sharedStringFormDialogToFragment=1;


    ObjectsHolder2() {}

    public synchronized static ObjectsHolder getInstance() {
        if (instance == null) {
            instance = new ObjectsHolder();
        }
        return instance;
    }


    public int getSharedStringFormDialogToFragment(){
        return this.sharedStringFormDialogToFragment;
    }

    public void setSharedStringFormDialogToFragment(int sharedStringFormDialogToFragment){
        this.sharedStringFormDialogToFragment=sharedStringFormDialogToFragment;
    }
}
