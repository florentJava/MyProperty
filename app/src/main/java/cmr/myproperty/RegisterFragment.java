package cmr.myproperty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cmr.myproperty.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    FirebaseAuth mAuth;


    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        mAuth = FirebaseAuth.getInstance();
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        binding.linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setReorderingAllowed(true);
                LoginFragment loginFragment = LoginFragment.newInstance();
                fragmentTransaction.replace(R.id.fragment_container_view, loginFragment,null);
                fragmentTransaction.commit();
            }
        });

        addListener();

    }

    public boolean checkInputValidity(){
        if (String.valueOf(binding.registerMail.getText()).isEmpty()){
            Toast.makeText(getActivity(), "Entrez votre mail", Toast.LENGTH_SHORT).show();
        } else if (String.valueOf(binding.registerPassword.getText()).isEmpty()) {
            Toast.makeText(getActivity(), "Entrez votre mot de passe", Toast.LENGTH_SHORT).show();
        } else if (String.valueOf(binding.registerNom.getText()).isEmpty()) {
            Toast.makeText(getActivity(), "Entrez votre Nom", Toast.LENGTH_SHORT).show();
        } else if (String.valueOf(binding.registerPhone.getText()).isEmpty()) {
            Toast.makeText(getActivity(), "Entrez votre Numero de telephone", Toast.LENGTH_SHORT).show();
        } else if (String.valueOf(binding.registerPrenom.getText()).isEmpty()) {
        Toast.makeText(getActivity(), "Entrez votre prenom", Toast.LENGTH_SHORT).show();
        }else {
            return true;
        }

        return false;

    }

    public void addListener(){
        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInputValidity())
                    registerUser( binding.registerMail.getText().toString(),binding.registerPassword.getText().toString() );
            }
        });
    }

    public void registerUser(String email, String password){

        binding.registerProgressbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                binding.registerProgressbar.setVisibility(View.GONE );

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
//                    FirebaseUser user = mAuth.getCurrentUser();

                    Toast.makeText(getActivity(), "Accout Create.",
                            Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getActivity(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}