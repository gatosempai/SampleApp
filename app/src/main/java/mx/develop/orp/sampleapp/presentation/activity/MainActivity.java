package mx.develop.orp.sampleapp.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.develop.orp.sampleapp.R;
import mx.develop.orp.sampleapp.presentation.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentByTag("MainFragment");
        if(mainFragment == null) {
                mainFragment = new MainFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container_main_fragment, mainFragment, "MainFragment")
                        .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(mainFragment)
                    .commit();
        }
    }
}
