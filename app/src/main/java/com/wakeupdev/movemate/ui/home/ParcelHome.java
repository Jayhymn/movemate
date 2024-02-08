package com.wakeupdev.movemate.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.appbar.AppBarLayout;
import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.adapter.VehicleAdapter;
import com.wakeupdev.movemate.data.Vehicle;
import com.wakeupdev.movemate.databinding.FragmentHomeBinding;
import com.wakeupdev.movemate.databinding.FragmentParcelHomeBinding;
import com.wakeupdev.movemate.ui.home.HomeViewModel;
import com.wakeupdev.movemate.ui.home.ParcelSearch;

public class ParcelHome extends Fragment {

    private FragmentParcelHomeBinding binding;
    private OnFragmentChangeListener listener;
    public static ParcelHome newInstance(OnFragmentChangeListener listener) {
        ParcelHome parcelHome = new ParcelHome();
        parcelHome.listener = listener;

        return parcelHome;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentParcelHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        AppBarLayout appBarLayout = binding.appBarLayout;
        Animation animationSlideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_up);

        binding.collapsingToolbarLayout.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_down));
        binding.trackingDetails.startAnimation(animationSlideUp);
        binding.trackingText.startAnimation(animationSlideUp);
        binding.availableText.startAnimation(animationSlideUp);
        binding.vehicleRecycler.startAnimation(animationSlideUp);

        binding.searchView.setOnQueryTextFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                listener.onFragmentChange(false);
//                appBarLayout.setExpanded(false);
            }
        });


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                ParcelSearch parcelSearch = new ParcelSearch();

//                getParentFragmentManager().setFragmentResult("parcel_search_key", Bundle.EMPTY);
//                fragmentTransaction.replace(R.id.fragment_container, parcelSearch);
//                fragmentTransaction.addToBackStack(salesCategoryFragment.getClass().getSimpleName());
//                fragmentTransaction.commit();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                appBarLayout.setExpanded(false);
                return true;
            }
        });


        VehicleAdapter vehicleAdapter = new VehicleAdapter(requireContext(), Vehicle.getAvailableVehicles());
        binding.vehicleRecycler.setAdapter(vehicleAdapter);
        binding.vehicleRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));


//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}