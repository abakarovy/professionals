package com.sodirhon.professionalskebede.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sodirhon.professionalskebede.R;
import com.sodirhon.professionalskebede.data.ExampleData;
import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import org.w3c.dom.Text;

public class CardItemComponent extends LinearLayout {

    private ImageView imageView;
    private TextView titleText;
    private Button addButton;
    private ImageButton favBtn;
    private TextView priceText;

    private String rubleChar = "₽";

    public CardItemComponent(Context context, AttributeSet attr) {
        super(context, attr);
        initialize(context, attr);
    }
    public CardItemComponent(Context context, int id, boolean favorited, String title, int price) {
        super(context);
        initialize(context, new ShoeItem(id, favorited, title, price));
    }

    public CardItemComponent(Context context, ShoeItem shoeItem) {
        super(context);
        initialize(context, shoeItem);
    }

    private void initialize(Context context, AttributeSet attr) {
        LayoutInflater.from(context).inflate(R.layout.card_item, this, true);
    }

    private void initialize(Context context, ShoeItem shoeItem) {
        LayoutInflater.from(context).inflate(R.layout.card_item, this, true);

        favBtn = findViewById(R.id.card_favBtn);
        setFavoriteBtnColor(shoeItem.favorited);

        imageView = findViewById(R.id.card_image);
        titleText = findViewById(R.id.titleText);
        setCardTitle(shoeItem.title);

        priceText = findViewById(R.id.priceText);
        setPrice(shoeItem.price);

        addButton = findViewById(R.id.button5);

        favBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!shoeItem.favorited) {
                    ExampleData.addShoeToFav(shoeItem);
                    setFavoriteBtnColor(true);
                } else {
                    setFavoriteBtnColor(false);
                    ExampleData.removeShoeFromFav(shoeItem);
                }
            }
        });
    }

    public void setFavoriteBtnColor(boolean state) {
        if (state) {
            favBtn.setImageResource(R.drawable.fav_icon_fill);
        } else {
            favBtn.setImageResource(R.drawable.fav_icon);
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
