package com.example.pokedexsearcher;

import java.util.ArrayList;

public class PokedexColors {

    //klasa sluzaca do wyciagania odpowiednich kolorow, tak zeby pasowaly do typow pokemona

    String mainTypeColor, secondaryTypeColor;
    String mainColorHexValue, secondaryColorHexValue, mainTypeHexValue;

    String[][] colors ={{"normal", "fire", "water", "electric", "grass", "ice", "fighting", "poison",
            "ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "dark", "steel", "fairy"},
            {"#A8A77A","#EE8130", "#6390F0", "#F7D02C", "#7AC74C", "#96D9D6", "#C22E28", "#A33EA1",
                    "#E2BF65", "#A98FF3", "#F95587", "#A6B91A", "#B6A136", "#735797", "#6F35FC", "#705746", "#B7B7CE", "#D685AD"},
            {"#EAE9CE", "#FABB8C", "#C1D1F1", "#FFF1B4", "#CEF8B5", "#E1FAF9", "#FF8480", "#FBA2FA", "#FFE9AF",
                    "#E0D5FF", "#FFA8C3", "#F2FBAE", "#FFF4BC", "#B79ED8", "#BCA1FF", "#D5BBA9", "#F2F2FB", "#FAC9E1"}};

    public String getMainTypeHexValue() {
        return mainTypeHexValue;
    }

    public void setMainTypeHexValue(String mainTypeHexValue) {
        this.mainTypeHexValue = mainTypeHexValue;
    }

    //2 konstruktory w zaleznosci czy dany pokemon ma 1 czy 2 typy

    public PokedexColors(String mainTypeColor, String secondaryTypeColor) {
        this.mainTypeColor = mainTypeColor;
        this.secondaryTypeColor = secondaryTypeColor;
        setColorHexValue(true, this.mainTypeColor);
        setColorHexValue(false, this.secondaryTypeColor);
    }

    public PokedexColors(String mainTypeColor) {
        this.mainTypeColor = mainTypeColor;
        this.secondaryTypeColor = mainTypeColor;
        setColorHexValue(true, this.mainTypeColor);
        setColorHexValue(false, this.secondaryTypeColor);
    }

    public void setColorHexValue(boolean isMain, String typeColor){

        for (int i=0; i < 18; i++){
            if (colors[0][i].equals(typeColor)){
                if (isMain){
                    mainColorHexValue = colors[2][i];
                    mainTypeHexValue = colors[1][i];
                    break;
                }else if(!isMain){
                    secondaryColorHexValue = colors[1][i];
                }
            }
        }

    }



    public String getMainTypeColor() {
        return mainTypeColor;
    }

    public void setMainTypeColor(String mainTypeColor) {
        this.mainTypeColor = mainTypeColor;
    }

    public String getSecondaryTypeColor() {
        return secondaryTypeColor;
    }

    public void setSecondaryTypeColor(String secondaryTypeColor) {
        this.secondaryTypeColor = secondaryTypeColor;
    }

    public String getMainColorHexValue() {
        return mainColorHexValue;
    }

    public void setMainColorHexValue(String mainColorHexValue) {
        this.mainColorHexValue = mainColorHexValue;
    }

    public String getSecondaryColorHexValue() {
        return secondaryColorHexValue;
    }

    public void setSecondaryColorHexValue(String secondaryColorHexValue) {
        this.secondaryColorHexValue = secondaryColorHexValue;
    }
}
