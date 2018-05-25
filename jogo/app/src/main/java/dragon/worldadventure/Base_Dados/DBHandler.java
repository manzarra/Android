package dragon.worldadventure.Base_Dados;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import junit.framework.Test;

public class DBHandler extends SQLiteOpenHelper {

   public static final int DATABASE_VERSION=2;

    public static final String DATABASE_NAME="WorldAdventure";

   public static final boolean TEST_VERSION=true;

    public DBHandler(Context context){super(context,DATABASE_NAME,null, DATABASE_VERSION);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        final UserDBTable userDBTable = new UserDBTable(db);
        final HeroDBTable heroDBTable = new HeroDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);
        final WeaponDBTable weaponDBTable = new WeaponDBTable(db);
        final ArmorDBTable armorDBTable = new ArmorDBTable(db);
        final UserHeroesDBTable userHeroesDBTable = new UserHeroesDBTable(db);
        userDBTable.create();
        heroDBTable.create();
        levelDBTable.create();
        weaponDBTable.create();
        armorDBTable.create();
        userHeroesDBTable.create();
        heroDBTable.seed();
        levelDBTable.seed();


    }



    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            new UserDBTable(db).create();
            new HeroDBTable(db).create();
            new LevelDBTable(db).create();
            new WeaponDBTable(db).create();
            new ArmorDBTable(db).create();
            new UserHeroesDBTable(db).create();
        }
    }
}
