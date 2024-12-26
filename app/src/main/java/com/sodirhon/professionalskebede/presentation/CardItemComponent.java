package com.sodirhon.professionalskebede.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sodirhon.professionalskebede.R;
import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import org.w3c.dom.Text;

public class CardItemComponent extends LinearLayout {

    private ImageView imageView;
    private TextView titleText;
    private Button addButton;
    private ImageButton favBtn;
    private TextView priceText;

    private String rubleChar = "₽";

    public CardItemComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, false, "Nike Air Max", 755);
    }

    public CardItemComponent(Context context) {
        super(context);
        initialize(context, false, "Nike Air Max", 755);
    }

    public CardItemComponent(Context context, boolean favorited, String title, int price) {
        super(context);
        initialize(context, favorited, title, price);
    }

    public CardItemComponent(Context context, ShoeItem shoeItem) {
        super(context);
        initialize(context, shoeItem.favorited, shoeItem.title, shoeItem.price);
    }

    private void initialize(Context context, boolean favorited, String title,  int price) {
        LayoutInflater.from(context).inflate(R.layout.card_item, this, true);

        favBtn = findViewById(R.id.card_favBtn);
        setFavoriteBtnColor(favorited);

        imageView = findViewById(R.id.card_image);
        titleText = findViewById(R.id.titleText);
        setCardTitle(titleText.getText().toString());

        priceText = findViewById(R.id.priceText);
        setPrice(price);

        addButton = findViewById(R.id.button5);
    }

    public void setFavoriteBtnColor(boolean state) {
        if (state) {
            favBtn.setImageResource(R.drawable.fav_icon_fill);
            favBtn.setColorFilter(R.color.colorSecondary);
        } else {
            favBtn.setImageResource(R.drawable.fav_icon);
            favBtn.setColorFilter(R.color.colorSubTextDark);
        }

    }
    public void setCardTitle(String title) {
        titleText.setText(title);
    }

    public void setPrice(int price) {
        priceText.setText(rubleChar + price);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}
