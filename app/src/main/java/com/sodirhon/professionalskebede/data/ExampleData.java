package com.sodirhon.professionalskebede.data;

import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExampleData {

    private static List<ShoeItem> favShoes = new ArrayList<ShoeItem>();

    private static List<ShoeItem> allShoes = new ArrayList<ShoeItem>() {{
        for (int i = 0; i < 10; i++) {
            add(new ShoeItem(i,false, "NIGGER", 200112030));
        }
    }};

    private static List<ShoeItem> cart = new ArrayList<ShoeItem>();

    public static List<ShoeItem> getShoes() {
        CompletableFuture<List<ShoeItem>> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.toString());
            }

            return allShoes;
        });
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public static void addShoeToFav(ShoeItem shoeItem) {
        shoeItem.favorited = true;
        favShoes.add(shoeItem);
    }

    public static void removeShoeFromFav(ShoeItem shoeItem) {
        for (ShoeItem shoeItem1:favShoes) {
            if (shoeItem.id == shoeItem1.id) {
                shoeItem1.favorited = false;
                favShoes.remove(shoeItem.id);
            }
        }
    }

    public static List<ShoeItem> getFavShoes() {
        CompletableFuture<List<ShoeItem>> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return favShoes;
        });

        try {
            return completableFuture.get();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
