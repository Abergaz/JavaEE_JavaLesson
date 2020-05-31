package ee.json;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.*;


public class MainExample {
    public static void main(String[] args) throws IOException {
        /** пишим JSON в file*/
        StringWriter stringWriter = new MainExample().getWriter();
        FileWriter fileWriter = new FileWriter("Student.json");
        fileWriter.write(stringWriter.toString());
        fileWriter.close();
        /** читаем JSON из file*/
        JsonParser jsonParser = Json.createParser(new FileReader("Student.json"));
        while (jsonParser.hasNext()){
            JsonParser.Event event = jsonParser.next();
           if (event.equals(JsonParser.Event.KEY_NAME) || event.equals(JsonParser.Event.VALUE_NUMBER) ||event.equals(JsonParser.Event.VALUE_STRING)){
               System.out.println(jsonParser.toString());
           }
        }
    }

    public StringWriter getWriter() {
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = Json.createGenerator(stringWriter);
        generator.writeStartObject() /** создаем корневой обьект*/
                .writeStartObject("Student") /** создаем обьект Student в корневом*/
                .write("name", "Max")
                .write("age", 22)
                .writeStartObject("adress")/** добавляем обьект adress в student*/
                .write("city", "Moscow")
                .write("street", "lenina")
                .writeEnd()/** закрываем обьект adress*/
                .writeStartArray("exams") /** добавляем массив в студента*/
                .write("englis")
                .write("math")
                .write("chimistry")
                .writeEnd() /** закыли массив */
                .writeEnd() /** закрыли студента*/
                .writeEnd() /** закрыли корневой*/
                .close();
        return stringWriter;
    }
}
