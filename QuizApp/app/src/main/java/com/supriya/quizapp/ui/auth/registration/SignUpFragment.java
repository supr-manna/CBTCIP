package com.supriya.quizapp.ui.auth.registration;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.supriya.quizapp.R;
import com.supriya.quizapp.databinding.FragmentSignUpBinding;
import com.supriya.quizapp.ui.auth.AuthViewModel;
import com.supriya.quizapp.util.MyProgress;

public class SignUpFragment extends Fragment {
    FragmentSignUpBinding binding;

    private AuthViewModel viewModel;
    private NavController navController;
    private MyProgress progress;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.tvGotoSIgnIn.setOnClickListener(v -> navController.popBackStack());

        binding.btnSignUp.setOnClickListener(view1 -> {
            showProgress(true);
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()){
                viewModel.signUp(email ,password);
                viewModel.getFirebaseUserMutableLiveData().observe(getViewLifecycleOwner(), firebaseUser -> {
                    showProgress(false);
                    if (firebaseUser != null) {
                        Toast.makeText(getContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                        navController.navigate(R.id.action_signUpFragment_to_listFragment);
                    }
                });
            } else {
                showProgress(false);
                Toast.makeText(getContext(), "Please Enter Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (progress != null) {
            progress.dismiss();
        }
    }
}