/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 * This class is used to set the attributes for all Pokemons
 *
 * @author Pedro and Rafael
 */
public class Pokemon {

    private String name;
    private String type;
    private int genStamp;
    private int specAtt;
    private int speed;
    private int level;

    public Pokemon(String name, String type, int genStamp, int specAtt, int speed, int level) {
        this.name = name;
        this.type = type;
        this.genStamp = genStamp;
        this.specAtt = specAtt;
        this.speed = speed;
        this.level = level;
    }

    /**
     * Getters and setters for the Pokemon class
     *
     * @return name, genStamp, type, specAtt, speed, level.
     */
    public String getName() {
        return name;
    }

    public int getGenStamp() {
        return genStamp;
    }

    public String getType() {
        return type;
    }

    public int getSpecAtt() {
        return specAtt;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    /**
     * An override of the toString method created to show the Pokemon
     * information
     *
     * @return result
     */
    @Override
    public String toString() {
        String result = "Name: " + name + "; Type: " + type
                + "; Genetic Stamp: " + genStamp + "; Special Attack:"
                + specAtt + "; Speed: " + speed + "; Expert Level:" + level;
        return result;
    }
}
