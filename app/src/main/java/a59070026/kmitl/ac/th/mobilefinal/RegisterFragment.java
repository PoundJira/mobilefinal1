package a59070026.kmitl.ac.th.mobilefinal;


import android.content.ContentValues;
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

public class RegisterFragment extends Fragment {
    private SQLiteDatabase db;
    private ContentValues con_value;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initregisterbtn();
    }
    void initregisterbtn(){
        Button regis = (Button)getView().findViewById(R.id.register_rergister_btn);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user = (EditText)getView().findViewById(R.id.register_user);
                EditText name = (EditText)getView().findViewById(R.id.register_name);
                EditText age = (EditText)getView().findViewById(R.id.register_age);
                EditText pass = (EditText)getView().findViewById(R.id.register_password);

                String userStr = user.getText().toString();
                String nameStr = name.getText().toString();
                String ageStr = age.getText().toString();
                String passStr = pass.getText().toString();

                db = getActivity().openOrCreateDatabase("my.db", getActivity().MODE_PRIVATE, null);

                if (userStr.length() < 6 && userStr.length() > 12){
                    Toast.makeText(getActivity(),"coracter less than 6 or more than 12",Toast.LENGTH_SHORT).show();
                }
                else if (passStr.length() < 6){
                    Toast.makeText(getActivity(),"password should more than 6",Toast.LENGTH_SHORT).show();
                }
                else if (Integer.parseInt(ageStr)<10 && Integer.parseInt(ageStr)>80){
                    Toast.makeText(getActivity(),"age should more than 10 and less than 80",Toast.LENGTH_SHORT).show();
                }
                else{
                    ContentValues content = new ContentValues();
                    content.put("user_id", userStr);
                    content.put("name" , nameStr );
                    content.put("age", ageStr);
                    content.put("password", passStr);
                    db.insert("user_table",null,content);
                    Toast.makeText(getActivity(), "Complete",Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new LoginFragment()).addToBackStack(null).commit();

                }
            }
        });
    }
}
