package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.HeroDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;


public class UserHero {
    private long id;
    public String userheroname;
    private long heroid;
    private long userid;
    private long weaponid;
    private long armorid;
    private long levelid;
    private int tab;




    public UserHero(Cursor cursor){
        this.id=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable._ID));
        this.userheroname = cursor.getString(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_USERHERONAME));
        this.heroid=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN__ID_HERO));
        this.userid=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_ID_USER));
        this.weaponid=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_ID_WEAPON));
        this.armorid=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_ID_ARMOR));
        this.levelid=cursor.getLong(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_ID_LEVEL));
        this.tab = cursor.getInt(cursor.getColumnIndex(UserHeroesDBTable.DB_COLUMN_TAB));

    }

    //construtor----------------------------------------------------------------------------------------

    public UserHero(){

    }

    public UserHero(long id, String userheroname, long heroid, long userid, long weaponid, long armorid, long levelid, int tab) {
        this.id = -1;
        this.userheroname = userheroname;
        this.heroid = heroid;
        this.userid = userid;
        this.weaponid = weaponid;
        this.armorid = armorid;
        this.levelid = levelid;
        this.tab = tab;
    }

    //--------------------------------------------------------------------------------------------------

    //sets e gets--------------------------------------------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserheroname() {
        return userheroname;
    }

    public void setUserheroname(String userheroname) {
        this.userheroname = userheroname;
    }

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getWeaponid() {
        return weaponid;
    }

    public void setWeaponid(long weaponid) {
        this.weaponid = weaponid;
    }

    public long getArmorid() {
        return armorid;
    }

    public void setArmorid(long armorid) {
        this.armorid = armorid;
    }

    public long getLevelid() {
        return levelid;
    }

    public void setLevelid(long levelid) {
        this.levelid = levelid;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
    //---------------------------------------------------------------------------------------------------


    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHeroesDBTable.DB_COLUMN_USERHERONAME,userheroname);
        contentValues.put(UserHeroesDBTable.DB_COLUMN__ID_HERO,heroid);
        contentValues.put(UserHeroesDBTable.DB_COLUMN_ID_ARMOR,armorid);
        contentValues.put(UserHeroesDBTable.DB_COLUMN_ID_LEVEL,levelid);
        contentValues.put(UserHeroesDBTable.DB_COLUMN_ID_USER,userid);
        contentValues.put(UserHeroesDBTable.DB_COLUMN_ID_WEAPON,weaponid);
        contentValues.put(UserHeroesDBTable.DB_COLUMN_TAB,tab);
        return contentValues;
    }

}
