package nyc.c4q.leighdouglas.jan11exam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.leighdouglas.jan11exam.KeyConstants;
import nyc.c4q.leighdouglas.jan11exam.R;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class KeyImageActivity extends AppCompatActivity {
    private boolean clickedOnce = false;
    private ImageView imageView;
    private static String IMAGE_BASE_URL = "http://jsjrobotics.nyc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_image);
        imageView = (ImageView) findViewById(R.id.key_image);

        Intent intent = getIntent();

        if (!intent.getStringExtra(KeyConstants.EXTRA_IMAGE_URL).isEmpty()) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_BASE_URL + intent.getStringExtra(KeyConstants.EXTRA_IMAGE_URL))
                    .into(imageView);
        } else {
            Toast.makeText(this, "No image to display",
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (clickedOnce) {
            clickedOnce = false;
            super.onBackPressed();
        } else {
            clickedOnce = true;
            Toast.makeText(this, "Toast",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
