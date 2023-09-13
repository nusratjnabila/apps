package com.example.peakperformers.ui.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.KeyEvent;
import com.example.peakperformers.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.example.peakperformers.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ProgressBar loadingPB = binding.idPBLoading;

        WebView homeWebView = root.findViewById(R.id.idWebViewHome); // Find WebView by ID

        homeWebView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        homeWebView.loadUrl("https://sabbirahomedrobin.com/work/");
        homeWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingPB.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingPB.setVisibility(View.GONE);
            }
        });

        homeWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (homeWebView.canGoBack()) {
                                homeWebView.goBack();
                                return true; // Consume the event
                            }
                    }
                }
                return false;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
