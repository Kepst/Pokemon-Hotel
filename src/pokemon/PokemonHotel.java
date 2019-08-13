package pokemon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of the project
 *
 * @author Pedro and Rafael
 */
public class PokemonHotel {

    private static ArrayList<Pokemon> pokemons = new ArrayList<>();
    private static Room[] rooms = new Room[100];
    private static Assistant[] assistants = new Assistant[20];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Setup s = new Setup();
        boolean running = true;
        pokemons = s.getPokemons();
        rooms = s.getRooms();
        assistants = s.getAssistants();
        assignPokemon();
        runMenu();

//        output the Pokemon group seeking rooms.
//output the total of the Pokemon group your hotel can accommodate.
//Output the Pokemon group your hotel can accommodate.
//output the Pokemon group your hotel cannot accommodate.
    }

    /**
     * method where the menu is created
     */
    public static void runMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Menu");
            System.out.println("1: Show all pokemons");
            System.out.println("2: Show amount of pokemon in hotel");
            System.out.println("3: Show pokemons in hotel");
            System.out.println("4: Show pokemons not in hotel");
            System.out.println("5: Show assistants with their assigned pokemon and room");
            System.out.println("6: Show specific room");
            System.out.println("7: Show specific pokemon");
            System.out.println("8: Show unassigned rooms");
            System.out.println("9: Show unassigned assistants");
            System.out.println("10: Exit");

            int choice = getInt();
            switch (choice) {
                case 1:
                    for (Pokemon pokemon : pokemons) {
                        System.out.println(pokemon);
                    }
                    break;

                case 2:
                    int count = 0;
                    for (Room room : rooms) {
                        if (room.getGuest() != null) {
                            count += 1;
                        }
                    }
                    System.out.println("Amount of pokemons in hotel: " + count);
                    break;
                case 3:
                    for (Room room : rooms) {
                        if (room.getGuest() != null) {
                            System.out.println(room.getGuest());
                        }
                    }
                    break;
                case 4:
                    for (Pokemon pokemon : pokemons) {
                        boolean found = false;
                        for (Room room : rooms) {
                            if (room.getGuest() == pokemon) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println(pokemon);
                        }

                    }
                    break;
                case 5:
                    for (Assistant assistant : assistants) {
                        System.out.println(assistant);
                        for (Pokemon pokemon : assistant.getGuests()) {
                            System.out.print(pokemon);
                            for (Room room : rooms) {
                                if (room.getGuest() == pokemon) {
                                    System.out.println("; Room: " + room.getNumber());
                                }
                            }

                        }
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("Which room number do you want to see?");
                    choice = getInt();
                    if (choice > 0 || choice < 100) {
                        System.out.println(rooms[choice - 1]);
                        Pokemon poke = rooms[choice - 1].getGuest();
                        for (Assistant assistant : assistants) {
                            if (assistant.getGuests().contains(poke)) {
                                System.out.println(assistant);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid room number");
                    }
                    break;
                case 7:
                    System.out.println("Which pokemon number do you want to see?");
                    choice = getInt();
                    if (choice > 0 || choice < 80) {
                        Pokemon poke = pokemons.get(choice - 1);
                        System.out.println(poke);
                        for (Room room : rooms) {
                            if (room.getGuest() == poke) {
                                System.out.println("Room: " + room.getNumber());
                                break;
                            }
                        }
                        for (Assistant assistant : assistants) {
                            if (assistant.getGuests().contains(poke)) {
                                System.out.println("Assistant: " + assistant.getName());
                            }
                        }
                    } else {
                        System.out.println("Invalid pokemon number");
                    }
                    break;
                case 8:
                    for (Room room : rooms) {
                        if (room.getGuest() == null) {
                            System.out.println(room);
                            System.out.println("");
                        }
                    }
                    break;
                case 9:
                    for (Assistant assistant : assistants) {
                        if (assistant.getGuests().isEmpty()) {
                            System.out.println(assistant);
                            System.out.println("");
                        }
                    }
                    break;
                case 10:
                    running = false;
            }
        }
    }

    /**
     * Method that verify if the user is going to input a number.
     *
     * @return
     */
    private static int getInt() {
        int result;
        Scanner kb = new Scanner(System.in);
        while (true) {
            if (kb.hasNextInt()) {
                result = kb.nextInt();
                kb.nextLine();
                return result;
            } else {
                kb.next();
                System.out.println("Input is not a number, try again");
            }
        }

    }

    /**
     * Method created to verify if the pokemons can be assign to any of the
     * rooms and also to an assistant.
     */
    private static void assignPokemon() {
        for (Pokemon pokemon : pokemons) {
            int pokeres = pokemon.getSpecAtt() + pokemon.getSpeed();
            Room foundRoom = null;
            Assistant foundAssist = null;
            for (Room room : rooms) {
                if (3 * room.getResistance() >= pokeres
                        && room.getGuest() == null) {
                    foundRoom = room;
                    break;
                }
            }
            for (Assistant assistant : assistants) {
                if (assistant.getExp_level() >= pokemon.getLevel()
                        && assistant.getGuests().size() < 5
                        && (assistant.getTypes()[0] == pokemon.getType()
                        || assistant.getTypes()[1] == pokemon.getType())) {
                    foundAssist = assistant;
                    break;
                }
            }
            if (foundRoom != null && foundAssist != null) {
                foundRoom.setGuest(pokemon);
                foundAssist.addGuests(pokemon);
            }
        }
    }
}
