package es.iridiobis.bundleanalysis;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class TestFragment extends Fragment {

    protected static final String ARGUMENT = "argument";
    protected static final String STATE = "state";

    @BindView(R.id.result_arguments) TextView argumentsResult;
    @BindView(R.id.result_state) TextView stateResult;

    private String argument;
    private String state;

    protected static void setUpArguments(final TestFragment fragment, final Context context) {
        Bundle args = new Bundle();
        args.putString(ARGUMENT, context.getString(R.string.argument));
        fragment.setArguments(args);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            state = getString(R.string.no_state);
        } else if (savedInstanceState.containsKey(STATE)) {
            state = savedInstanceState.getString(STATE);
        } else {
            state = getString(R.string.empty_state);
        }
        if (getArguments() == null) {
            argument = getString(R.string.no_args);
        } else if (getArguments().containsKey(ARGUMENT)) {
            argument = getArguments().getString(ARGUMENT);
        } else {
            argument = getString(R.string.empty_args);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        argumentsResult.setText(argument);
        stateResult.setText(state);
    }
}
