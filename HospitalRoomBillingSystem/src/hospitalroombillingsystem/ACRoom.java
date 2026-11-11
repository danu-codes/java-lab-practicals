/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalroombillingsystem;

/**
 *
 * @author ADMIN
 */
public class ACRoom extends Room{
    private final float EXTRA_CHARGE = 10000;
    
    public ACRoom(){
        super();
    }
    @Override
    public double calculatePrice(){
        return Room.getStandardPrice() + EXTRA_CHARGE;
    }
}