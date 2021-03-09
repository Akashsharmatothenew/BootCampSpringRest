/**
 * Created by ttn on 25/2/21.
 */
import org.json.JSONObject;
import org.json.JSONArray;

public class jStringToJObject {
    public static void main(String args[])
    {
        String str = "[{\"No\":\"17\",\"Name\":\"Akash\"},{\"No\":\"18\",\"Name\":\"Manoj\"}, {\"No\":\"19\",\"Name\":\"Vishal\"}]";
        JSONArray array = new JSONArray(str);
        for(int i=0; i < array.length(); i++)
        {
            JSONObject object = array.getJSONObject(i);
            System.out.println(object.getString("No"));
            System.out.println(object.getString("Name"));
        }
    }
}
