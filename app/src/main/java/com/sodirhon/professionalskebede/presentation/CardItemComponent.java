package com.sodirhon.professionalskebede;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardItemComponent extends LinearLayout {

    private ImageView imageView;
    private TextView textView;

    public CardItemComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.card_item, this, true);
        imageView = findViewById(R.id.card_image);
        textView = findViewById(R.id.card_title);
    }

    public void setCardTitle(String title) {
        textView.setText(title);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
