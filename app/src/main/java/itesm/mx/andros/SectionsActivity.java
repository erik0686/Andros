package itesm.mx.andros;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class SectionsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private int numSection;
    private String[] sFigures = {"Círculo", "Elipse", "Parábola", "Hipérbola"};
    private int[] sIcons = {R.drawable.circle, R.drawable.ellipse, R.drawable.parabola, R.drawable.hyperbola};
    private int figSelected = 0;
    private FloatingActionButton fab;


    private static final String SELECTED_ITEM_POSITION = "ItemPosition";


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of item position
        outState.putInt(SELECTED_ITEM_POSITION, figSelected);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Read the state of item position
        figSelected = savedInstanceState.getInt(SELECTED_ITEM_POSITION);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            figSelected = savedInstanceState.getInt(SELECTED_ITEM_POSITION);

        }

        setContentView(R.layout.activity_sections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        numSection = intent.getExtras().getInt("seccion");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                figSelected++;
                if (figSelected == sFigures.length) {
                    figSelected = 0;
                }
                fab.setImageResource(sIcons[figSelected]);
                Snackbar.make(view, sFigures[figSelected], Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                displaySection();
            }
        });

        displaySection();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sections, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.menu_formulario:
                numSection = 0;
                break;
            case R.id.menu_ejemplos:
                numSection = 1;
                break;
            case R.id.menu_elementos:
                numSection = 2;
                break;
            case R.id.menu_transformar:
                numSection = 3;
                break;
            case R.id.menu_innovacion:
                numSection = 4;
                break;
            case R.id.menu_instrucciones:
                numSection = 5;
                break;
        }
        displaySection();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void displaySection(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fab.setVisibility(View.VISIBLE);
        switch (numSection){
            case 0:
                FragmentFormulario fragmentFormulario = FragmentFormulario.newInstance();
                transaction.replace(R.id.content_sections, fragmentFormulario, "FRAGMENT FORMULARIO" );
                transaction.commit();
                fab.setVisibility(View.INVISIBLE);
                break;
            case 1:
                FragmentExamples fragmentExamples = FragmentExamples.newInstance();
                transaction.replace(R.id.content_sections, fragmentExamples, "FRAGMENT EJEMPLOS" );
                transaction.commit();
                fragmentExamples.figSelected = figSelected;
                break;
            case 2:
                FragmentElements fragmentElements = FragmentElements.newInstance();
                transaction.replace(R.id.content_sections, fragmentElements, "FRAGMENT ELEMENTOS" );
                transaction.commit();
                fragmentElements.figSelected = figSelected;
                break;
            case 3:
                FragmentEcuations fragmentEcuations = FragmentEcuations.newInstance();
                transaction.replace(R.id.content_sections, fragmentEcuations, "FRAGMENT Ecuaciones" );
                transaction.commit();
                fragmentEcuations.figSelected = figSelected;
                break;
            case 4:
                FragmentYoutube fragment = new FragmentYoutube();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_sections, fragment).commit();
                fragment.figSelected = figSelected;
                break;
            case 5:
                FragmentInstrucciones fragmentInstrucciones = FragmentInstrucciones.newInstance();
                transaction.replace(R.id.content_sections, fragmentInstrucciones, "FRAGMENT INSTRUCCIONES" );
                transaction.commit();
                fab.setVisibility(View.INVISIBLE);
                break;
        }
        fab.setImageResource(sIcons[figSelected]);
    }
}
