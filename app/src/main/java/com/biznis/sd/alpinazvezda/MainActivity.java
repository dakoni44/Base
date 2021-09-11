package com.biznis.sd.alpinazvezda;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeAdapter.OnItemClickListener, HomeAdapter2.OnItemClickListener, HomeAdapter3.OnItemClickListener {

    Toolbar toolbar;
    List<String> listGroup=new ArrayList<>();
    HashMap<String, List<String>> listItem=new HashMap<>();
    DrawerLayout drawerLayout;
    ExpandableListView drawerList;
    private RelativeLayout drawerPane;
    private ActionBarDrawerToggle drawerToggle;

    ImageView ivHeder, ivDok;
    private RecyclerView homeRecycler, homeRecycler2, homeRecycler3;
    private HomeAdapter homeAdapter;
    private HomeAdapter2 homeAdapter2;
    private HomeAdapter3 homeAdapter3;
    private LinearLayoutManager homeRManager;
    private List<Row> rows=new ArrayList<>();
    private List<Row> rows2=new ArrayList<>();
    private List<Artikal> arts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeRecycler=findViewById(R.id.homeRecycler);
        homeRManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        homeRecycler.setLayoutManager(homeRManager);
        fillItems();
        homeAdapter=new HomeAdapter(MainActivity.this,rows,this);
        homeRecycler.setAdapter(homeAdapter);

        homeRecycler2=findViewById(R.id.homeRecycler2);
        homeRManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        homeRecycler2.setLayoutManager(homeRManager);
        fillItems2();
        homeAdapter2=new HomeAdapter2(MainActivity.this,rows2,this);
        homeRecycler2.setAdapter(homeAdapter2);

        arts=ArtikalProvider.getArtikle();

        homeRecycler3=findViewById(R.id.homeRecycler3);
        homeRManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        homeRecycler3.setLayoutManager(homeRManager);
        homeAdapter3=new HomeAdapter3(MainActivity.this,arts,this);
        homeRecycler3.setAdapter(homeAdapter3);

        setupToolbar();
        fillDrawer();
        setupDrawer();

        ivHeder = findViewById(R.id.ivHeder);
        InputStream is=null;
        try {
            is = getAssets().open("heder.jpg");
            Drawable drawable = Drawable.createFromStream(is, null);
            ivHeder.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivDok=findViewById(R.id.ivDok);
        ivDok.setImageResource(R.drawable.dok);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
    }


    private void fillDrawer(){
        listGroup.add(getString(R.string.IndPre));
        listGroup.add(getString(R.string.GradjPre));
        listGroup.add(getString(R.string.AutProg));

        List<String> list1=new ArrayList<>();
        String[] array;
        array=getResources().getStringArray(R.array.IndPre);
        for(String item:array){
            list1.add(item);
        }

        List<String> list2=new ArrayList<>();
        array=getResources().getStringArray(R.array.GradjPre);
        for(String item:array){
            list2.add(item);
        }

        List<String> list3=new ArrayList<>();
        array=getResources().getStringArray(R.array.AutProg);
        for(String item:array){
            list3.add(item);
        }

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        homeAdapter.notifyDataSetChanged();
    }

    private void setupDrawer() {
        drawerList = findViewById(R.id.left_drawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerPane = findViewById(R.id.drawerPane);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = "Alpina";
                switch (i) {
                    case 0:

                    case 1:

                    case 2:
                        break;

                }
                drawerList.setItemChecked(i, true);
                setTitle(title);
                drawerLayout.closeDrawer(drawerPane);
            }
        });
        drawerList.setAdapter(new DrawerListAdapter(getApplicationContext(),listGroup ,listItem));


        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        ) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
    }

    public void fillItems(){

        rows.add(new Row(R.drawable.stanco));
        rows.add(new Row(R.drawable.body));
        rows.add(new Row(R.drawable.maxima1));
        rows.add(new Row(R.drawable.dupli));
        rows.add(new Row(R.drawable.ppg));
        rows.add(new Row(R.drawable.smirdex));

    }

    public void fillItems2(){

        rows2.add(new Row(R.drawable.epoxy));
        rows2.add(new Row(R.drawable.tkk));
        rows2.add(new Row(R.drawable.duxone));

    }


    @Override
    public void onItemClick(int position) {

    }
}