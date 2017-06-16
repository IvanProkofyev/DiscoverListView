package com.prokofyev.ivan.discoverlistview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prokofyev.ivan.discoverlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DLV";
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ImagesAdapter adapter = new ImagesAdapter(this, parseHeaders());
        mBinding.imagesList.setLayoutManager(new DiscoverLayoutManager(this, 6));
        mBinding.imagesList.setAdapter(adapter);
//        mBinding.imagesList
    }

    private List<String> parseHeaders(){
        List<String> headers =  new ArrayList<>();
        String raw = "Tree Of The Sea\n" +
                "Hero Of The Ancestors\n" +
                "Witches Of The Gods\n" +
                "Turtles Without Shame\n" +
                "Invaders And Traitors\n" +
                "Turtles And Rats\n" +
                "Source Without A Conscience\n" +
                "Inception Of The Forsaken\n" +
                "Helping Technology\n" +
                "Prepare For My Husband\n" +
                "Agent With Honor\n" +
                "Foe Of Earth\n" +
                "Serpents Of Fortune\n" +
                "Foes Of The Light\n" +
                "Vultures And Men\n" +
                "Soldiers And Lions\n" +
                "Future Of The Sea\n" +
                "Annihilation Of Fortune\n" +
                "Escaping My Future\n" +
                "Temptations In The Shadows\n" +
                "Witch With Strength\n" +
                "Raven Of Reality\n" +
                "Swindlers Of Fire\n" +
                "Creators Of The Void\n" +
                "Creators And Butchers\n" +
                "Vultures And Rats\n" +
                "Staff Of The Stars\n" +
                "Surprise Of Yesterday\n" +
                "Guarded By My Dreams\n" +
                "Begging In The City";
        String[] rawAr =  raw.split("\n");
        for (int i = 0; i < rawAr.length; i ++){
            headers.add(rawAr[i]);
        }
        return headers;
    }


}
