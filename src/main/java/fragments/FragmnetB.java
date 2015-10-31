package fragments;

import android.view.View;
import android.widget.TextView;

import com.example.darshan.testapp.BusProvider;
import com.example.darshan.testapp.R;

import bean.CustomerBean;
import event.CustomerEvent;
import event.MessageEvent;

/**
 * Created by darshan.mistry on 10/31/2015.
 */
public class FragmnetB extends BaseFragment {

    private TextView tvTest;


    @Override
    protected int getContentView() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initViews(View rootView) {

        tvTest = (TextView) rootView.findViewById(R.id.tvTest);

    }

    @Override
    public void onResume() {

        BusProvider.instance().registerSticky(this);

        super.onResume();


    }

    public void onEventMainThread(MessageEvent event) {

        tvTest.setText(event.getStrMsg());

        BusProvider.instance().removeStickyEvent(event);
    }

    @Override
    public void onDestroyView() {

        CustomerBean obj = new CustomerBean();
        obj.setStats("From Fragment B");

        BusProvider.instance().postSticky(new CustomerEvent(obj));

        BusProvider.instance().unregister(this);

        super.onDestroyView();
    }

    @Override
    protected void loadData() {

    }
}
