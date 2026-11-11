/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalroombillingsystem;

/**
 *
 * @author ADMIN
 */
public class Patient {
    private String firstName;
    private String nic;
    private int treatmentNo;
    private int doctorId;

    public Patient(String firstName, String nic, int doctorId) {
        this.firstName = firstName;
        setNic(nic);
        setDoctorId(doctorId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        if(nic.length() == 10){
            this.nic = nic;
        }else{
            throw new IllegalArgumentException("NIC should contain exactly 10 characters");
        }
        
    }

    public int getTreatmentNo() {
        return treatmentNo;
    }

    public void setTreatmentNo(int treatmentNo) {
        if (treatmentNo>0 && treatmentNo<6){
            this.treatmentNo = treatmentNo;            
        }else{
            throw new IllegalArgumentException("TreatmentId should be between 1 to 5");
        }

    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        if(doctorId>0 && doctorId<6){
            this.doctorId = doctorId;
        }else{
            throw new IllegalArgumentException("Doctor IDs range from 1 to 5");
        }
        
    }
}
