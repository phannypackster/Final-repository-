package com.example.test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Good {

    public static void main(String... args) throws IOException {
        var fileName = "./test/src/main/java/com/example/test/Sample100.csv";
        var filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            System.out.println("The File " + fileName + " Could not be found");
        }

        var Array = new ArrayList<String>();
        var readStream = Files.newBufferedReader(filePath);
        var Sample100 = readStream.readLine();

        while (Sample100 != null && Sample100.length() > 0) {

            Array.add(Sample100);
            Sample100 = readStream.readLine();
        }
        var userDetails = new ArrayList<User>();
        System.out.println("------------SerialNumber CompanyName EmployeeMarkme Description Leave---------");
        for (var userData : Array) {
            var elements = userData.split(",");
            var user = new User();
            user.SerialNumber = elements[0];
            user.CompanyName = elements[1];
            user.EmployeeMarkme = elements[2];
            user.Description = elements[3];
            user.Leave = elements[4];
            userDetails.add(user);

        }

        for (var userInfo : userDetails) {
            System.out.println(userInfo.SerialNumber + "," + userInfo.CompanyName + "," + userInfo.EmployeeMarkme + ","
                    + userInfo.Description + "," + userInfo.Leave);
        }
    }
}