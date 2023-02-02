package com.example.chalaan.Activities.ui.home;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.chalaan.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


       final TextView textView = root.findViewById(R.id.text_home);

        featuredRecycler = root.findViewById(R.id.featured_recycler);
        mostViewedRecycler = root.findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = root.findViewById(R.id.categories_recycler);

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
       // mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable. heromaestroedge, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.heropassion, "Edenrobe"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.honda, "J."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hondadreamneo, "Walmart"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mahindra, "Walmart"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
        
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        //featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.maruti1, "Mcdonald's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.maruti2, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.hyundai, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kia, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.volkswagen, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1,R.drawable.hero,"Hero"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hondadreamneo, "Honda"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.ktm, "KTM"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.mahindrabrand, "Mahindra"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.tvs, "TVS"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.yamaha, "Yamaha"));



        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapte(categoriesHelperClasses);
       // categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }
}