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
    private HashMap<String, ArrayList<LightLevelModel>> listHash;

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

        DatabaseHandler db = new DatabaseHandler(this);

        ArrayList<LightLevelModel> banks;
        banks = db.readLightLevelType(1);

        ArrayList<LightLevelModel> buildingservices;
        buildingservices = db.readLightLevelType(2);

        ArrayList<LightLevelModel> carparksindoor;
        carparksindoor = db.readLightLevelType(3);

        ArrayList<LightLevelModel> carparksoutdoor;
        carparksoutdoor = db.readLightLevelType(4);

        ArrayList<LightLevelModel> circulationareas;
        circulationareas = db.readLightLevelType(5);

        ArrayList<LightLevelModel> external;
        external = db.readLightLevelType(6);

        ArrayList<LightLevelModel> foodproduction;
        foodproduction = db.readLightLevelType(7);

        ArrayList<LightLevelModel> oil;
        oil = db.readLightLevelType(8);

        ArrayList<LightLevelModel> petrochemical;
        petrochemical = db.readLightLevelType(9);

        ArrayList<LightLevelModel> power;
        power = db.readLightLevelType(10);

        ArrayList<LightLevelModel> hightemperature;
        hightemperature = db.readLightLevelType(11);

        ArrayList<LightLevelModel> industrial;
        industrial = db.readLightLevelType(12);

        ArrayList<LightLevelModel> offices;
        offices = db.readLightLevelType(13);

        ArrayList<LightLevelModel> placeofpublic;
        placeofpublic = db.readLightLevelType(14);

        ArrayList<LightLevelModel> restaurant;
        restaurant = db.readLightLevelType(15);

        ArrayList<LightLevelModel> retail;
        retail = db.readLightLevelType(16);

        ArrayList<LightLevelModel> roadways;
        roadways = db.readLightLevelType(17);

        ArrayList<LightLevelModel> sportsindoor;
        sportsindoor = db.readLightLevelType(18);

        ArrayList<LightLevelModel> sportsoutdoor;
        sportsoutdoor = db.readLightLevelType(19);

        ArrayList<LightLevelModel> staffrooms;
        staffrooms = db.readLightLevelType(20);

        ArrayList<LightLevelModel> warehousing;
        warehousing = db.readLightLevelType(21);

        //untuk menampilkan datanya
        listHash.put(listDataHeader.get(0),banks);
        listHash.put(listDataHeader.get(1),buildingservices);
        listHash.put(listDataHeader.get(2),carparksindoor);
        listHash.put(listDataHeader.get(3),carparksoutdoor);
        listHash.put(listDataHeader.get(4),circulationareas);
        listHash.put(listDataHeader.get(5),external);
        listHash.put(listDataHeader.get(6),foodproduction);
        listHash.put(listDataHeader.get(7),oil);
        listHash.put(listDataHeader.get(8),petrochemical);
        listHash.put(listDataHeader.get(9),power);
        listHash.put(listDataHeader.get(10),hightemperature);
        listHash.put(listDataHeader.get(11),industrial);
        listHash.put(listDataHeader.get(12),offices);
        listHash.put(listDataHeader.get(13),placeofpublic);
        listHash.put(listDataHeader.get(14),restaurant);
        listHash.put(listDataHeader.get(15),retail);
        listHash.put(listDataHeader.get(16),roadways);
        listHash.put(listDataHeader.get(17),sportsindoor);
        listHash.put(listDataHeader.get(18),sportsoutdoor);
        listHash.put(listDataHeader.get(19),staffrooms);
        listHash.put(listDataHeader.get(20),warehousing);

        //listHash.put(listDataHeader.get(1),buildingservices);
    }
}
