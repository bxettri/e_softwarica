package com.example.e_softwarica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.example.e_softwarica.R;
import com.example.e_softwarica.activity.MainActivity;
import com.example.e_softwarica.adapter.MainAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class homeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.student_list,container,false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rvStudent);
        MainAdapter adapterStudent = new MainAdapter(getActivity(), MainActivity.studentList);
        recyclerView.setAdapter(adapterStudent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }
}
