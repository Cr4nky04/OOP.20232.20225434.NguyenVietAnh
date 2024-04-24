package AimsProject.src.hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "D:\\Project\\Machine Learning\\Selenium\\car-model-mileage-condition.xlsx";
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(inputFilePath));
        startTime = System.currentTimeMillis();

        String outputString = "";
        for (byte b : inputBytes){
            outputString += ((char) b);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}