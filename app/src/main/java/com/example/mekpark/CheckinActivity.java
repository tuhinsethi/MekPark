package com.example.mekpark;

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

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckinActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_layout);

        dl = findViewById(R.id.dl);


        Toolbar toolbar = findViewById(R.id.toolbar);
        t = new ActionBarDrawerToggle(this, dl, toolbar, R.string.open, R.string.close);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationIcon(R.drawable.menu);
        }
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
        // navigationView.getMenu().getItem(1).setActionView(R.layout.menu_right_arrow);
        // navigationView.getMenu().getItem(3).setActionView(R.layout.menu_right_arrow);
        navigationView.setItemIconTintList(null);

     /*   // Set Navigation Header
        View headerView      =  navigationView.getHeaderView(0);

        ImageView iv_profile =  headerView.findViewById(R.id.profile_pic);
        TextView tv_name     =  headerView.findViewById(R.id.name);
        TextView tv_mobile   =  headerView.findViewById(R.id.mobile);

        // need to set a profile pic -
        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AppHomePage.this,Profile.class));
                dl.closeDrawer(GravityCompat.START);
            }
        });
        tv_name.setText(mUserInfo.get(LoginSessionManager.NAME));
        tv_mobile.setText(mUserInfo.get(LoginSessionManager.MOBILE));
*/

        // Setup drawer view

        // setupDrawerContent(nv);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.dl);
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


    public void selectDrawerItem(MenuItem menuItem) {

        // Create a new fragment and specify the fragment to show based on nav item clicked

        Fragment fragment = null;

        Class fragmentClass = null;

        switch (menuItem.getItemId()) {

          /*  case R.id.nav_first_fragment:

                fragmentClass = FirstFragment.class;

                break;

            case R.id.nav_second_fragment:

                fragmentClass = SecondFragment.class;

                break;

            case R.id.nav_third_fragment:

                fragmentClass = ThirdFragment.class;

                break;

            default:

                fragmentClass = FirstFragment.class;
*/
        }


        try {

            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {

            e.printStackTrace();

        }


        // Insert the fragment by replacing any existing fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();


        // Set action bar title

        setTitle(menuItem.getTitle());

        // Close the navigation drawer

        dl.closeDrawers();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel(0, "My Account", false, true, R.drawable.profile_dummy); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(1, "Bookings", true, true, R.drawable.wallet_dummy); //Menu of Java Tutorials
        headerList.add(menuModel);
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel(0, "New Bookings", false, false, 0);
        childModelsList.add(childModel);

        childModel = new MenuModel(1, "Ongoing Bookings", false, false, 0);
        childModelsList.add(childModel);

        childModel = new MenuModel(2, "History", false, false, 0);
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

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);


        expandableListView.setAdapter(expandableListAdapter);

      /*  expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {

//            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            MenuModel menuModel = headerList.get(groupPosition);
            int id_int = (int) id;

           if (menuModel.isGroup()) {

                if (!menuModel.isHasChildren()) {
                    switch (id_int) {
                        case 0:
                            //startActivity(new Intent(NavActivity.this, UserProfile.class));
                            break;
                        case 1: //startActivity(new Intent(AppHomePage.this, MyAddressHomePage.class));
                            delay(new UserProfile());
                            break;
                        case 2: //startActivity(new Intent(AppHomePage.this,MekCoinsWallet.class));break;
                            break;
                        case 3:
                            delay(new OrderHistory());
                            break;
                        case 4:
                            break;
                        case 5:
                            delay(new AboutUs());
                            break;
                        case 6:
                            delay(new Help());
                            break;
                        case 7: //startActivity(new Intent(AppHomePage.this, OffersHomePage.class));
                            break;
                        case 8: //startActivity(new Intent(AppHomePage.this, AboutUsPage.class));
                            mSession.logoutUser();
                            finish();
                            break;
                    }
                    onBackPressed();
               }
            }

            return false;
        });*/

       /* expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {

            if (childList.get(headerList.get(groupPosition)) != null) {



                if (groupPosition == 2) {
                    switch (childPosition) {
                        case 0:

                            tabLayout.getTabAt(0).select();


                            break;
                        case 1:
                            tabLayout.getTabAt(1).select();

                            break;
                        case 2:
                            tabLayout.getTabAt(2).select();

                            break;
                    }
                }

                onBackPressed();

            }

            return false;

        });*/

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
  /*  public void delay(Activity activity){
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            Intent intent = new Intent(NavActivity.this, activity.getClass());
            startActivity(intent);

        }, 250);
    }
*/

}
