package com.wakeupdev.movemate.ui.shipment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.constants.Parcels;
import com.wakeupdev.movemate.databinding.FragmentShipmentBinding;
import com.wakeupdev.movemate.databinding.FragmentShipmentStateBinding;
import com.wakeupdev.movemate.enums.State;
import com.wakeupdev.movemate.models.ParcelModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ShipmentStateFragment extends Fragment {
    private FragmentShipmentStateBinding binding;
    private List<ParcelModel> parcels;
    private ShipmentStateAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentShipmentStateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        setUpRecycler();
    }

    private void setUpRecycler(){
        parcels = Parcels.getParcels();

        adapter = new ShipmentStateAdapter(requireContext(), parcels);

        binding.parcelItemStateRecyclerView.setLayoutManager(
                new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false)
        );
        binding.parcelItemStateRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    void updateContent(int position) {
        if (parcels == null || adapter == null){
            setUpRecycler();
        }

        switch (position){
            case 0:
                adapter.updateParcels(parcels);
            break;

            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    List<ParcelModel> filteredParcels =
                            parcels.stream().filter(parcelModel -> parcelModel.getState().equals(State.PENDING)).collect(Collectors.toList());
                    adapter.updateParcels(filteredParcels);

                }
                break;


            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    List<ParcelModel> filteredParcels =
                            parcels.stream().filter(parcelModel -> parcelModel.getState().equals(State.IN_PROGRESS)).collect(Collectors.toList());
                    adapter.updateParcels(filteredParcels);

                }
                break;
            default:
                adapter.updateParcels(new ArrayList<>());
                break;
        }
    }
}