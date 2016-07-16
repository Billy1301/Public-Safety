package billy.justincase;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private ImageButton policeButton;
    private ImageButton callButton;
    private ImageButton textButton;
    private ImageButton recordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        checkForCamera();

    }

    private void initializeViews(){
        policeButton = (ImageButton) findViewById(R.id.policeButton_id);
        callButton = (ImageButton) findViewById(R.id.callButton_id);
        textButton = (ImageButton) findViewById(R.id.textButton_id);
        recordButton = (ImageButton) findViewById(R.id.recordButton_id);
    }

    private void checkForCamera(){
        int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
        boolean deviceHasCameraFlag = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if(!deviceHasCameraFlag || numberOfCameras==0){
            Log.i(TAG, "Device has no camera " + numberOfCameras);
            Toast.makeText(MainActivity.this, "Device has no camera", Toast.LENGTH_SHORT).show();
            recordButton.setEnabled(false);
        } else {
            Log.e(TAG, "Device has camera" + deviceHasCameraFlag + numberOfCameras);
        }
    }



}


/*

Record a video with a camera app

static final int REQUEST_VIDEO_CAPTURE = 1;

private void dispatchTakeVideoIntent() {
    Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
    if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
    }
}

 */