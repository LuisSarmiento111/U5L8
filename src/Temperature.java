public class Temperature {
    private double highTemp;
    private double lowTemp;
    private String tempScale;
    public static final int FREEZING_TEMP_F = 32;
    private static double highestTrackedTempF = 0;
    private static double lowestTrackedTempF = 0;
    private static boolean didSetFirstTemps = false;

    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale) {
        highTemp = high;
        lowTemp = low;
        if (scale.equals("F") || scale.equals("C")) {
            tempScale = scale;
            if (scale.equals("C")) {
                low = convertCtoF(low);
                high = convertCtoF(high);
            }
        } else {
            tempScale = "F";
        }
        if (didSetFirstTemps == false) {
            highestTrackedTempF = high;
            lowestTrackedTempF = low;
            didSetFirstTemps = true;
        } else {
            if (high > highestTrackedTempF) {
                highestTrackedTempF = highTemp;
            }
            if (low < lowestTrackedTempF) {
                lowestTrackedTempF = lowTemp;
            }
        }
    }

    public double getHighTemp() {
        return highTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public String getTempScale() {
        return tempScale;
    }

    public static double getHighestTrackedTempF() {
        return highestTrackedTempF;
    }

    public static double getLowestTrackedTempF() {
        return lowestTrackedTempF;
    }

    public boolean belowFreezing() {
        boolean isBelow = false;
        if (tempScale.equals("C")) {
            if (convertCtoF(lowTemp) < FREEZING_TEMP_F || convertCtoF(highTemp) < FREEZING_TEMP_F) {
                isBelow = true;
            }
        } else {
            if (lowTemp < FREEZING_TEMP_F || highTemp < FREEZING_TEMP_F) {
                isBelow = true;
            }
        }
        return isBelow;
    }

    public static boolean sawFreezing() {
        if (lowestTrackedTempF < FREEZING_TEMP_F || highestTrackedTempF < FREEZING_TEMP_F) {
            return true;
        } else {
            return false;
        }
    }

    // 1. Add your two static methods here:
    public static double convertCtoF(double temp) {
        return temp * 9 / 5 + 32;
    }

    public static double convertFtoC(double temp) {
        return (temp - 32) * 5 / 9;
    }

    // 2. Add your two instance methods here:
    public void changeToC() {
        if (tempScale.equals("F")) {
            highTemp = Temperature.convertFtoC(highTemp);
            lowTemp = Temperature.convertFtoC(lowTemp);
            tempScale = "C";
        }

    }

    public void changeToF() {
        if (tempScale.equals("C")) {
            highTemp = Temperature.convertCtoF(highTemp);
            lowTemp = Temperature.convertCtoF(lowTemp);
            tempScale = "F";
        }

    }

    // 3. Add your private static helper rounding "utility" method here:
    private double roundToNearestTenth(double num) {
        if (tempScale.equals("C")) {
            return Math.round(num * 10.0) / 10.0;
        } else {
            return Math.round(num * 100.0) / 100.0;
        }

    }


    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:
    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public String toString() {
        return "High Temperature: " + roundToNearestTenth(highTemp) + " " + tempScale
                + "\nLow Temperature: " + roundToNearestTenth(lowTemp) + " " + tempScale;
    }
}
