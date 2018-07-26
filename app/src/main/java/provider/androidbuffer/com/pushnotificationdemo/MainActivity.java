package provider.androidbuffer.com.pushnotificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title, name, body;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.etTitle);
        name = findViewById(R.id.etName);
        body = findViewById(R.id.etBody);
        btn = findViewById(R.id.btn);

        setNotification();
    }

    private void setNotification(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = title.getText().toString().trim();
                String n = name.getText().toString().trim();
                String b = body.getText().toString().trim();

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new Notification.Builder(getApplicationContext()).setContentTitle(t)
                        .setContentText(n).setSmallIcon(R.drawable.setting).build();

                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                notificationManager.notify(0,notification);
            }
        });
    }
}
