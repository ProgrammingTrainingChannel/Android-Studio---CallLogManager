package training.ecea.calllogmanager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CallLogActivity extends AppCompatActivity {

    EditText txtPhoneNumber;
    Button btnClearLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

        txtPhoneNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        btnClearLog = (Button) findViewById(R.id.btnClearLog);
    }

    public void ClearSelectedPhoneFromCallLog(android.view.View btn) {
        String queryString = "NUMBER='" + txtPhoneNumber.getText().toString() + "'";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        this.getContentResolver().delete(CallLog.Calls.CONTENT_URI, queryString, null);
    }
}
