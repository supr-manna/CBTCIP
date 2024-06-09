package com.supriya.quizapp.ui.main.quizItems;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supriya.quizapp.R;
import com.supriya.quizapp.network.model.quizList.QuizListModel;
import com.supriya.quizapp.util.MyProgress;

import java.util.List;

public class ListFragment extends Fragment implements ListAdapter.OnItemClickedListener{
    private RecyclerView recyclerView;
    private QuizViewModel viewModel;
    private NavController navController;
    private ListAdapter adapter;
    private MyProgress progress;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(QuizViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvItems);
        navController = Navigation.findNavController(view);
        showProgress(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListAdapter(this::onItemClick);

        recyclerView.setAdapter(adapter);

        viewModel.getQuizListLiveData().observe(getViewLifecycleOwner(), quizListModels -> {
            adapter.setDataModels(quizListModels);
            adapter.notifyDataSetChanged();
            showProgress(false);
        });
    }

    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        navController.navigate(R.id.action_listFragment_to_detailFragment, bundle);
    }

    private void showProgress(Boolean status) {
        try {
            if (progress == null) {
                progress = new MyProgress(requireContext());
                progress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            if (status) {
                progress.show();
            } else {
                progress.dismiss();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}