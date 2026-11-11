/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalroombillingsystem;

/**
 *
 * @author ADMIN
 */
public class Hospital {
    final int   NUM_FLOORS =5;
    final int NUM_ROOMS = 4;
    private Room[][] rooms;
    public double[] docCharges = {4000,5000,3000,4400,5500};
    public double[] treatmentCharges = {10000,20000,50000,30000,10000};

    public Hospital(){
        rooms = new Room[NUM_FLOORS][NUM_ROOMS];
        boolean has_ac[][] = {
            {true,true,true,true},
            {false,false,false,false},
            {true,true,true,true},
            {false,false,false,false},
            {false,false,false,false}
        };
        boolean has_tv[][] = {
            {true,true,true,true},
            {true,false,true,false},
            {true,true,true,true},
            {true,false,true,false},
            {true,false,true,false}
        };
        for (int i=0;i<NUM_FLOORS;i++){
            for(int j=0;j<NUM_ROOMS;j++){
                if(has_ac[i][j]==true){
                    rooms[i][j] = new ACRoom();
                }else{
                    rooms[i][j] = new NonACRoom(has_tv[i][j]);
                }
            }
        }
    }

    public double getDocCharges(int docId) {
        return docCharges[docId-1];
    }

    public void setDocCharges(double[] docCharges) {
        this.docCharges = docCharges;
    }

    public double getTreatmentCharges(int treatmentId) {
        if (treatmentId >= 1 && treatmentId <= 5) {
        return treatmentCharges[treatmentId - 1];
    } else {
        System.out.println("Invalid treatment ID. No treatment assigned or ID out of range.");
        return 0;
    }
        
    }

    public void setTreatmentCharges(double[] treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }
    
    public void registerPatients(String firstName,String nic,int doctorId,int floorNo,int roomNo){
        if(floorNo < 1 || floorNo > NUM_FLOORS || roomNo < 1 || roomNo > NUM_ROOMS){
            System.out.println("Invalid floor or room number! (Floors: 1-"+NUM_FLOORS+", Rooms: 1-"+NUM_ROOMS+")");
            return;
        }
        if(rooms[floorNo-1][roomNo-1].getPatientInRoom() == null){
            try{
                Patient patient = new Patient(firstName, nic, doctorId);
            rooms[floorNo-1][roomNo-1].setPatientInRoom(patient);
            System.out.println("Patient is successfully registered in the room ID "+rooms[floorNo-1][roomNo-1].getRoomId());
            }catch(IllegalArgumentException e){
                System.out.println("Error registering patient: "+e.getMessage());
            }
            
        }else{
            System.out.println("Room is already booked.Try another room");
        }
        
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
    
    public Patient getPatient(int roomId){
        for (int i=0;i<NUM_FLOORS;i++){
            for(int j=0;j<NUM_ROOMS;j++){
                if(roomId == rooms[i][j].getRoomId()){
                    return rooms[i][j].getPatientInRoom();
                }
                
            }
        }
        System.out.println("RoomId doesn't exist");
        return null;
    }
    public Room searchRoomIdExist(int roomId){
        for (int i=0;i<NUM_FLOORS;i++){
            for(int j=0;j<NUM_ROOMS;j++){
                if(roomId == rooms[i][j].getRoomId()){
                    return rooms[i][j];
                }
                
            }
        }
        System.out.println("RoomId doesn't exist");
        return null;
    }
    public Boolean checkRoomAvailable(int roomId){
        for (int i=0;i<NUM_FLOORS;i++){
            for(int j=0;j<NUM_ROOMS;j++){
                if(roomId == rooms[i][j].getRoomId()){
                    return rooms[i][j].getPatientInRoom() == null;
                }
                
            }
        }
        System.out.println("RoomId doesn't exist");
        return null;
    }
    public void setRoomAvailable(int roomId){
        for (int i=0;i<NUM_FLOORS;i++){
            for(int j=0;j<NUM_ROOMS;j++){
                if(roomId == rooms[i][j].getRoomId()){
                    rooms[i][j].setPatientInRoom(null);
                    return;
                }
            }
        }
        System.out.println("RoomId doesn't exist");
    }

    public void displayRoomAvailability(){
        System.out.print("  1 2 3 4");
        for (int i=NUM_FLOORS-1;i>=0;i--){
            System.out.print("\n"+(i+1));
            for(int j=0;j<NUM_ROOMS;j++){
                if(rooms[i][j].getPatientInRoom()== null){
                    System.out.print(" A");
                }else{
                    System.out.print(" N");
                }
            }
        }
        System.out.println("\n");
    }
}
