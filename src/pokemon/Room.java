package pokemon;

import java.util.Random;

/**
 * This class is used to set the attributes for the rooms
 *
 * @author Pedro and Rafael
 */
class Room {

    private static int numb_rooms = 1;
    private int number;
    private int resistance;
    private Pokemon guest;

    /**
     * method to calculate the resistance of the room
     */
    public Room() {
        Random rd = new Random();
        number = numb_rooms;
        numb_rooms++;
        resistance = rd.nextInt(5) + 3;
    }

    /**
     * Getters and setters of Room´s class
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    public int getResistance() {
        return resistance;
    }

    public Pokemon getGuest() {
        return guest;
    }

    public void setGuest(Pokemon guest) {
        this.guest = guest;
    }

    /**
     * A toString method to return and show the information about
     * the room.
     * @return 
     */
    public String toString() {
        String result = "";
        result += "Number: " + number + "\n";
        result += "Resistance: " + resistance + "\n";
        if (guest == null) {
            result += "No pokemon in this room";
        } else {
            result += "Pokemon: " + guest + "\n";
        }
        return result;
    }

}
