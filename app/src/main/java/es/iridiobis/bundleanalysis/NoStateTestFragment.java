package es.iridiobis.bundleanalysis;

import android.content.Context;

public class NoStateTestFragment extends TestFragment {

    /**
     * Initialize the fragent without arguments
     *
     * @return A new instance of fragment NoStateTestFragment.
     */
    public static NoStateTestFragment newInstanceWithoutArguments() {
        return new NoStateTestFragment();
    }

    /**
     * Initialize the fragent with arguments
     *
     * @return A new instance of fragment StateTestFragment.
     */
    public static NoStateTestFragment newInstanceWithArguments(final Context context) {
        final NoStateTestFragment fragment = new NoStateTestFragment();
        setUpArguments(fragment, context);
        return fragment;
    }

}
