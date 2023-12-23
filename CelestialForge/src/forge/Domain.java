package forge;
import java.util.ArrayList;
import forge.Perk;
import static forge.Perk.parseCost;
import java.io.Serializable;
import java.util.Random;


/**
 *
 * @author Michael
 */
public class Domain implements Serializable {
    String name;
    ArrayList<Perk> perks;
    boolean active;
    
    @Override
    public String toString(){
        return "Name:" + name + "Perks:" + perks + "Active:" + active;
    }
    
    public Domain(String name, ArrayList<Perk> perks){
        this.name = name;
        this.perks = perks;
        this.active = true;
    }
    
    public void parsePerks(String data){
        this.addPerks(this.parsePerkBlob(data.split(System.lineSeparator()+ "-")));
    }
    
    public ArrayList<Perk> parsePerkBlob(String[] perkBlob){
        ArrayList<Perk> perks = new ArrayList<>();
        for(String strPerkBlob : perkBlob){
            if(strPerkBlob.contains("CP)")){
                String[] pieces = strPerkBlob.split("CP\\)");
                String perkName = "first";
                String perkDescription = "";
                int cost = 0;
                int iteration = 0;
                for(String x : pieces){
                    iteration = iteration+1;
                    if(!perkName.equals("first")){
                        perkDescription = perkDescription + System.lineSeparator() + x;
                        if(pieces.length > iteration){
                            perkDescription = perkDescription + "CP)";
                        }
                    }else{
                        perkName = x + "CP)";
                    }
                }
                perks.add(new Perk(perkName.trim(), perkDescription.trim(), parseCost(perkName), this.getName()));
            }
        }
        return perks;
    }
    
    
    public void setPerks(ArrayList<Perk> perks){
        this.perks = perks;
    }
    public ArrayList<Perk> getPerks(){
        return perks;
    }
    public void setName(String name){
        this.name = name.trim();
    }
    public String getName(){
        return name.trim();
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public boolean isActive(){
        return active;
    }
    
    public void addPerks(ArrayList<Perk> perks){
        this.perks.addAll(perks);
    }
    
        public void addPerk(Perk perk){
        this.perks.add(perk);
    }
    
    public Perk getRandomPerk(){
        Random rand = new Random();
        int random = rand.nextInt(this.perks.size());
        if(this.perks.get(random).description.contains("Can be taken indefinitely")){
            return this.perks.get(random);
        }else{
            return this.perks.remove(random);
        }
    }
    
}
