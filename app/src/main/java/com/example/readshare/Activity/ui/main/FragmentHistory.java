package com.example.readshare.Activity.ui.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class FragmentHistory extends Fragment {
    GridView gridView;
    String[] values={"Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"};
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7,R.drawable.img3, R.drawable.img4, R.drawable.img1, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img5};
    public FragmentHistory(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.historique,container,false);
        gridView=v.findViewById(R.id.gridview);
        HistoriqueAdapter historiqueAdapter=new HistoriqueAdapter(this.getActivity().getBaseContext(),values,images);
        gridView.setAdapter(historiqueAdapter);
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}

