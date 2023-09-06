package cmr.myproperty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cmr.myproperty.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    FirebaseAuth mAuth;



    public LoginFragment() {
    }

    @NonNull
    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        binding.linkToRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setReorderingAllowed(true);
                        RegisterFragment registerFragment = RegisterFragment.newInstance();
                        fragmentTransaction.replace(R.id.fragment_container_view, registerFragment,null);
                        fragmentTransaction.commit();

                    }
                }
        );

        addListener();
    }


    public boolean checkInputValidity(){
        if (String.valueOf(binding.usermailLogin.getText()).isEmpty()){
            Toast.makeText(getActivity(), "Entrez votre mail", Toast.LENGTH_SHORT).show();
        } else if (String.valueOf(binding.userpasswordLogin.getText()).isEmpty()) {
            Toast.makeText(getActivity(), "Entrez votre mot de passe", Toast.LENGTH_SHORT).show();
        }else {
            return true;
        }
        return false;
    }
    public void addListener(){
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInputValidity())
                    loginUser( binding.usermailLogin.getText().toString(),binding.userpasswordLogin.getText().toString() );
            }
        });
    }

    public void loginUser(String email, String password){

        binding.loginProgressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        binding.loginProgressbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(getActivity(), "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getActivity(),HomeActivity.class);
                            startActivity(intent);
                            getActivity().finish() ;


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }}