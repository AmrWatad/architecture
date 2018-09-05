package com.hippotec.design;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ObjectsHolder objectsHolder = new ObjectsHolder();

    public void setmValues(ArrayList<DataModel> mValues) {
        this.mValues = mValues;
    }

    ArrayList<DataModel> mValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView imageView;
        public ImageView im ;
        public RelativeLayout relativeLayout;
        DataModel item;
        private ArrayList<DataModel> imagesLikedByUser;

        public ArrayList<DataModel> getImagesLikedByUser() {
            return imagesLikedByUser;
        }

        public void setImagesLikedByUser(DataModel imagesLikedByUser) {
            this.imagesLikedByUser.add(imagesLikedByUser);
        }

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            imagesLikedByUser = new ArrayList<DataModel>();

            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            im = (ImageView) v.findViewById(R.id.imageView4);
            //im.setBackgroundResource(R.drawable.shape_37_copy_2);

            for (int i = 0; i < objectsHolder.getSharedStringFormDialogToFragment().size(); i++) {
               if(textView.getText().toString()!=null) {
                   if (textView.getText().toString().equals(objectsHolder.getSharedStringFormDialogToFragment().get(i).text.toString())) {

                       im.setBackgroundResource(R.drawable.shape_37_copy_3);

                   }

               }

            }

            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Toast.makeText(view.getContext(),"zewewwz"+im.getBackground().getConstantState().equals(v.getResources().getDrawable(R.drawable.shape_37_copy_3).getConstantState()),Toast.LENGTH_LONG).show();

                    if (im.getBackground().getConstantState().equals(v.getResources().getDrawable(R.drawable.shape_37_copy_3).getConstantState())) {
                        Toast.makeText(view.getContext(),"zewewwz"+im.getBackground().getConstantState().equals(v.getResources().getDrawable(R.drawable.shape_37_copy_3).getConstantState()),Toast.LENGTH_LONG).show();
                        objectsHolder.setSharedStringFormDialogToFragment2(item);
                        im.setBackgroundResource(R.drawable.shape_37_copy_2);

                    } else {
                        im.setBackgroundResource(R.drawable.shape_37_copy_3);
                        setImagesLikedByUser(item);
                        objectsHolder.setSharedStringFormDialogToFragment(item);

                    }
                }
            });
            //relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        }

        public void setData(DataModel item) {
            this.item = item;
        /*    for (int i = 0; i < objectsHolder.getSharedStringFormDialogToFragment().size(); i++) {
                if(textView.getText()!=null) {
                    if (textView.getText().equals(objectsHolder.getSharedStringFormDialogToFragment().get(i).text)) {

                        im.setBackgroundResource(R.drawable.shape_37_copy_3);

                    }
                }

            }*/

            textView.setText(item.text);
           // imageView.setImageResource(item.drawable);
            imageView.setBackgroundResource(( item.drawable));
           // relativeLayout.setBackgroundColor(Color.parseColor(item.color));


        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);

            }
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
if(objectsHolder.getA()==2)
    view.findViewById(R.id.imageView4).setVisibility(View.INVISIBLE);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Vholder.setData((DataModel) mValues.get(position));

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(DataModel item);

    }
}