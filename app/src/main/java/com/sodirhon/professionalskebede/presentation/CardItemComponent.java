package com.sodirhon.professionalskebede.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sodirhon.professionalskebede.R;

public class CardItemComponent extends LinearLayout {

    private ImageView imageView;
    private TextView textView;
    private Button addButton;

    public CardItemComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.card_item, this, true);
        imageView = findViewById(R.id.card_image);
        textView = findViewById(R.id.textView10);

        addButton = findViewById(R.id.button5);
    }

    public void setCardTitle(String title) {
        textView.setText(title);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
