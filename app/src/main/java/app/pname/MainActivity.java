package app.pname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_open).setOnClickListener(this::openAppLink);
    }

    public void openAppLink(View view) {
        EditText input = findViewById(R.id.input_pname);
        String packageName = input.getText().toString().trim();
        Pattern pattern = Pattern.compile("[a-z][a-z0-9_]*(\\.[a-z][a-z0-9_]*)+", Pattern.CASE_INSENSITIVE);
        if(pattern.matcher(packageName).matches()) {
            Uri uri = Uri.parse("market://details?id=" + packageName);
            Intent marketIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(marketIntent);
        } else {
            Toast.makeText(this, R.string.error_invalid, Toast.LENGTH_SHORT).show();
        }
    }
}
