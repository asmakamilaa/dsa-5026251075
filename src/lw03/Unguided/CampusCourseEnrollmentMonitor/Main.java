package lw03.Unguided.CampusCourseEnrollmentMonitor;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Map<String, Integer> courseEnrollment = new LinkedHashMap<>();

        System.out.println("===== Enrollment Checks =====");

        Scanner input = new Scanner(
            Main.class.getResourceAsStream("/lw03/Unguided/enrollment.txt")
        );

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] parts = line.split(" ", 3);

            String type = parts[0];
            String code = parts[1];
            int count = Integer.parseInt(parts[2]);

            int rejectedOperations = 0;
            
            if(type.equals("REGISTER")){
            
                if(!courseEnrollment.containsKey(code)){
                    courseEnrollment.put(code, count);
                } else{
                    int currentEnrollment = courseEnrollment.get(code);
                    courseEnrollment.put(code, count + currentEnrollment);
                }

            } else if (type.equals("WITHDRAW")){

                int currentEnrollment = courseEnrollment.get(code);

                if(courseEnrollment.containsKey(code) && currentEnrollment >= count){
                    courseEnrollment.put(code, count + currentEnrollment);
                } else {
                    rejectedOperations++;
                }

            } else if (type.equals("CHECK"){
                if(!courseEnrollment.containsKey(code)){
                    System.out.println("Not Found")
                }
            })
        }

        input.close();

        
        for(String code : courseEnrollment.keySet()) {
                System.out.println(code + ": " + courseEnrollment.get(code) + "students");
            }

            System.out.println("Rejected Operations: " + rejectedOperations);
        }


    }
}
