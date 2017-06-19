package com.example.sherly.lightchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView)findViewById(R.id.elv);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        //untuk header/group
        listDataHeader.add("Banks & Building Societies");
        listDataHeader.add("Building Services");
        listDataHeader.add("Carparks - Indoor");
        listDataHeader.add("Carparks - Outdoor");
        listDataHeader.add("Circulation Areas");
        listDataHeader.add("External");
        listDataHeader.add("Food Production");
        listDataHeader.add("Hazardous (Oil/Gas Industries)");
        listDataHeader.add("Hazardous (Petrochemical Industries)");
        listDataHeader.add("Hazardous (Power Industries)");
        listDataHeader.add("High Temperature");
        listDataHeader.add("Industrial & General Engineering");
        listDataHeader.add("Offices");
        listDataHeader.add("Places of Public Assembly");
        listDataHeader.add("Restaurants & Hotels");
        listDataHeader.add("Retail");
        listDataHeader.add("Roadways & Streets");
        listDataHeader.add("Sports - Indoor");
        listDataHeader.add("Sports - Outdoor");
        listDataHeader.add("Staff Rooms");
        listDataHeader.add("Warehousing & Distribution");

        //untuk list view/isi
        List<String> banks = new ArrayList<>();
        banks.add("Public Area");
        banks.add("Counter & Offices");

        List<String>  buildingservices = new ArrayList<>();
        buildingservices.add("Electrical Plant Rooms");
        buildingservices.add("Mechanical Plant Rooms");
        buildingservices.add("Boiler Houses");
        buildingservices.add("Control Rooms");

        //untuk menampilkan datanya
        listHash.put(listDataHeader.get(0),banks);
        listHash.put(listDataHeader.get(1),buildingservices);
    }
}
