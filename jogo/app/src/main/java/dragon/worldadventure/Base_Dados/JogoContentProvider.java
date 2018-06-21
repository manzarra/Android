/*package dragon.worldadventure.Base_Dados;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class JogoContentProvider extends ContentProvider {

    private static final String AUTHORITY = "dragon.worldadventure.Base_Dados";

    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    public static final Uri VILLAN_URI = Uri.withAppendedPath(BASE_URI, VillanDBTable.TABLE_NAME);

    public static final Uri STATS_URI = Uri.withAppendedPath(BASE_URI, StatsDBTable.TABLE_NAME);

    private static final int VILLAN = 100;
    private static final int VILLAN_ID = 101;
    private static final int STATS = 200;
    private static final int STATS_ID = 201;

    private static final String MULTIPLE_ITEMS = "vnd.android.cursor.dir";
    private static final String SINGLE_ITEM = "vnd.android.cursor.item";

    DBHandler dbHandler;

    private static UriMatcher getJogoUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTHORITY, "VILLAN", VILLAN);
        uriMatcher.addURI(AUTHORITY, "VILLAN/#", VILLAN_ID);

        uriMatcher.addURI(AUTHORITY, "STATS", STATS);
        uriMatcher.addURI(AUTHORITY, "STATS/#", STATS_ID);

        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        dbHandler = new DBHandler(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        String id = uri.getLastPathSegment();

        UriMatcher matcher = getJogoUriMatcher();

        switch (matcher.match(uri)) {
            case VILLAN:
                return new VillanDBTable(db).query(projection, selection, selectionArgs, null, null, sortOrder);

            case STATS:
                return new StatsDBTable(db).query(projection, selection, selectionArgs, null, null, sortOrder);

            case VILLAN_ID:
                return new VillanDBTable(db).query(projection, VillanDBTable._ID + "=?", new String[] { id }, null, null, null);

            case STATS_ID:
                return new StatsDBTable(db).query(projection, StatsDBTable._ID + "=?", new String[] { id }, null, null, null);

            default:
                throw new UnsupportedOperationException("Invalid URI: " + uri);
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}*/
