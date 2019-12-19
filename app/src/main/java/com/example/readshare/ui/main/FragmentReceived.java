package com.example.readshare.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class FragmentReceived extends Fragment {
    public FragmentReceived(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.demande_recu,container,false);
        ListReceived[] lstReceived = new ListReceived[] {
                new ListReceived("Contes","150m", R.drawable.img1),
                new ListReceived("Le père goriot","2km", R.drawable.img2),
                new ListReceived("Antigone","4km", R.drawable.img3),
                new ListReceived("Boîte à merveille","300m", R.drawable.img4),
                new ListReceived("Sans Famille", "350m",R.drawable.img5),
                new ListReceived("Le monde s'effronde","5km", R.drawable.img6),
                new ListReceived("Madame Bovary","400m", R.drawable.img7),

        };

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        ReceivedAdapter adapter = new ReceivedAdapter(lstReceived);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity().getBaseContext()));
        recyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
