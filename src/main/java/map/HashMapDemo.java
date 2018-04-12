package map;
import entityDemo.Country;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapDemo {
    /**
     * @author N.wang
     * @deprecated
     * hashMap theory demo
     *
     */
    public static void main(String[] args){

        Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);
        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);

        HashMap<Country,String> countryCapitalMap = new HashMap<Country, String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        Iterator<Country> keys = countryCapitalMap.keySet().iterator();
        while(keys.hasNext()){
            Country country = keys.next();
            String city =  countryCapitalMap.get(country);
            System.out.println(country.getName()+":"+city);
        }
    }
}
