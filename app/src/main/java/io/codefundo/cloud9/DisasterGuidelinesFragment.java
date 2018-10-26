package io.codefundo.cloud9;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class DisasterGuidelinesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_disaster_guidelines, container, false);

        WebView wv = (WebView) rootView.findViewById(R.id.wv_guidelines);
        wv.loadUrl("file:///android_asset/index.html");

        return rootView;
    }

}
