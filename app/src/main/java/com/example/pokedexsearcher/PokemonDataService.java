package com.example.pokedexsearcher;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDataService {

    public static final String QUERY_FOR_POKEMONSEARCH = "https://pokeapi.co/api/v2/pokemon/";

    Context context;
    //konstruktor
    public PokemonDataService(Context context) {
        this.context = context;
    }


    //korzystam z biblioteki Volley w celu osiągniecia asynchronicznosci

    public interface PokemonInfoVolleyResponseListener {
        void onError(String message);

        void onResponse(PokedexEntryModel pokemon);
    }

    public void getPokemon(String pokemonNameOrId, PokemonInfoVolleyResponseListener pokemonInfoVolleyResponseListener) {


        String url = QUERY_FOR_POKEMONSEARCH + pokemonNameOrId;

        //wyciaganie dancyh z api
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray stats = response.getJSONArray("stats");
                    JSONArray types = response.getJSONArray("types");


                    PokedexEntryModel pokedexEntry = new PokedexEntryModel();
                    pokedexEntry.setName(((JSONObject) (response.getJSONArray("forms")).get(0)).getString("name"));
                    pokedexEntry.setId(response.getInt("id"));
                    pokedexEntry.setHeight(response.getInt("height"));
                    pokedexEntry.setWeight(response.getInt("weight"));

                    pokedexEntry.setImg_url((((response.getJSONObject("sprites")).getJSONObject("other")).getJSONObject("official-artwork")).getString("front_default"));

                    if(types.length() > 1){
                        pokedexEntry.setManyTypes(true);

                        pokedexEntry.setTypeB1(((types.getJSONObject(0)).getJSONObject("type")).getString("name"));
                        pokedexEntry.setTypeB2(((types.getJSONObject(1)).getJSONObject("type")).getString("name"));

                    }else{
                        pokedexEntry.setTypeA(((types.getJSONObject(0)).getJSONObject("type")).getString("name"));
                    }



                    pokedexEntry.setAttack((stats.getJSONObject(0)).getInt("base_stat"));
                    pokedexEntry.setDefense((stats.getJSONObject(1)).getInt("base_stat"));
                    pokedexEntry.setHp((stats.getJSONObject(2)).getInt("base_stat"));
                    pokedexEntry.setSp_attack((stats.getJSONObject(3)).getInt("base_stat"));
                    pokedexEntry.setSp_defense((stats.getJSONObject(4)).getInt("base_stat"));
                    pokedexEntry.setSpeed((stats.getJSONObject(5)).getInt("base_stat"));


                    pokemonInfoVolleyResponseListener.onResponse(pokedexEntry);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}

