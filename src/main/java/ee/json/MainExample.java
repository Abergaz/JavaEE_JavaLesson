package ee.json;

import javax.json.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainExample {
    public static void main(String[] args) throws IOException {
        /** пишем Json в файл*/
        JsonObject jsonObject = new MainExample().getJSon();
        JsonWriter jsonWriter = Json.createWriter(new FileWriter("Student.json"));
        jsonWriter.write(jsonObject);
        jsonWriter.close();
        /** читаем Json c файла*/
        JsonReader jsonReader = Json.createReader(new FileReader("Student.json"));
        JsonObject jsonObjectR = jsonReader.readObject();/** получили корневой обьект */
        JsonObject student = jsonObjectR.getJsonObject("Student");/** получили обьект Student из корневого */
        System.out.println(student.getString("name"));
        System.out.println(student.getInt("age"));
        JsonObject address = student.getJsonObject("address"); /** получили обьект adress из Student*/
        System.out.println(address.getString("city"));
        System.out.println(address.getString("street"));
        /** бежим по массиву */
        List<JsonValue> exams = student.getJsonArray("exams");
        for (JsonValue jsonValue: exams){
            System.out.println(jsonValue.toString());
        }


    }
    private JsonObject getJSon(){
        return Json.createObjectBuilder() /** добавляем обьект Student*/
                .add("Student", Json.createObjectBuilder()
                        .add("name","Max")
                        .add("age",22)
                        .add("adress",Json.createObjectBuilder() /** добавляем обьект adress в Student */
                             .add("city","Moscow")
                             .add("street","Lenina")
                        )
                .add("exams", Json.createArrayBuilder()
                        .add("math")
                        .add("english")
                        .add("chemistry")
                     )
                ).build();
    }
}
