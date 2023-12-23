package forge;


import forge.Domain;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michael
 */
public class Forge implements Serializable {
    ArrayList<Domain> celestialForge;
    int points;
    
    @Override
    public String toString(){
        return "Forge:" + celestialForge;
    }
    
    public Forge(){
        this.celestialForge = new ArrayList<Domain>();
    }
    public Forge(ArrayList<Domain> forge){
        this.celestialForge = forge;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public ArrayList<String> getDomainNames(){
        ArrayList<String> domains = new ArrayList<String>();
        for(Domain domain : celestialForge){
            domains.add(domain.getName().substring(0, domain.getName().indexOf("(")));
        }
        return domains;
    }
    
    public void addDomain(Domain dom){
        this.celestialForge.add(dom);
    }
    
    public ArrayList<Domain> getDomains(){
        return celestialForge;
    }
    
    public Domain getRandomDomain(int upperBound){
        Random rand = new Random();
        return this.celestialForge.get(rand.nextInt(upperBound));
    }
    
    public Perk getPerk(String perkName){
        for(Domain dom : this.getDomains()){
            for(Perk perk : dom.getPerks()){
                if (perk.getName().equals(perkName)){
                    return perk;
                }
            }
        }
        return new Perk("unk", "Unknown perk", 0, "ink");
    }
    
}
