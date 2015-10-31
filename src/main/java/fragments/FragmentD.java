package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darshan.testapp.BusProvider;
import com.example.darshan.testapp.FragmentActivity;
import com.example.darshan.testapp.R;

import de.greenrobot.event.EventBus;
import event.MessageEvent;

/**
 * Created by darshan.mistry on 10/31/2015.
 */
public class FragmentD extends Fragment {

    private View rootView;
    private TextView tvTest;

    private EventBus bus = EventBus.getDefault();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_two, container, false);

        tvTest = (TextView) rootView.findViewById(R.id.tvTest);

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return rootView;
    }

    public void onEventMainThread(MessageEvent event) {

        tvTest.setText(event.getStrMsg());

        bus.removeStickyEvent(event);
    }

   /* @Override
    public void onResume() {

        bus.registerSticky(this);

        super.onResume();

    }*/

    @Override
    public void onStart() {
        super.onStart();
        bus.registerSticky(this);
    }

    @Override
    public void onStop() {
        bus.unregister(this);
        super.onStop();
    }

    /* @Override
    public void onDestroyView() {

        bus.unregister(this);

        super.onDestroyView();
    }*/
}
