/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;

/**
 * This class is used to set the attributes for the Assistants
 *
 * @author Pedro and Rafael
 */
class Assistant {

    private String name;
    private int exp_level;
    private String[] types;
    private ArrayList<Pokemon> guests = new ArrayList<>(5);

    public Assistant(String name, int exp_level, String[] types) {
        this.name = name;
        this.exp_level = exp_level;
        this.types = types;
    }

    /**
     * Getters and Setters for the class Assistant
     *
     */
    public String getName() {
        return name;
    }

    public int getExp_level() {
        return exp_level;
    }

    public String[] getTypes() {
        return types;
    }

    public ArrayList<Pokemon> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Pokemon> guests) {
        this.guests = guests;
    }

    public void addGuests(Pokemon pokemon) {
        if (guests.size() < 5) {
            guests.add(pokemon);
        }
    }

    /**
     * An override of the toString method created to show the Assistant
     * information
     * @return result
     */
    @Override
    public String toString() {
        String result;
        if (types[0] == types[1]) {
            result = "Name: " + name + "; Expertise level: " + exp_level + "; Types available: " + types[0];
        } else {
            result = "Name: " + name + "; Expertise level: " + exp_level + "; Types available: " + types[0] + ", " + types[1];
        }
        return result;
    }

}
