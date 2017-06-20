package com.example.sherly.lightchecker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by SHERLY on 17/06/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lightleveldb";
    private static final int DATABASE_VERSION = 1;

    //Inisialisasi tabel light levels
    private static final String TABLE_NAME = "lightlevels";

    //Kolom tabel light level
    private static final String _ID = "id";
    private static final String AREA = "area";
    private static final String LIGHT_MIN = "light_min";
    private static final String LIGHT_MAX = "light_max";
    private static final String TYPE = "type";

    private Context context;
    private MainActivity activity;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public DatabaseHandler(MainActivity activity){
        super(activity, DATABASE_NAME, null, DATABASE_VERSION);
        this.activity = activity;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Membuat tabel lightlevel
        String CREATE_LIGHTLEVEL_TABLE = "CREATE TABLE "+ TABLE_NAME +"(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                AREA + " TEXT,"+
                LIGHT_MIN + " INTEGER,"+
                LIGHT_MAX + " INTEGER,"+
                TYPE + " INTEGER)";
        db.execSQL(CREATE_LIGHTLEVEL_TABLE);

        //Menyisipkan data pada tabel lightlevel

        //1. Banks & Building Societies
        inserData(db, "Public Area", 275, 325, 1);
        inserData(db, "Counter & Offices", 475, 525, 1);

        //2. Building Services
        inserData(db, "Electrical Plant Rooms", 75, 125, 2);
        inserData(db, "Mechanical Plant Rooms", 125, 175, 2);
        inserData(db, "Boiler Houses", 75, 125, 2);
        inserData(db, "Control Rooms", 275, 325, 2);

        //3. Carparks - Indoor
        inserData(db, "Entrances & Exits", 250, 300, 3);
        inserData(db, "Parking Bays & Driving Lanes", 50, 100, 3);

        //4. Carparks - Outdoor
        inserData(db, "Urban Areas", 10, 30, 4);
        inserData(db, "Rural Areas", 5, 15, 4);
        inserData(db, "Roof of Multi-Storey", 15, 25, 4);

        //5. Circulation Areas
        inserData(db, "Entrances & Exits", 175, 225, 5);
        inserData(db, "Atria", 50, 200, 5);
        inserData(db, "Atria with Plant Growth", 500, 3000, 5);
        inserData(db, "Lifts", 75, 125, 5);
        inserData(db, "Escalators & Moving Conveyors", 125, 175, 5);
        inserData(db, "Corridors and Stairs", 75, 125, 5);

        //6. External
        inserData(db, "Canopies", 125, 175, 6);
        inserData(db, "Facades", 50, 1500, 6);

        //7. Food Production
        inserData(db, "Product Inspection", 1180, 1400, 7);
        inserData(db, "Packaging", 750, 860, 7);
        inserData(db, "Maintenance", 750, 860, 7);
        inserData(db, "Administrative Offices", 475, 525, 7);
        inserData(db, "Processing Areas", 590, 700, 7);
        inserData(db, "Cafetaria", 425, 475, 7);
        inserData(db, "Locker Rooms", 320, 540, 7);
        inserData(db, "Bulk Ingredients Storage", 320, 430, 7);
        inserData(db, "Ingredients Warehouse", 215, 320, 7);

        //8. Hazardous (Oil / Gas Industries)
        inserData(db, "Drill Towers", 75, 125, 8);
        inserData(db, "Drill Floors", 275, 325, 8);
        inserData(db, "Processing Areas", 75, 125, 8);
        inserData(db, "Test Stations", 175, 225, 8);
        inserData(db, "Pump Areas", 175, 225, 8);
        inserData(db, "Crude Oil Pumps", 275, 325, 8);
        inserData(db, "Sludge Chamber", 275, 325, 8);
        inserData(db, "Facility Areas", 275, 325, 8);
        inserData(db, "Rotary Tables", 475, 525, 8);
        inserData(db, "Walkways", 75, 125, 8);
        inserData(db, "Landing Areas", 75, 125, 8);

        //9. Hazardous (Petrochemical Industries)
        inserData(db, "Servicing Areas", 15, 25, 9);
        inserData(db, "Risk-Free Filling Areas", 25, 75, 9);
        inserData(db, "High-Risk Filling Areas", 75, 125, 9);
        inserData(db, "Fuel Loading Areas", 75, 125, 9);
        inserData(db, "Maintenance Areas", 175, 225, 9);

        //10. Hazardous (Power Industries)
        inserData(db, "Inspection Areas", 25, 75, 10);
        inserData(db, "Maintenance Areas", 175, 225, 10);
        inserData(db, "Handling Areas", 15, 25, 10);
        inserData(db, "Walkways", 5, 10, 10);

        //11. High Temperature
        inserData(db, "Furnaces", 275, 325, 11);
        inserData(db, "Kilns", 275, 325, 11);
        inserData(db, "Boilers", 275, 325, 11);

        //12. Industrial & General Engineering
        inserData(db, "Heavy Machine Assembly", 275, 325, 12);
        inserData(db, "Arc Welding", 275, 325, 12);
        inserData(db, "Spot Welding", 500, 1000, 12);
        inserData(db, "Tool Shops", 300, 750, 12);
        inserData(db, "Inspections & Testing", 500, 2000, 12);
        inserData(db, "Wind Tunnels", 75, 125, 12);

        //13. Offices
        inserData(db, "General Offices", 475, 525, 13);
        inserData(db, "Drawing Offices", 475, 525, 13);
        inserData(db, "Executive Offices", 300, 500, 13);
        inserData(db, "Computer Workstations", 300, 500, 13);
        inserData(db, "Filing Rooms", 275, 325, 13);
        inserData(db, "Print Rooms", 275, 325, 13);
        inserData(db, "CAD Design Areas", 300, 500, 13);
        inserData(db, "Drawing Boards", 725, 775, 13);

        //14. Places of Public Assembly
        inserData(db, "Libraries", 150, 300, 14);
        inserData(db, "Cinemas & Theatre Foyers", 175, 225, 14);
        inserData(db, "Museums & Art Galleries", 275, 325, 14);
        inserData(db, "Churches", 100, 300, 14);
        inserData(db, "Village Halls", 275, 325, 14);
        inserData(db, "Lecture Theatres", 275, 325, 14);
        inserData(db, "Auditoria", 100, 150, 14);
        inserData(db, "Booking Offices", 275, 325, 14);

        //15. Restaurants & Hotels
        inserData(db, "Food Storage Areas", 125, 175, 15);
        inserData(db, "Wash Up & Vegetable Preparation", 275, 325, 15);
        inserData(db, "Food Preparation & Cooking", 475, 525, 15);
        inserData(db, "Entrance Halls", 75, 125, 15);
        inserData(db, "Reception Desk", 275, 325, 15);
        inserData(db, "Bar, Restaurant or Longue", 50, 200, 15);
        inserData(db, "Bedrooms", 50, 100, 15);

        //16. Retail
        inserData(db, "Small Retail Outlets", 475, 525, 16);
        inserData(db, "Fashion", 500, 750, 16);
        inserData(db, "Supermarkets", 725, 775, 16);
        inserData(db, "Hypermarkets", 975, 1025, 16);
        inserData(db, "Bookshops, Chemists & Jewellers", 475, 525, 16);
        inserData(db, "Garden Centres", 475, 525, 16);
        inserData(db, "Showrooms", 500, 750, 16);
        inserData(db, "Electrical Store", 725, 775, 16);
        inserData(db, "Furniture Store", 725, 775, 16);
        inserData(db, "Arcades & Malls", 50, 300, 16);

        //17. Roadways & Streets
        inserData(db, "Village", 5, 25, 17);
        inserData(db, "Suburban", 10, 30, 17);
        inserData(db, "Urban", 20, 40, 17);
        inserData(db, "Industrial Estate - Low Speed", 5, 10, 17);

        //18. Sports - Indoor
        inserData(db, "General - Sports Halls", 275, 325, 18);
        inserData(db, "Gymnastics", 275, 325, 18);
        inserData(db, "Badminton - Regional & Local", 475, 525, 18);
        inserData(db, "Badminton - National & International", 725, 775, 18);
        inserData(db, "Badminton - Local & Training", 275, 325, 18);
        inserData(db, "Swimming - National & International", 725, 775, 18);
        inserData(db, "Swimming - Regional & Local", 475, 525, 18);
        inserData(db, "Swimming - Local & Training", 175, 225, 18);
        inserData(db, "Weight/Cardio Suite", 375, 425, 18);

        //19. Sports - Outdoor
        inserData(db, "Football & Rugby - National & International", 475, 525, 19);
        inserData(db, "Football & Rugby - Regional & Local", 175, 225, 19);
        inserData(db, "Football & Rugby - Local & Training", 50, 100, 19);
        inserData(db, "Hockey & Tennis - National & International", 475, 525, 19);
        inserData(db, "Hockey & Tennis - Regional & Local", 275, 325, 19);
        inserData(db, "Hockey & Tennis - Local & Training", 175, 225, 19);
        inserData(db, "Equestrian - National & International", 475, 525, 19);
        inserData(db, "Equestrian - Regional & Local", 175, 225, 19);
        inserData(db, "Equestrian - Local & Training", 75, 125, 19);

        //20. Staff Rooms
        inserData(db, "Rest Rooms", 125, 175, 20);
        inserData(db, "Canteens", 175, 225, 20);
        inserData(db, "Changing Rooms & Toilets", 75, 125, 20);

        //21. Warehousing & Distribution
        inserData(db, "Loading Bays", 125, 175, 21);
        inserData(db, "Large Item Storage", 75, 125, 21);
        inserData(db, "Small Item Storage", 175, 275, 21);
        inserData(db, "Warehouse, Bulk Storage", 75, 125, 21);
        inserData(db, "Packing & Despatch", 275, 325, 21);
        inserData(db, "Unpacking & Sorting", 175, 225, 21);
        inserData(db, "Offices", 475, 525, 21);
        inserData(db, "Counter Area", 475, 525, 21);
        inserData(db, "Cold Storage", 275, 325, 21);
    }

    public void inserData(SQLiteDatabase db,String area, Integer lightmin, Integer lightmax, Integer type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AREA, area);
        contentValues.put(LIGHT_MIN, lightmin);
        contentValues.put(LIGHT_MAX, lightmax);
        contentValues.put(TYPE, type);

        db.insert(TABLE_NAME,null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Membaca semua data lightlevel
    public ArrayList<LightLevelModel> readLightLevelAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<LightLevelModel> data = new ArrayList<LightLevelModel>();
        Cursor cur = db.query(TABLE_NAME,new String[]{_ID,AREA,LIGHT_MIN,LIGHT_MAX,TYPE},null,null,null,null,null);
        for (int cc=0; cc<cur.getCount();cc++){
            cur.moveToPosition(cc);
            data.add(new LightLevelModel(Integer.parseInt(cur.getString(0)),cur.getString(1),Integer.parseInt(cur.getString(2)),Integer.parseInt(cur.getString(3)),Integer.parseInt(cur.getString(4))));
        }
        db.close();
        return data;
    }

    //Membaca semua data lightlevel
    public ArrayList<LightLevelModel> readLightLevelType(Integer type){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<LightLevelModel> data = new ArrayList<LightLevelModel>();
        Cursor cur = db.query(TABLE_NAME,new String[]{AREA},TYPE+"="+Integer.toString(type),null,null,null,null);
        for (int cc=0; cc<cur.getCount();cc++){
            cur.moveToPosition(cc);
            data.add(new LightLevelModel(cur.getString(0)));
        }
        db.close();
        return data;
    }

}
