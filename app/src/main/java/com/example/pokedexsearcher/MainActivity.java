package com.example.pokedexsearcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {



    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }


    Button button_search;
    EditText et_dataInput;
    ConstraintLayout cl_typeA, cl_typeB;
    ImageView img_pokemon;
    ScrollView scrollView_pokeInfo;
    TextView textView_pokemonName, textView_pokemonId, textView_heightValue, textView_weightValue,
            textView_typeA1, textView_typeB1, textView_typeB2, textView_statHPValue,
            textView_statAttackValue, textView_statDefenseValue, textView_statSpecialAttackValue,
            textView_statSpecialDefenseValue, textView_statSpeedValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_search = findViewById(R.id.button_search);
        et_dataInput = findViewById(R.id.et_dataInput);
        scrollView_pokeInfo = findViewById(R.id.scrollView_pokeInfo);
        textView_pokemonName = findViewById(R.id.textView_pokemonName);
        textView_pokemonId = findViewById(R.id.textView_pokemonId);
        textView_heightValue = findViewById(R.id.textView_heightValue);
        textView_weightValue = findViewById(R.id.textView_weightValue);
        textView_typeA1 = findViewById(R.id.textView_typeA1);
        textView_typeB1 = findViewById(R.id.textView_typeB1);
        textView_typeB2 = findViewById(R.id.textView_typeB2);
        textView_statHPValue = findViewById(R.id.textView_statHPValue);
        textView_statAttackValue = findViewById(R.id.textView_statAttackValue);
        textView_statDefenseValue = findViewById(R.id.textView_statDefenseValue);
        textView_statSpecialAttackValue= findViewById(R.id.textView_statSpecialAttackValue);
        textView_statSpecialDefenseValue = findViewById(R.id.textView_statSpecialDefenseValue);
        textView_statSpeedValue= findViewById(R.id.textView_statSpeedValue);
        cl_typeA = findViewById(R.id.cl_typeA);
        cl_typeB = findViewById(R.id.cl_typeB);
        img_pokemon = findViewById(R.id.imageView_pokemon);

        PokemonDataService pokemonDataService = new PokemonDataService(MainActivity.this);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                pokemonDataService.getPokemon(et_dataInput.getText().toString(), new PokemonDataService.PokemonInfoVolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "nie dziala", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(PokedexEntryModel pokemon) {


                        textView_pokemonName.setText( capitalize(pokemon.getName()));

                        String pokemon_idText = "#";

                        if(pokemon.getId() >= 100){
                            pokemon_idText = pokemon_idText + Integer.toString(pokemon.getId());
                        } else if(pokemon.getId() > 9 && pokemon.getId() < 100){
                            pokemon_idText = pokemon_idText + "0" + Integer.toString(pokemon.getId());
                        } else{
                            pokemon_idText = pokemon_idText + "00" + Integer.toString(pokemon.getId());
                        }

                        textView_pokemonId.setText(pokemon_idText);

                        scrollView_pokeInfo.setVisibility(View.VISIBLE);
                        if(pokemon.isManyTypes()){

                            cl_typeA.setVisibility(View.INVISIBLE);
                            cl_typeB.setVisibility(View.VISIBLE);
                            textView_typeB1.setText(capitalize(pokemon.typeB1));
                            textView_typeB2.setText(capitalize(pokemon.typeB2));


                        }else{

                            cl_typeA.setVisibility(View.VISIBLE);
                            textView_typeA1.setText(capitalize(pokemon.typeA));
                            cl_typeB.setVisibility(View.INVISIBLE);

                        }


                        textView_heightValue.setText(Double.toString(pokemon.getHeight()) );
                        textView_weightValue.setText(Double.toString(pokemon.getWeight()) );

                        textView_statHPValue.setText(Integer.toString(pokemon.getHp()));
                        textView_statAttackValue.setText(Integer.toString(pokemon.getAttack()));
                        textView_statDefenseValue.setText(Integer.toString(pokemon.getDefense()));
                        textView_statSpecialAttackValue.setText(Integer.toString(pokemon.getSp_attack()));
                        textView_statSpecialDefenseValue.setText(Integer.toString(pokemon.getSp_defense()));
                        textView_statSpeedValue.setText(Integer.toString(pokemon.getSpeed()));

                        Glide.with(MainActivity.this).load(pokemon.getImg_url()).into(img_pokemon);


                    }
                });
            }
        });

    }
}