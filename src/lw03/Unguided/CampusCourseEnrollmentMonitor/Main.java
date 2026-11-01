package lw03.Unguided.CampusCourseEnrollmentMonitor;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> courseEnrollment = new LinkedHashMap<>();
        List<String> checkResults = new ArrayList<>();
        int rejectedOperations = 0;

        System.out.println("===== Enrollment Checks =====");

        Scanner input = new Scanner(
            Main.class.getResourceAsStream("/lw03/Unguided/enrollment.txt")
        );

        while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);

            if(!lineScanner.hasNext()) {
                lineScanner.close();
                continue; // Skip empty lines
            }

            String type = lineScanner.next();
            String code = lineScanner.next();
            
            if(type.equals("REGISTER") || type.equals("WITHDRAW")){
                int count = lineScanner.nextInt();
            
                if(count <= 0) {
                    rejectedOperations++;
                } else if(type.equals("REGISTER")){
                    if (!courseEnrollment.containsKey(code)) {
                        courseEnrollment.put(code, count);
                    } else {
                        courseEnrollment.put(code, courseEnrollment.get(code) + count);
                    }
                } else {
                    if (courseEnrollment.containsKey(code) && courseEnrollment.get(code) >= count) {
                        courseEnrollment.put(code, courseEnrollment.get(code) - count);
                    } else {
                        rejectedOperations++;
                    }
                }

            } else if (type.equals("CHECK")){
                if(courseEnrollment.containsKey(code)){
                    checkResults.add(code + ": " + courseEnrollment.get(code) + " students");
                } else{
                    checkResults.add(code + ": Not found");
                }
            }

            lineScanner.close();
        }

        input.close();

        for(int i = 0; i < checkResults.size(); i++) {
            System.out.println(checkResults.get(i));
        }

        System.out.println();
        System.out.println("===== Final Enrollment  =====");
        for(String code : courseEnrollment.keySet()) {
            System.out.println(code + ": " + courseEnrollment.get(code) + " students");
        }

        System.out.println("Rejected Operations: " + rejectedOperations);
    }
}
