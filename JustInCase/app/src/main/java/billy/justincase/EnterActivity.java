package billy.justincase;

import android.Manifest;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 12;
    private EditText contactNumET;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        requestUserForPermission();
        contactNumET = (EditText)findViewById(R.id.enter_contact_num_id);
        saveButton = (Button)findViewById(R.id.enter_submit_id);
    }


    @TargetApi(23)
    private void requestUserForPermission(){
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion < Build.VERSION_CODES.M){
            // This OS version is lower then Android M, therefore we have old permission model and should not ask for permission
            return;
        }
        String[] permissions = new String[]{Manifest.permission.CALL_PHONE};
        requestPermissions(permissions, PERMISSION_REQUEST_CODE);
    }

}
