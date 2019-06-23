package serialize.json;

public interface JsonSelf {
    String serialize(Object object);

    <T> T deSerialize(String json, TypeTab<T> tab);

    <T> T deSerialize(String json, Class<T> clazz);

}
