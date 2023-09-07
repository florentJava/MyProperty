package cmr.myproperty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cmr.myproperty.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        List<TerrainModel> terrains = new ArrayList<>();

        terrains.add(new TerrainModel("Titre 1","localisation"));
        terrains.add(new TerrainModel("Titre 2","localisation 2"));
        terrains.add(new TerrainModel("Titre 3","localisation 3"));


        ListView liste = findViewById(R.id.liste_terrain);

        liste.setAdapter(new TerrainAdapter(this,terrains));

    }

}