package commons;

import io.restassured.internal.support.FileReader;

import java.io.BufferedReader;

public class ApiConfig {


    public String read(String filePath) {
        String finalText = null;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            finalText = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalText;
    }

}
