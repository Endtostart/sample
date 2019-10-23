package entityDemo;

public class Country {
    /**
     * @author N.wang
     * @relevence HashMapDemo
     *
     */

    String name;
    Integer populatioin;
    StatusEnum status;

    public Country(){

    }

    public Country(String name,Integer populatioin){
        super();
        this.name = name;
        this.populatioin = populatioin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulatioin() {
        return populatioin;
    }

    public void setPopulatioin(Integer populatioin) {
        this.populatioin = populatioin;
    }

    @Override
    public int hashCode(){
        if(this.name.length()%2 == 0){
            return 31;
        }
        return 95;
    }

    @Override
    public boolean equals(Object obj){
        Country country = (Country)obj;
        if(this.name.equalsIgnoreCase(country.getName())){
            return true;
        }
        return false;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
