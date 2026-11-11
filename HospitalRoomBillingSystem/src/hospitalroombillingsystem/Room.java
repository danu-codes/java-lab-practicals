/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalroombillingsystem;

/**
 *
 * @author ADMIN
 */
public abstract class Room {
    private int roomId;
    private static int lastRoomId=0;
    protected static double standardPrice;
    private Patient patientInRoom;

    public Room() {
        lastRoomId++;
        setRoomId();
        
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId() {
        this.roomId = lastRoomId;
    }    

    public static double getStandardPrice() {
        return standardPrice;
    }

    public static void setStandardPrice(double standardPrice) {
        if(standardPrice>0){
            Room.standardPrice = standardPrice;
        }
        
    }

    public Patient getPatientInRoom() {
        return patientInRoom;
    }

    public void setPatientInRoom(Patient patientInRoom) {
        this.patientInRoom = patientInRoom;
    }
    
    public abstract double calculatePrice();
}
