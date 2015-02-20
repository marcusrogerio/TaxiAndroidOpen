//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.opentaxi.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.opentaxi.android.R.id;
import com.opentaxi.models.MapRequest;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;
import org.mapsforge.core.model.LatLong;

public final class LongPressMapAction_
    extends LongPressMapAction
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    public final static String MAP_REQUEST_EXTRA = "mapRequest";
    private Handler handler_ = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        injectExtras_();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static LongPressMapAction_.IntentBuilder_ intent(Context context) {
        return new LongPressMapAction_.IntentBuilder_(context);
    }

    public static LongPressMapAction_.IntentBuilder_ intent(Fragment supportFragment) {
        return new LongPressMapAction_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        {
            View view = hasViews.findViewById(id.okButton);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        LongPressMapAction_.this.okButton();
                    }

                }
                );
            }
        }
    }

    private void injectExtras_() {
        Bundle extras_ = getIntent().getExtras();
        if (extras_!= null) {
            if (extras_.containsKey(MAP_REQUEST_EXTRA)) {
                mapRequest = extras_.getParcelable(MAP_REQUEST_EXTRA);
            }
        }
    }

    @Override
    public void setIntent(Intent newIntent) {
        super.setIntent(newIntent);
        injectExtras_();
    }

    @Override
    public void showTextCircle(final MapRequest address) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                LongPressMapAction_.super.showTextCircle(address);
            }

        }
        );
    }

    @Override
    public void showAddress(final LatLong position) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    LongPressMapAction_.super.showAddress(position);
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<LongPressMapAction_.IntentBuilder_>
    {

        private Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, LongPressMapAction_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            super(fragment.getActivity(), LongPressMapAction_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                super.startForResult(requestCode);
            }
        }

        public LongPressMapAction_.IntentBuilder_ mapRequest(MapRequest mapRequest) {
            return super.extra(MAP_REQUEST_EXTRA, mapRequest);
        }

    }

}