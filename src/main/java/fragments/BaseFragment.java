package fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darshan.testapp.BaseActivity;

/**
 * Created by kushan.shah on 10/9/15.
 */
public abstract class BaseFragment extends Fragment {

    protected View rootView;

    private boolean hasInitializedRootView = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);


    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return getPersistentView(inflater, container, savedInstanceState, getContentView());

        /*rootView = inflater.inflate(getContentView(), container, false);

        initViews(rootView);

        return rootView;*/

    }

    public View getPersistentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int layout) {

        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(layout, null);
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            container.removeView(rootView);
        }

        return rootView;
    }

    protected abstract int getContentView();

    protected abstract void initViews(View rootView);

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        loadData();
    }

    protected abstract void loadData();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!hasInitializedRootView) {

            hasInitializedRootView = true;

            initViews(view);
        }
    }
}
