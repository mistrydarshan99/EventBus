package fragments;

import android.view.View;
import android.widget.TextView;

import com.example.darshan.testapp.BusProvider;
import com.example.darshan.testapp.FragmentActivity;
import com.example.darshan.testapp.R;

import event.CustomerEvent;
import event.MessageEvent;

/**
 * Created by darshan.mistry on 10/31/2015.
 */
public class FragmnetA extends BaseFragment {

    private TextView tvTest;

    @Override
    protected int getContentView() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initViews(View rootView) {
        tvTest = (TextView) rootView.findViewById(R.id.tvTest);

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BusProvider.instance().postSticky(new MessageEvent("From Fragment A"));

                ((FragmentActivity) getActivity()).pushFragments(new FragmnetB(), null, true, false, true, false, "", "FragmentB", R.id.lytFrame);
            }
        });
    }

    @Override
    protected void loadData() {

    }

    public void onEventMainThread(CustomerEvent event) {

        tvTest.setText(event.getObj().getStats());

    }

    @Override
    public void onResume() {

        BusProvider.instance().registerSticky(this);

        super.onResume();

    }

    @Override
    public void onDestroyView() {

        BusProvider.instance().unregister(this);

        super.onDestroyView();
    }
}
