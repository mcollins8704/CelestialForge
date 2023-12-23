package forge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Perk implements Serializable {
    String domain;
    String name;
    String description;
    int cost;
    boolean active;
    
    @Override
    public String toString(){
        return "Name:" + name
                + "Description:" + description
                + "Cost:" + cost
                + "Active:" + active;
    }
    
    public String toDescription(){
        return this.domain + "\n\n" + this.name + "\n\n" + this.description;
    }
    
    public Perk(String name, String description, int cost, String domain){
        this.domain = domain.trim();
        this.name = name.trim();
        this.description = description;
        this.cost = cost;
        this.active = false;
    }
    
    public void setName(String name){
        this.name = name.trim();
    }
    public String getName(){
        return this.name.trim();
    }
    
    public void setDomain(String domain){
        this.domain = domain.trim();
    }
    public String getDomain(){
        return this.domain.trim();
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    public boolean isActive(){
        return this.active;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    
    public static int parseCost(String perk){
        Pattern pattern = Pattern.compile("\\([0-9]{1,4}CP\\)");
        Matcher matcher = pattern.matcher(perk);
        if (matcher.find()){
            return Integer.parseInt(matcher.group(0).substring(1, matcher.group(0).length()-3));
        }
        return 0;
    }
    
    public void setCost(){
        Pattern pattern = Pattern.compile("\\([0-9]{1,4}CP\\)");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()){
            this.cost = Integer.parseInt(matcher.group(0).substring(1, matcher.group(0).length()-3));
        }
    }
    
    public int getCost(){
        return this.cost;
    }
    
}
