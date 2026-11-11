/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalroombillingsystem;

/**
 *
 * @author ADMIN
 */
public class NonACRoom extends Room {
    private Boolean hasTV;
    private final float EXTRA_CHARGE_TV=500;

    public NonACRoom(Boolean hasTV) {
        super();
        this.hasTV = hasTV;
    }
    /**
    public void setHasTV(b){
        
    }
    **/

    @Override
    public double calculatePrice(){
        if(hasTV == true){
            return Room.getStandardPrice()+ EXTRA_CHARGE_TV;
            
        }else{
            return Room.getStandardPrice();
        }
    }
}

