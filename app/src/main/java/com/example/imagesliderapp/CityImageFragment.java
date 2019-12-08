package com.example.imagesliderapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityImageFragment extends Fragment {

    private static final String TAG = "CityImageFragment";
    ImageView img;

    public CityImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_image, container, false);

        img=view.findViewById(R.id.imgvw);

        Bundle bundle=getArguments();
        if(bundle!=null){
            String imgurl=bundle.getString("imgurl");

            Glide.with(getActivity())
                    .asBitmap()
                    .load(imgurl)
                    .into(img);
        }
        else{
            Log.d(TAG, "onCreateView: bundle is empty");
        }

        return view;
    }

}
