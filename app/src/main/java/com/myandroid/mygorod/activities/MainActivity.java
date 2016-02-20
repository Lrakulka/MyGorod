package com.myandroid.mygorod.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.myandroid.mygorod.fragments.OgorodFragment;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.fragments.PlantsFragment;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new OgorodFragment())
                    .commit();
        }
        setNavigationDrawer();
    }

    private void setNavigationDrawer() {

        AccountHeader accountHeaderResult = initializeAccountHeader();

        new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(accountHeaderResult)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(false)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_gorods)
                                .withIdentifier(1)
                                .withIcon(R.drawable.gorods),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_workers)
                                .withIdentifier(2)
                                .withIcon(R.drawable.workers),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_plants)
                                .withIdentifier(3)
                                .withIcon(R.drawable.pine_tree),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_help)
                                .withIdentifier(3)
                                .withIcon(R.drawable.help_circle),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_settings)
                                .withIdentifier(4)
                                .withIcon(R.drawable.settings),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_about)
                                .withIdentifier(5)
                                .withIcon(R.drawable.information)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        setOnDrawerItemClickListener(position);
                        return false;
                    }
                })
                .build();
    }

    private AccountHeader initializeAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.garden_logo)
                .build();
    }

    private void setOnDrawerItemClickListener(int position) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 1:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                transaction.replace(R.id.container, new OgorodFragment());
                transaction.addToBackStack(null);

                break;
            case 2:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();

                transaction.replace(R.id.container, new PlantsFragment());
                transaction.addToBackStack(null);

                break;
            case 4:
                Log.v(LOG_TAG, "clicked on DividerDrawerItem = IMPOSSIBLE!!!");
                break;
            case 5:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
