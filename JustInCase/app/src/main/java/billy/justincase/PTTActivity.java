package billy.justincase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Billy on 7/16/16.
 */
public class PTTActivity extends AppCompatActivity {


    private Button PTTButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptt);

        PTTButton = (Button) findViewById(R.id.PTT_button_id);
        setButton();

    }

    private void setButton(){
        PTTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                invoke1to1("2647950719"); //anthony phone
//                invokeLocation("2647950721"); //cher phone
//                invoke1to1("2647950721"); // cher
//                invoke1to1("2647950720"); //bill
//                invoke1to1AudioMSG("2647950720");
               //invokeLocation("2647950721");
//                invokeAudioMSG("2647950721");
//                invoke1to1AudioMSG("2647950721");
//                invoke_1_ALL_PTTCall("2647950721,2647950719");

                invokeLocationAndAudio("2647950721");

            }
        });
    }

    private void invokeLocationAndAudio(String MDN)
    {
        String EventType = "109,112";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "0,0";
        String ParaType = "20,0";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }



    private void invoke_1_ALL_PTTCall(String MDN)
    {
        // Event Type for PTT call is 101.
        String EventType = "101,112";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "2,2";
        String ParaType = "60,0";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }


    private void invoke1to1(String MDN){
        // Event Type for PTT call is 101.
        String EventType = "101";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "0";
        String ParaType = "60";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }
    private void invokeLocation(String MDN){
        // Event Type for PTT call is 101.
        String EventType = "112";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "0";
        String ParaType = "0";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }


    private void invoke1to1AudioMSG(String MDN){
        // Event Type for PTT call is 101.
        String EventType = "112,109";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "0,0";
        String ParaType = "0,10";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }
    private void invokeAudioMSG(String MDN){
        // Event Type for PTT call is 101.
        String EventType = "109";
        // Call Type for 1-1 PTT call is 0.
        String CallType = "0";
        String ParaType = "20";
        String commandString = "";
        commandString = "ET="+ EventType + ";CT="+CallType+ ";PT="+ParaType+";UR="+ MDN +";";
        // Send Broadcast here..
        Intent intent = new Intent();
        // Broadcast action
        intent.setAction("com.kodiak.intent.action.mobileapi");
        // Data - formatted command string
        intent.putExtra("PTTData",commandString);
        sendBroadcast(intent);
    }

}
