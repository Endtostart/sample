package serialize.json;

public interface JsonSelf {
    public String serialize(Object object);

    public <T> T deSerialize(String json, TypeTab<T> tab);

    public <T> T deSerialize(String json, Class<T> clazz);

}
