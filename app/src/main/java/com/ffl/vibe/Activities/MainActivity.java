package com.ffl.vibe.Activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.backendless.Backendless;
import com.ffl.vibe.Fragments.AdapterEventFragment;
import com.ffl.vibe.R;

public class MainActivity extends AppCompatActivity {
    public static final String App_ID="324FC87E-1704-43E9-FF4D-94E49BFD9C00";
    public static final String Secret_Key="BD512B01-8090-35EB-FF30-8DF1BED9C400";
Toolbar toolbar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    ViewPager viewPager;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Backendless.initApp(this,App_ID,Secret_Key);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        viewPager =(ViewPager)findViewById(R.id.viewpager);
        // viewPager.setAdapter(new FragmentAdapterEvent(getSupportFragmentManager(),MainActivity.this));
        AdapterEventFragment PagerAdapter= new AdapterEventFragment(getSupportFragmentManager(),MainActivity.this);
        viewPager.setAdapter(PagerAdapter);
        TabLayout tabLayout= (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerToggle = setupDrawerToggle();
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

    }



   private ActionBarDrawerToggle setupDrawerToggle() {
       // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
       // and will not render the hamburger icon without it.
       return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
   }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        switch (item.getItemId())
        {
            case R.id.action_marque:
                Toast.makeText(this, "Marque is Selected",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.action_preference:
            Toast.makeText(this, "Preference is Selected",Toast.LENGTH_SHORT).show();
            return  true;
            case R.id.action_profile:
                Toast.makeText(this, "Profile is Selected",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings is Selected",Toast.LENGTH_SHORT).show();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;

        switch(menuItem.getItemId()) {

            case R.id.navallevent_fragment:
                viewPager.setCurrentItem(0);
                break;
            case R.id.navlive_fragment:
                viewPager.setCurrentItem(1);
                break;
            case R.id.navmyevent_fragment:
                viewPager.setCurrentItem(2);
                break;
            case R.id.navallclub_fragment:
                viewPager.setCurrentItem(3);
                break;
            default:
                viewPager.setCurrentItem(0);
        }


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        inflater.inflate(R.menu.menu_settings,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
// Expand the search view and request focus
        searchView.setQueryHint("Search...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                 searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
