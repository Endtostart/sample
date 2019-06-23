package serialize.json;

import com.google.gson.Gson;

public class GsonSelf implements JsonSelf{

    private Gson gson;

    public GsonSelf(Gson gson) {
        this.gson = gson;
    }

    public void init() {
        if (gson == null) {
            gson = new Gson();
        }
    }

    @Override
    public String serialize(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T deSerialize(String json, TypeTab<T> tab){
        return gson.fromJson(json, tab.getType());
    }

    @Override
    public <T> T deSerialize(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
