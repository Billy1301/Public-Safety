package billy.justincase;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by adao1 on 7/15/2016.
 */
public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i < appWidgetIds.length; i++) {
            int currentWidgetId = appWidgetIds[i];
            String url = "http://www.tutorialspoint.com";


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
            Log.i("", "onUpdate: ");

            String policeNum = "6504400404"; //temp number
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+policeNum));

            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
            PendingIntent callPolicePending = PendingIntent.getActivity(context,0,callIntent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_main);

            views.setOnClickPendingIntent(R.id.call_police_button, callPolicePending);
            views.setOnClickPendingIntent(R.id.call_friend_button, pending);
            views.setOnClickPendingIntent(R.id.text_contacts_button, pending);
            views.setOnClickPendingIntent(R.id.record_button, pending);
//            views.setOnClickPendingIntent(R.id.button2, );
            appWidgetManager.updateAppWidget(currentWidgetId, views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
        }

    }
}
