package com.dmd.LiveDataSample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmd.LiveDataSample.viewmodel.PageViewModel;
import com.dmd.LiveDataSampleData.R;

public class SecondFragment extends Fragment {
    PageViewModel pageViewModel;

    public static SecondFragment newInstance(){
        return new SecondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(getActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_second, container, false);
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textView = view.findViewById(R.id.textViewResponse);
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String valueToAssign) {
                textView.setText(valueToAssign);
            }
        };

        pageViewModel.getName().observe(requireActivity(), nameObserver);
    }
}