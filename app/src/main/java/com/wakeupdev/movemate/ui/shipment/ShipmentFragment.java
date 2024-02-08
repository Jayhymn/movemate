package com.wakeupdev.movemate.ui.shipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;
import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.databinding.FragmentShipmentBinding;

public class ShipmentFragment extends Fragment {

    private FragmentShipmentBinding binding;
    private ShipmentStateFragment stateFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        ShipmentsViewModel notificationsViewModel =
//                new ViewModelProvider(this).get(ShipmentsViewModel.class);

        binding = FragmentShipmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.navIcon.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_navigation_shipment_to_navigation_home);

        });

        setUpTabLayout();

    }


    private void setUpTabLayout() {
        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                stateFragment = new ShipmentStateFragment();
                return stateFragment;
            }

            @Override
            public int getItemCount() {
                return binding.tabLayout.getTabCount();
            }
        });

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                stateFragment.updateContent(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}