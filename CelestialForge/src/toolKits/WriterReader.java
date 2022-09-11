/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toolKits;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import forge.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class WriterReader {
    
    public static void write(Forge forge, File file){
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(forge);

            o.close();
            f.close();
            

        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        }catch (IOException e) {
                System.out.println("Error initializing stream");
        }   
    }
    
    public static Forge read(File file){
        Forge pr1 = new Forge();
        try{
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            pr1 = (Forge) oi.readObject();

            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        }catch (IOException e) {
                System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WriterReader.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return pr1;
    }
    
}
