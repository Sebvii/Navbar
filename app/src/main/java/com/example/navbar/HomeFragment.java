package com.example.navbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    // Declare views
    private TextView greetingText;
    private TextView emissionText;
    private ProgressBar circularProgressBar;
    private TextView co2Value;
    private TextView co2Label;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Create root layout programmatically
        LinearLayout rootLayout = new LinearLayout(getActivity());
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        rootLayout.setPadding(0, 24, 0, 24);

        // Greeting TextView
        greetingText = new TextView(getActivity());
        greetingText.setText("Hello, Juan Dela Cruz");
        greetingText.setTextSize(20);
        greetingText.setGravity(Gravity.CENTER_HORIZONTAL);
        rootLayout.addView(greetingText);

        // Emission TextView
        emissionText = new TextView(getActivity());
        emissionText.setText("You have emitted 120 kg CO2 this week");
        emissionText.setTextSize(16);
        emissionText.setGravity(Gravity.CENTER_HORIZONTAL);
        rootLayout.addView(emissionText);

        // CO2 Circular ProgressBar
        circularProgressBar = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleHorizontal);
        circularProgressBar.setMax(200);
        circularProgressBar.setProgress(120);
        rootLayout.addView(circularProgressBar);

        // CO2 Value and Label TextViews
        co2Value = new TextView(getActivity());
        co2Value.setText("120");
        co2Value.setTextSize(24);
        co2Label = new TextView(getActivity());
        co2Label.setText("CO2");
        co2Label.setTextSize(16);
        rootLayout.addView(co2Value);
        rootLayout.addView(co2Label);

        // Title: "What YOU can do"
        TextView title = new TextView(getActivity());
        title.setText("What YOU can do");
        title.setTextColor(Color.BLACK);
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        rootLayout.addView(title);

        // Action Options Layout
        LinearLayout actionOptionsLayout = new LinearLayout(getActivity());
        actionOptionsLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams actionOptionsParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        actionOptionsParams.topMargin = 16;
        actionOptionsLayout.setLayoutParams(actionOptionsParams);

        // Option 1: Change the way you travel
        LinearLayout option1 = createOption("Change the way you travel", R.drawable.ic_bike);
        actionOptionsLayout.addView(option1);

        // Option 2: Reduce energy use
        LinearLayout option2 = createOption("Reduce energy use", R.drawable.ic_energy_saver);
        LinearLayout.LayoutParams option2Params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        option2Params.setMarginStart(16);
        option2.setLayoutParams(option2Params);
        actionOptionsLayout.addView(option2);

        rootLayout.addView(actionOptionsLayout);

        // Enterprises and Discounts Section
        TextView enterprisesTitle = new TextView(getActivity());
        enterprisesTitle.setText("SUPPORT SUSTAINABILITY. CUT CARBON. GAIN REWARDS!");
        enterprisesTitle.setTextColor(Color.BLACK);
        enterprisesTitle.setTextSize(18);
        enterprisesTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        enterprisesTitle.setPadding(0, 24, 0, 0);
        rootLayout.addView(enterprisesTitle);

        TextView enterprisesSubtitle = new TextView(getActivity());
        enterprisesSubtitle.setText("Enterprises and Discounts");
        enterprisesSubtitle.setTextColor(Color.BLACK);
        enterprisesSubtitle.setTextSize(14);
        enterprisesSubtitle.setGravity(Gravity.CENTER_HORIZONTAL);
        enterprisesSubtitle.setPadding(0, 8, 0, 0);
        rootLayout.addView(enterprisesSubtitle);

        // Enterprises Layout
        LinearLayout enterprisesLayout = new LinearLayout(getActivity());
        enterprisesLayout.setOrientation(LinearLayout.HORIZONTAL);
        enterprisesLayout.setPadding(0, 16, 0, 0);

        // Enterprise 1: Masugid Enterprise
        LinearLayout enterprise1 = createEnterprise("Masugid Enterprise", R.drawable.ic_masugid_enterprise);
        enterprisesLayout.addView(enterprise1);

        // Enterprise 2: WA Enterprise
        LinearLayout enterprise2 = createEnterprise("WA Enterprise", R.drawable.ic_wa_enterprise);
        LinearLayout.LayoutParams enterprise2Params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        enterprise2.setLayoutParams(enterprise2Params);
        enterprisesLayout.addView(enterprise2);

        rootLayout.addView(enterprisesLayout);

        // Learn More Button
        TextView learnMoreButton = new TextView(getActivity());
        learnMoreButton.setText("Learn more");
        learnMoreButton.setTextSize(14);
        learnMoreButton.setGravity(Gravity.CENTER_HORIZONTAL);
        learnMoreButton.setPadding(0, 16, 0, 0);
        learnMoreButton.setClickable(true);
        rootLayout.addView(learnMoreButton);

        // Return the dynamically created root layout as the fragment's view
        return rootLayout;
    }

    // Helper method to create option layout
    private LinearLayout createOption(String text, int iconResId) {
        LinearLayout optionLayout = new LinearLayout(getActivity());
        optionLayout.setOrientation(LinearLayout.VERTICAL);
        optionLayout.setPadding(8, 8, 8, 8);
        optionLayout.setBackgroundResource(R.drawable.rounded_background);
        LinearLayout.LayoutParams optionParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        optionLayout.setLayoutParams(optionParams);

        // Icon
        ImageView icon = new ImageView(getActivity());
        icon.setImageResource(iconResId);
        icon.setLayoutParams(new LinearLayout.LayoutParams(48, 48));
        optionLayout.addView(icon);

        // Text
        TextView optionText = new TextView(getActivity());
        optionText.setText(text);
        optionText.setTextColor(Color.BLACK);
        optionText.setTextSize(16);
        optionText.setGravity(Gravity.CENTER);
        optionText.setPadding(0, 8, 0, 0);
        optionLayout.addView(optionText);

        return optionLayout;
    }

    // Helper method to create enterprise layout
    private LinearLayout createEnterprise(String name, int iconResId) {
        LinearLayout enterpriseLayout = new LinearLayout(getActivity());
        enterpriseLayout.setOrientation(LinearLayout.VERTICAL);
        enterpriseLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        enterpriseLayout.setPadding(8, 8, 8, 8);
        enterpriseLayout.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

        // Icon
        ImageView icon = new ImageView(getActivity());
        icon.setImageResource(iconResId);
        icon.setLayoutParams(new LinearLayout.LayoutParams(48, 48));
        enterpriseLayout.addView(icon);

        // Name
        TextView nameText = new TextView(getActivity());
        nameText.setText(name);
        nameText.setTextColor(Color.BLACK);
        nameText.setTextSize(14);
        nameText.setGravity(Gravity.CENTER);
        nameText.setPadding(0, 8, 0, 0);
        enterpriseLayout.addView(nameText);

        return enterpriseLayout;
    }
}
