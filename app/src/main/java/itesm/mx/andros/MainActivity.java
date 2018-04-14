package itesm.mx.andros;

import android.app.ListActivity;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<Section> arrayMenuSections;
    private SectionAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Prep@ Net");

        arrayMenuSections = getDataForMenuList();

        sectionAdapter = new SectionAdapter(this, R.layout.main_menu_row, arrayMenuSections);
        setListAdapter(sectionAdapter);
    }

    public ArrayList<Section> getDataForMenuList() {
        MenuSection section = new MenuSection();
        return section.getListaSections();
    }
}
