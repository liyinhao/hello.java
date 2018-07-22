package example;

import com.google.gson.Gson;

/**
 * Created by liyinhao on 18/7/22.
 */
public class JsonUtil {

    private static Gson gson = new Gson();


    public static <T> String toJson(T t) {
        return gson.toJson(t);
    }

    public static <T> T fromJson(String gsonStr, Class<T> clazz) {
        return gson.fromJson(gsonStr, clazz);
    }
}
