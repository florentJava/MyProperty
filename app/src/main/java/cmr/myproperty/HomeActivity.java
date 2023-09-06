package cmr.myproperty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import cmr.myproperty.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//
//            int itemId = item.getItemId();
//
//
//            if (itemId == R.id.news) {
//                replaceFragment(new HomeFragment());
//            } else if (itemId == R.id.profile) {
//                replaceFragment(new ProfileFragment());
//            } else if (itemId == R.id.news) {
//                replaceFragment(new NewsFragment());
//            }
//
//            return true;
//        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view,fragment);

        fragmentTransaction.commit();

    }
}