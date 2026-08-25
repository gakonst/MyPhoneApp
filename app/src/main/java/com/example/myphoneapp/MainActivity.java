package com.example.myphoneapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int dp(float value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    private TextView text(String value, float size, int color) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int background = Color.rgb(11, 16, 32);
        int primary = Color.rgb(244, 247, 255);
        int muted = Color.rgb(167, 176, 197);
        int accent = Color.rgb(119, 224, 198);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(dp(24), dp(24), dp(24), dp(24));
        page.setBackgroundColor(background);

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER_HORIZONTAL);
        card.setPadding(dp(28), dp(36), dp(28), dp(32));
        card.setBackgroundResource(com.example.myphoneapp.R.drawable.card_background);
        page.addView(card, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView badge = text("MY", 22, background);
        badge.setGravity(Gravity.CENTER);
        badge.setBackgroundResource(com.example.myphoneapp.R.drawable.app_icon);
        LinearLayout.LayoutParams badgeParams = new LinearLayout.LayoutParams(dp(72), dp(72));
        badgeParams.bottomMargin = dp(24);
        card.addView(badge, badgeParams);

        TextView title = text("MyPhoneApp", 30, primary);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        card.addView(title);

        TextView subtitle = text("Your new Android app is ready.", 16, muted);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        subtitleParams.topMargin = dp(10);
        subtitleParams.bottomMargin = dp(28);
        card.addView(subtitle, subtitleParams);

        Button button = new Button(this);
        button.setText("TRY IT");
        button.setTextColor(background);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setTypeface(null, android.graphics.Typeface.BOLD);
        button.setBackgroundColor(accent);
        button.setPadding(dp(24), dp(12), dp(24), dp(12));
        button.setOnClickListener(v -> Toast.makeText(this, "MyPhoneApp works!", Toast.LENGTH_SHORT).show());
        card.addView(button, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(52)));

        setContentView(page);
    }
}
