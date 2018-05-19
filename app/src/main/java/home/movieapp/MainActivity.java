package home.movieapp;

import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GenresFragment genresFragment = new GenresFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private FavoriteFragment favFragment = new FavoriteFragment();
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Genres");
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        showGenresFragment();
        navigationView.getMenu().getItem(0).setChecked(true);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_genres) {
            showGenresFragment();

        } else if (id == R.id.nav_search) {
            showSearchFragment();

        } else if (id == R.id.nav_favorites) {
            showFavoriteFragment();


       } //else if (id == R.id.nav_about) {

       // }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFavoriteFragment() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_fragment_container, favFragment, FavoriteFragment.class.getSimpleName())
                //.addToBackStack(FavoriteFragment.class.getSimpleName())
                .commit();

        toolbar.setTitle("Favorite Movies");

    }

    private void showSearchFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_fragment_container, searchFragment, SearchFragment.class.getSimpleName())
                //.addToBackStack(SearchFragment.class.getSimpleName())
                .commit();

        toolbar.setTitle("Search Movies");

    }

    private void showGenresFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_fragment_container, genresFragment, GenresFragment.class.getSimpleName())
                //.addToBackStack(GenresFragment.class.getSimpleName())
                .commit();

        toolbar.setTitle("Genres");
    }


}
