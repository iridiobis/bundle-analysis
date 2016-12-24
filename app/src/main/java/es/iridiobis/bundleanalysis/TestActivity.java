package es.iridiobis.bundleanalysis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TestActivity extends AppCompatActivity {

    private static final String MODE_EXTRA = "TestActivity.MODE_EXTRA";

    public static Intent startIntent(final @Mode int mode, final Context context) {
        final Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra(MODE_EXTRA, mode);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int mode = getIntent().getIntExtra(MODE_EXTRA, 0);
        if (savedInstanceState == null) {
            if (mode == Mode.NO_ARGS_NO_STATE) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, NoStateTestFragment.newInstanceWithoutArguments())
                        .commit();
            } else if (mode == Mode.ARGS_NO_STATE) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, NoStateTestFragment.newInstanceWithArguments(this))
                        .commit();
            } else if (mode == Mode.NO_ARGS_STATE) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, StateTestFragment.newInstanceWithoutArguments())
                        .commit();
            } else if (mode == Mode.ARGS_STATE) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, StateTestFragment.newInstanceWithArguments(this))
                        .commit();
            }
        }

        if (mode == Mode.NO_ARGS_NO_STATE) {
            setTitle(R.string.no_args_no_state);
        } else if (mode == Mode.ARGS_NO_STATE) {
            setTitle(R.string.args_no_state);
        } else if (mode == Mode.NO_ARGS_STATE) {
            setTitle(R.string.no_args_state);
        } else if (mode == Mode.ARGS_STATE) {
            setTitle(R.string.args_state);
        } else if (savedInstanceState == null) {
            setTitle(R.string.creation_wtf);
        } else {
            setTitle(R.string.recreation_wtf);
        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Mode.NO_ARGS_NO_STATE, Mode.ARGS_NO_STATE, Mode.NO_ARGS_STATE, Mode.ARGS_STATE})
    public @interface Mode {
        int NO_ARGS_NO_STATE = 1;
        int ARGS_NO_STATE = 2;
        int NO_ARGS_STATE = 3;
        int ARGS_STATE = 4;
    }

}
