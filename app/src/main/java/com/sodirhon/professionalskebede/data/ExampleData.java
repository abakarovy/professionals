package com.sodirhon.professionalskebede.data;

import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExampleData {

    public static List<ShoeItem> getShoes() {
        CompletableFuture<List<ShoeItem>> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.toString());
            }

            List<ShoeItem> shoeItems = new ArrayList<ShoeItem>();

            for (int i = 0; i < 7; i++) {
                ShoeItem shoeItem = new ShoeItem(true,"Nike Air Max", 777);

                shoeItems.add(shoeItem);
            }
            return shoeItems;
        });
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }
}
