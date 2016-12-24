package es.iridiobis.bundleanalysis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_no_args_no_state)
    void goToNoArgsNoState() {
        startActivity(TestActivity.startIntent(TestActivity.Mode.NO_ARGS_NO_STATE, MainActivity.this));
    }

    @OnClick(R.id.main_args_no_state)
    void goToArgsNoState() {
        startActivity(TestActivity.startIntent(TestActivity.Mode.ARGS_NO_STATE, MainActivity.this));
    }

    @OnClick(R.id.main_no_args_state)
    void goToNoArgsState() {
        startActivity(TestActivity.startIntent(TestActivity.Mode.NO_ARGS_STATE, MainActivity.this));
    }

    @OnClick(R.id.main_args_state)
    void goToArgsState() {
        startActivity(TestActivity.startIntent(TestActivity.Mode.ARGS_STATE, MainActivity.this));
    }
}
