package nl.mtworld.mtwcore.city;


import org.bukkit.Material;

public class CityManager {

    public City getCityByBlock(Material material){

        for(City city : City.values()){
            if(city.getMaterial().equals(material)){
                return city;
            }
        }
        return City.WILDERNISS;

    }
}
