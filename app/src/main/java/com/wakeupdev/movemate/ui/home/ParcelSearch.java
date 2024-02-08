package com.wakeupdev.movemate.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.animations.WidthAnimation;
import com.wakeupdev.movemate.constants.Parcels;
import com.wakeupdev.movemate.databinding.FragmentParcelSearchBinding;
import com.wakeupdev.movemate.enums.State;
import com.wakeupdev.movemate.models.ParcelModel;

import java.util.ArrayList;
import java.util.List;


public class ParcelSearch extends Fragment {
    private FragmentParcelSearchBinding rootView;
    private List<ParcelModel> parcels = new ArrayList<>();
    private OnFragmentChangeListener listener;

    public ParcelSearch() {
        // Required empty public constructor
        parcels = Parcels.getParcels();

    }

    public static ParcelSearch newInstance(OnFragmentChangeListener listener){
        ParcelSearch search = new ParcelSearch();
        search.listener = listener;

        return search;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = FragmentParcelSearchBinding.inflate(LayoutInflater.from(requireContext()), container, false);

        return rootView.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        Toolbar toolbar = rootView.toolbar;

        activity.setSupportActionBar(toolbar);

        rootView.navIcon.setOnClickListener(v -> listener.onFragmentChange(true));

        rootView.searchInput.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_width));
        rootView.navIcon.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_right));

//        WidthAnimation.animateWidth(rootView.searchInput, rootView.searchInput.getWidth(), 500);


        RecyclerView recyclerView = rootView.recyclerTrackingDetails;
        ParcelAdapter adapter = new ParcelAdapter(requireContext(), parcels);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );
        recyclerView.setAdapter(adapter);

        // Add appear animation to the RecyclerView
        recyclerView.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_up));
    }

}