package cmr.myproperty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class TerrainAdapter extends BaseAdapter {

    private Context context;
    private List<TerrainModel> liste;
    private LayoutInflater inflater;


    public TerrainAdapter(Context context, List<TerrainModel> liste) {
        this.context = context;
        this.liste = liste;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public TerrainModel getItem(int i) {
        return liste.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.format_terrain,null);

        return view;
    }
}
