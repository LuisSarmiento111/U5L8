public class Main {
    public static void main(String[] args) {
        Temperature temp1 = new Temperature(68.5, 56.7, "F");
        tempTest(temp1);

        Temperature temp2 = new Temperature(74.2, 60.5, "F");
        tempTest(temp2);

        Temperature temp3 = new Temperature(27.65, 10.5, "C");
        tempTest(temp3);

        Temperature temp4 = new Temperature(21.3, 9.8, "C");
        tempTest(temp4);

        Temperature temp5 = new Temperature(43.5, 29.8, "F");
        tempTest(temp5);

        Temperature temp6 = new Temperature(31.8, 30.2, "F");
        tempTest(temp6);

        Temperature temp7 = new Temperature(13.8, 2.4, "C");
        tempTest(temp7);

        Temperature temp8 = new Temperature(5.9, -3.65, "C");
        tempTest(temp8);

        // static variables maintain their current values
        System.out.println("==============================");
        tempTest(temp1);
    }

    public static void tempTest(Temperature temp) {
        // FINISH ME!
        // use instance method getters
        System.out.println("High temp: " + temp.getHighTemp());
        System.out.println("Low temp: " + temp.getLowTemp());
        System.out.println("Scale: " + temp.getTempScale());
        System.out.println("Below freezing? " + temp.belowFreezing());
        // use static method getters
        System.out.println("Highest tracked temp (F): " + Temperature.getHighestTrackedTempF());
        System.out.println("Lowest tracked temp (F): " + Temperature.getLowestTrackedTempF());
        System.out.println("Ever saw freezing?: " + Temperature.sawFreezing());
        System.out.println("-----------");
    }
}
