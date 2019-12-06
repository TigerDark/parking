package esse.tigerdark.gmail.com.utils;

import com.google.gson.*;
import esse.tigerdark.gmail.com.enums.ResultCode;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Objects;

/**
 * Created by User on 06.12.2019.
 */
public class DataFormatUtil {
    private static DataFormatUtil instance;
    private Gson gson;

    private DataFormatUtil() {
        JsonSerializer<Date> ser = (src, typeOfSrc, context) -> src == null ? null : new JsonPrimitive(src.getTime());
        JsonDeserializer<Date> deser = (json, typeOfT, context) -> json == null ? null : new Date(json.getAsLong());
        gson = new GsonBuilder().registerTypeAdapter(Date.class, ser)
                .registerTypeAdapter(Date.class, deser)
                .registerTypeAdapter(XMLGregorianCalendar.class, new Serializer()).registerTypeAdapter(XMLGregorianCalendar.class, new Deserializer()).serializeNulls().create();
    }

    public static DataFormatUtil me() {
        if (instance == null) {
            instance = new DataFormatUtil();
        }
        return instance;
    }

    public String prepareResponseJson(Object result, ResultCode resultCode, String details) {
        ResponsMessage responsMessage = new ResponsMessage<>(result, resultCode, details);
        return gson.toJson(responsMessage);
    }

    private static class Serializer implements JsonSerializer {
        private Serializer() {
            super();
        }

        public JsonElement serialize(Object t, Type type, JsonSerializationContext jsonSerializationContext) {
            XMLGregorianCalendar xgcal = (XMLGregorianCalendar) t;
            return new JsonPrimitive(xgcal.toXMLFormat());
        }
    }

    private static class Deserializer implements JsonDeserializer {

        public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            try {
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(jsonElement.getAsString());
            } catch (Exception ex) {
                return null;
            }

        }
    }
}