import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class API_Utilities {

    private static ObjectMapper mapper;

    public static Map mapFromURL() throws IOException {

        mapper = new ObjectMapper();
        URL url = new URL("https://www.travel-advisory.info/api");
        return ((Map) mapper.readValue(url, Map.class).get("data"));

    }

    public static Map mapFromFile() throws IOException {

        mapper = new ObjectMapper();
        File fl = new File("/Users/erdemdenizli/Desktop/CountryCheck/src/main/resources/Data.json");
        return ((Map) mapper.readValue(fl, Map.class).get("data"));

    }

    public static void getData(String countryCode, Map obj) {

        Map<String,Object> map = (Map) obj.get(countryCode);
        System.out.println(map.get("name"));
    }

    public static Set countryListAsSet(Map obj) {


        Set<String> set = (Set) obj.keySet();
        return set;

    }

    public static void printCountryList(Map obj) {

        Set<String> set = (Set) obj.keySet();
        System.out.println(set);

    }

}
