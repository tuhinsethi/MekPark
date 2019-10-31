package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mekpark.Adapters.ExpandableListAdapter;
import com.example.mekpark.Fragments.Checkin;
import com.example.mekpark.MenuModel;
import com.example.mekpark.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout dl;
    Toolbar toolbar;
    ExpandableListView expandableListView;
    public ActionBarDrawerToggle t;

    ExpandableListAdapter expandableListAdapter;

    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    private int lastExpandedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin2);

        toolbar = findViewById(R.id.toolbar);


        // setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationIcon(R.drawable.menu);
        }


        setNavDrawer();

        setBottomNavigation();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setNavDrawer() {
        dl = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl, toolbar, R.string.open, R.string.close);
        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();
        dl.addDrawerListener(t);
        t.syncState();
        t.setDrawerIndicatorEnabled(false);

        t.setHomeAsUpIndicator(ResourcesCompat.getDrawable(getResources(), R.drawable.menu, getTheme()));
        t.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dl.isDrawerVisible(GravityCompat.START)) {
                    dl.closeDrawer(GravityCompat.START);
                } else {
                    dl.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationView navigationView = findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        setupDrawerContent(navigationView);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:

                dl.openDrawer(GravityCompat.START);

                return true;

            case R.id.audio:
                return true;
            case R.id.refresh:
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setBottomNavigation() {

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment LoginFragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //toolbar.setTitle("Shop");
//                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                    // startActivity(new Intent(NavActivity.this, AwaitingActivity.class));
                    try {
                        Fragment fragment = Checkin.class.newInstance();
                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }

                    return true;
                case R.id.navigation_location:
                    //toolbar.setTitle("My Gifts");
                    return true;
                // case R.id.navigation_sm:

                //  return true;
                case R.id.navigation_walet:
                    // startActivity(new Intent(NavActivity.this, OrderHistory.class));
                    // toolbar.setTitle("ProfileActivity");
                    return true;
                case R.id.navigation_profile:
                    startActivity(new Intent(OpenActivity.this, ProfileActivity.class));

                    return true;
            }
            return false;
        }
    };

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override

                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        // selectDrawerItem(menuItem);

                        return false;

                    }

                });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        dl.closeDrawer(GravityCompat.START);
        return true;
    }

    public void prepareMenuData() {

        MenuModel menuModel = new MenuModel(0, "My Account", false, true, R.drawable.profile_dummy); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(1, "Bookings", true, true, R.drawable.wallet_dummy); //Menu of Java Tutorials
        headerList.add(menuModel);
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel(10, "New Bookings", false, false, 0);
        childModelsList.add(childModel);

        childModel = new MenuModel(11, "Ongoing Bookings", false, false, 0);
        childModelsList.add(childModel);

        childModel = new MenuModel(12, "History", false, false, 0);
        childModelsList.add(childModel);


        if (menuModel.isHasChildren()) {

            childList.put(menuModel, childModelsList);
        }


        menuModel = new MenuModel(2, "About Us", false, true, R.drawable.alert_exclamation); //Menu of Python Tutorials
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(3, "Services", true, true, R.drawable.settings_red); //Menu of Python Tutorials
        headerList.add(menuModel);

        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }


        menuModel = new MenuModel(4, "Notifications", false, true, R.drawable.bell_icon); //Menu of Python Tutorials
        headerList.add(menuModel);

        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }


        menuModel = new MenuModel(5, "Logout", false, true, R.drawable.logout2); //Menu of Python Tutorials
        headerList.add(menuModel);

        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }


    }

    public void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);


        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

//            DrawerLayout drawer = findViewById(R.id.drawer_layout);
                MenuModel menuModel = headerList.get(groupPosition);
                int id_int = (int) id;
               /* if (menuModel.isGroup() && menuModel.isHasChildren())
                    return expandableListView.isGroupExpanded(groupPosition) ? expandableListView.collapseGroup(groupPosition) : expandableListView.expandGroup(groupPosition);
                else return true;*/

                if (menuModel.isGroup()) {


                    if (!menuModel.isHasChildren()) {

                        switch (id_int) {
                            case 0:
                                startActivity(new Intent(OpenActivity.this, ProfileActivity.class));
                                break;
                            case 1: //startActivity(new Intent(AppHomePage.this, MyAddressHomePage.class));
                                //  delay(new UserProfile());
                                break;
                            case 2: //startActivity(new Intent(AppHomePage.this,MekCoinsWallet.class));break;
                                break;
                            case 3:
                                // delay(new OrderHistory());
                                break;
                            case 4:
                                break;
                            case 5:
                                //  delay(new AboutUs());
                                break;
                            case 6:
                                // delay(new Help());
                                break;
                            case 7: //startActivity(new Intent(AppHomePage.this, OffersHomePage.class));
                                break;
                            case 8: //startActivity(new Intent(AppHomePage.this, AboutUsPage.class));
                                // mSession.logoutUser();
                                OpenActivity.this.finish();
                                break;
                        }

                    }
                }
                OpenActivity.this.onBackPressed();
                return false;


            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {


                    if (groupPosition == 1) {
                        switch (childPosition) {
                            case 0:

                                // tabLayout.getTabAt(0).select();


                                break;
                            case 1:
                                // tabLayout.getTabAt(1).select();

                                break;
                            case 2:
                                //tabLayout.getTabAt(2).select();

                                break;
                        }
                    }

                    OpenActivity.this.onBackPressed();

                }

                return false;

            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;

            }
        });
    }
}
