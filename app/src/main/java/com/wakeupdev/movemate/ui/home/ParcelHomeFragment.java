package com.wakeupdev.movemate.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.appbar.AppBarLayout;
import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.adapter.VehicleAdapter;
import com.wakeupdev.movemate.data.Vehicle;
import com.wakeupdev.movemate.databinding.FragmentHomeBinding;

public class ParcelHomeFragment extends Fragment implements OnFragmentChangeListener {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        ParcelHome parcelSearch = ParcelHome.newInstance(this);
        transaction.replace(R.id.top_most_view, parcelSearch);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onFragmentChange(boolean isSearch) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        ParcelSearch parcelSearch = ParcelSearch.newInstance(this);
        ParcelHome parcelHome = ParcelHome.newInstance(this);
        transaction.replace(R.id.top_most_view, isSearch? parcelHome : parcelSearch);
        transaction.commit();

    }
}