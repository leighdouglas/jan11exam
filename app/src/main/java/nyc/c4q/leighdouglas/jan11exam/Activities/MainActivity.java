package nyc.c4q.leighdouglas.jan11exam.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.leighdouglas.jan11exam.ListFragment;
import nyc.c4q.leighdouglas.jan11exam.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, new ListFragment())
                    .commit();
        }
    }
}
