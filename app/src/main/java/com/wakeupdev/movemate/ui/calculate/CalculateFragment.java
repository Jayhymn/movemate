package com.wakeupdev.movemate.ui.calculate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.wakeupdev.movemate.CalculateActivity;
import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.databinding.FragmentCalculateBinding;

public class CalculateFragment extends Fragment {

    private FragmentCalculateBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalculateViewModel dashboardViewModel =
                new ViewModelProvider(this).get(CalculateViewModel.class);

        binding = FragmentCalculateBinding.inflate(inflater, container, false);

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.navIcon.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_navigation_calculate_to_navigation_home));
        binding.btnCalculate.setOnClickListener(v -> requireActivity().startActivity(
                new Intent(requireContext(), CalculateActivity.class))
        );

        binding.chipGroup.setAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_left));
        binding.trackingDetails.setAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.animation_slide_up));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}