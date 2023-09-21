import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    // Endpoint do modelo.
    private static final String MODEL_URL = "http://7a84fb0f-b197-4235-82b5-3424881b1222.southcentralus.azurecontainer.io/score";
    
    private static final String API_KEY = "wEjN8QJx6xklipPIV2cePM9fUb3FvegN";

    public static void main(String[] Args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(MODEL_URL))
                .headers("Content-Type", "application/json", "Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(sampleData()))
                .build();

        try {
            HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());

            List<Map<String, Object>> classification = responseMapBody(response.body());
            System.out.println(classification);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String sampleData() {
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("Age", 40);
        item.put("BP", "LOW");
        item.put("Cholesterol", "NORMAL");
        item.put("Na_to_K", 11.349);
        item.put("Drug", "");

        array.add(item);

        return array.toString();
    }

    private static List<Map<String, Object>> responseMapBody(String body) {
        Map<String, Object> hm;
        List<Map<String, Object>> res = new ArrayList<>();

        Object obj = JSONValue.parse(body);
        JSONObject jsonObject = (JSONObject) obj;
         
        JSONArray objs = (JSONArray) jsonObject.get("result"); 

        for (Object _obj : objs) {
            hm = new HashMap<>();
            for (Object o : ((JSONObject) _obj).keySet()) {
                String key = (String) o;
                hm.put(key, ((JSONObject) _obj).get(key));
            }
            res.add(hm);
        }

        return res;
    }
}