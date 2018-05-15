package itesm.mx.andros;
//This JAva class uses code from https://github.com/chrisbanes/PhotoView All credit from the code goes to its author.

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ArrayList<Section> arrayMenuSections;
    private SectionAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Prep@ Net");
        ListView secciones;

        secciones = findViewById(R.id.menu);

        arrayMenuSections = getDataForMenuList();

        sectionAdapter = new SectionAdapter(this, R.layout.main_menu_row, arrayMenuSections);
        secciones.setAdapter(sectionAdapter);

        secciones.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, SectionsActivity.class);
        intent.putExtra("seccion", i);

        startActivity(intent);
    }

    public ArrayList<Section> getDataForMenuList() {
        MenuSection section = new MenuSection();
        return section.getListaSections();
    }
}