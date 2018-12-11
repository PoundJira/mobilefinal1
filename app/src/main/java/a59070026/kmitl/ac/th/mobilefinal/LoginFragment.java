package a59070026.kmitl.ac.th.mobilefinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private SQLiteDatabase db;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = getActivity().openOrCreateDatabase("my.db", getActivity().MODE_PRIVATE, null);



        initloginbtn();
        initregisterbtn();
    }
    void initloginbtn(){
        Button log = getView().findViewById(R.id.login_btn);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = getView().findViewById(R.id.login_name);
                EditText pass = getView().findViewById(R.id.login_password);

                String nameStr = name.getText().toString();
                String passStr = pass.getText().toString();

                if (nameStr.equals("") && passStr.equals("")){
                    Toast.makeText(getActivity(),"Please fill out this form",Toast.LENGTH_SHORT).show();
                }
                else{
                    String selectQuery = "SELECT * FROM user_table WHERE user_id = '" + name + "' AND password = '" + pass+"'";
                    Cursor pointer_query = db.rawQuery(selectQuery, null);
                    if (pointer_query != null){
                        if (pointer_query.moveToFirst()){
//                            id = pointer_query.getInt(0);
//                            user_id = pointer_query.getString(1);
//                            name = pointer_query.getString(2);
//                            age = pointer_query.getString(3);
//                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("my_pref", Context.MODE_PRIVATE);
//                            sharedPreferences.edit().putInt("id" , id).commit();
//                            sharedPreferences.edit().putString("user_id" , user_id).commit();
//                            sharedPreferences.edit().putString("name" , name).commit();
//                            sharedPreferences.edit().putString("age" , age).commit();
//                            Toast.makeText(getActivity(), "Login Success",Toast.LENGTH_SHORT).show();
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new HomeFragment()).addToBackStack(null).commit();
                        }
                    }
                }

            }
        });
    }
    void initregisterbtn(){

    }
}
