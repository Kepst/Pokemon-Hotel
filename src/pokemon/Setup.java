/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class setup build to create pokemons, rooms and assistants
 * @author Pedro and Rafael
 */
public class Setup {

    private ArrayList<Pokemon> pokemons = new ArrayList<>(80);
    private String[] pokenames = new String[802];
    private String[] poketypes = new String[18];
    private Room[] rooms = new Room[100];
    private Assistant[] assistants = new Assistant[20];

    public Setup() {
        createPokemonNames();
        createPokemonTypes();
        genPokemons();
        genAssists();
        genRooms();
    }

    /**
     * Method that creates random pokemons
     */
    private void genPokemons() {
        Random rd = new Random();
        for (int i = 0; i < 80; i++) {
            Pokemon poke = new Pokemon(getPokemonName(), getPokemonType(), i,
                    rd.nextInt(11) + 5, rd.nextInt(11) + 5, rd.nextInt(9) + 1);
            pokemons.add(poke);
        }
    }

    /**
     * method that generates random pokemon names
     *
     * @return
     */
    private String getPokemonName() {
        Random rd = new Random();
        String result;
        result = this.pokenames[rd.nextInt(802)];
        return result;
    }

    /**
     * method that generate the pokemons name
     */
    private void createPokemonNames() {
        File file = new File("pokemon.txt");
        try {
            Scanner sc = new Scanner(file);
            int i = 0;
            while (sc.hasNext()) {
                pokenames[i] = sc.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
    }

    /**
     * method that create pokemons type
     */
    private void createPokemonTypes() {
        File file = new File("poke_types.txt");
        try {
            Scanner sc = new Scanner(file);
            int i = 0;
            while (sc.hasNext()) {
                poketypes[i] = sc.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
    }

    /**
     * method that return the pokemon type
     *
     * @return
     */
    private String getPokemonType() {
        Random rd = new Random();
        String result;
        result = this.poketypes[rd.nextInt(this.poketypes.length)];
        return result;
    }

    /**
     * method that create the assistant
     */
    private void genAssists() {

        Random rd = new Random();
        String[] names = {"Alice", "Bob", "Camile", "Drax", "Emerald", "Galve",
            "Glyede", "Shade", "Monev", "Behmo", "Cada", "Shay", "Banshee", "Oris"};
        for (int i = 0; i < assistants.length; i++) {
            Assistant s;
            int type1 = rd.nextInt(this.poketypes.length);
            int type2 = rd.nextInt(this.poketypes.length);

            String[] types = new String[2];
            types[0] = poketypes[type1];
            types[1] = poketypes[type2];
            s = new Assistant(names[rd.nextInt(names.length)], rd.nextInt(6) + 1, types);

            assistants[i] = s;
        }
    }

    /**
     * method that generate the rooms
     */
    private void genRooms() {
        for (int i = 0; i < rooms.length; i++) {
            Room room = new Room();
            rooms[i] = room;
        }
    }

    /**
     * getters of the class setup
     *
     * @return pokemons, poketypes, rooms, assistants
     */
    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public String[] getPoketypes() {
        return poketypes;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Assistant[] getAssistants() {
        return assistants;
    }

}
