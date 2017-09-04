/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motionsensor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.microedition.midlet.MIDlet;
import jdk.dio.DeviceManager;
import jdk.dio.gpio.GPIOPin;

/**
 *
 * @author Abraham
 */
public class MotionSensor extends MIDlet {
    GPIOPin pin0;
    GPIOPin pin1,pin11;
    GPIOPin pin2;
    @Override
    public void startApp() {
        try { 
            pin0 =(GPIOPin)DeviceManager.open(1);
            pin1 =(GPIOPin)DeviceManager.open(4);
            pin2 = (GPIOPin)DeviceManager.open(3);
           
            System.out.println("Pin init");
            
            while(true)
            {
               if(pin2.getValue())
               { 
                if(pin0.getValue())
               {pin1.setValue(true);
                Thread.sleep(800);
                pin1.setValue(false);
               }
               }
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(MotionSensor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MotionSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void destroyApp(boolean unconditional) {
        try {
           pin0.close();
           pin1.close();
           pin2.close();
        } catch (IOException ex) {
            Logger.getLogger(MotionSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
