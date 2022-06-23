package com.example.pokedexsearcher;

import java.util.ArrayList;
import java.util.List;

public class PokedexEntryModel {

    //klasa w ktorej przechowywane sa wybrane wartosci z api na temat danego pokemona

    String name;
    String img_url;
    int id;
    double height, weight;
    String typeA = "", typeB1 = "", typeB2 = "";
    int hp, attack, defense, sp_attack, sp_defense, speed;
    boolean manyTypes = false;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isManyTypes() {
        return manyTypes;
    }

    public void setManyTypes(boolean manyTypes) {
        this.manyTypes = manyTypes;
    }

    @Override
    public String toString() {
        return "PokedexEntryModel{" +
                "name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", typeA='" + typeA + '\'' +
                ", typeB1='" + typeB1 + '\'' +
                ", typeB2='" + typeB2 + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", sp_attack=" + sp_attack +
                ", sp_defense=" + sp_defense +
                ", speed=" + speed +
                ", manyTypes=" + manyTypes +
                '}';
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB1() {
        return typeB1;
    }

    public void setTypeB1(String typeB1) {
        this.typeB1 = typeB1;
    }

    public String getTypeB2() {
        return typeB2;
    }

    public void setTypeB2(String typeB2) {
        this.typeB2 = typeB2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height / 10;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight / 10;
    }




    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSp_attack() {
        return sp_attack;
    }

    public void setSp_attack(int sp_attack) {
        this.sp_attack = sp_attack;
    }

    public int getSp_defense() {
        return sp_defense;
    }

    public void setSp_defense(int sp_defense) {
        this.sp_defense = sp_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
