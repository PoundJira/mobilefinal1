package a59070026.kmitl.ac.th.mobilefinal;


import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //open database or create for use app at first time
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE,null);

        //execute command to create table "sleep_table"
        //this table[_id, date, sleep time , wakeup time , duration]
        myDB.execSQL("CREATE TABLE IF NOT EXISTS user_table(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id VARCHAR(255), " +
                "name VARCHAR(255)," +
                "age VARCHAR(255), " +
                "password VARCHAR(255))");

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_view, new LoginFragment())
                    .commit();
        }
    }
}
