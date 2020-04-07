package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObjectName = jsonObject.getJSONObject("name");
            String mainName = jsonObjectName.getString("mainName");
            JSONArray alsoKnownAsJsonArray = jsonObjectName.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            if (alsoKnownAsJsonArray != null) {
                for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                    alsoKnownAsList.add(alsoKnownAsJsonArray.getString(i));
                }
            }
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            if (alsoKnownAsJsonArray != null) {
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredientsList.add(ingredients.getString(i));
                }
            }

            sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
