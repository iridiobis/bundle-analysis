package es.iridiobis.bundleanalysis;


import android.content.Context;
import android.os.Bundle;

public class StateTestFragment extends TestFragment {

    /**
     * Initialize the fragent without arguments
     *
     * @return A new instance of fragment StateTestFragment.
     */
    public static TestFragment newInstanceWithoutArguments() {
        return new StateTestFragment();
    }

    /**
     * Initialize the fragent with arguments
     *
     * @return A new instance of fragment StateTestFragment.
     */
    public static TestFragment newInstanceWithArguments(final Context context) {
        TestFragment fragment = new StateTestFragment();
        setUpArguments(fragment, context);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE, getString(R.string.state));
    }

}
