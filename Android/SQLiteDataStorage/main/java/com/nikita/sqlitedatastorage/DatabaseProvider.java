package com.nikita.sqlitedatastorage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.util.HashMap;

public class DatabaseProvider extends ContentProvider {
    public DatabaseProvider() {
    }

    static final String PROVIDER_NAME = "com.nikita.sqlitedatastorage.list";
    // Определение URI контента
    static final String URL = "content://" + PROVIDER_NAME + "/mytable";

    // Парсинг URI контента
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String id = "id";
    static final String todo = "todo";
    static final String date = "date";
    static final String time = "time";
    static final String category = "category";
    static final int uriCode = 1;
    static final UriMatcher uriMatcher;
    private static HashMap<String, String> values;

    static {

        // для соответствия URI контента
        // каждый раз, когда пользователь обращается к таблице под контент-провайдером
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        // Для доступа ко всей таблице
        uriMatcher.addURI(PROVIDER_NAME, "mytable", uriCode);

        // Для доступа к определенной строке таблицы
        uriMatcher.addURI(PROVIDER_NAME, "mytable/*", uriCode);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case uriCode:
                count = db.delete(TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        switch (uriMatcher.match(uri)) {
            case uriCode:
                return "vnd.android.cursor.dir/mytable";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_NAME, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLiteException("Failed to add a record into " + uri);

    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        if (db != null) {
            return true;
        }
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_NAME);
        switch (uriMatcher.match(uri)) {
            case uriCode:
                qb.setProjectionMap(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (sortOrder == null || sortOrder == "") {
            sortOrder = id;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null,
                null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case uriCode:
                count = db.update(TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;

    }

    // Создание объекта базы данных
    // Для выполнения запроса
    private SQLiteDatabase db;

    // Объявление имени базы данных
    static final String DATABASE_NAME = "MyDB";

    // Объявление имени таблицы базы данных
    static final String TABLE_NAME = "mytable";

    // Объявление версии базы данных
    static final int DATABASE_VERSION = 1;

    // sql-запрос для создания таблицы
    static final String CREATE_DB_TABLE = ("create table mytable ("
            + "id integer primary key autoincrement,"
            + "todo text not null,"
            + "date text not null,"
            + "time text not null,"
            + "category text"
            + ");");

    // Создание базы данных
    private static class DatabaseHelper extends SQLiteOpenHelper {

        // Определение конструктора
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        // создание таблицы в базе данных
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            // sql-запрос для удаления таблицы с одинаковым именем
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}