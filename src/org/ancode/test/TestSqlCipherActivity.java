package org.ancode.test;

import java.io.File;

import net.sqlcipher.database.SQLiteDatabase;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class TestSqlCipherActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InitializeSQLCipher();
    }
    
    private void InitializeSQLCipher(){
    	SQLiteDatabase.loadLibs(this);
    	//File databaseFile = getDatabasePath("demo.db");
    	File databaseFile = new File(Environment.getExternalStorageDirectory()+"/MIXUN/db/", "demo.db");

    	Log.v("test", databaseFile.getPath());
    	if(databaseFile.mkdirs()){
    		Log.v("test", "Created");
    	}else{
    		Log.v("test", "Create failed");
    	}
    	databaseFile.delete();
    	SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile,  "test123", null);
    	database.execSQL("create table t1(a,b)");
    	database.execSQL("insert into t1(a, b) values(?, ?)",
    			new Object[]{"one for the money", "two for the show"});
    }
}