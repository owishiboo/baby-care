package thebabycareproject;

/**
 * Used in the section ' Nutritious Status ' in the ' Growth &amp; Immunity ' category.
 * Applicable for 0-71 months.
 * @author 2018331022(Owishi) for calorie calculation.
 * @author 2018331059(Sabiha)for calorie and protien calculation.
 */
public class CalorieProtien {
    double eer;

    /**
     * calculates daily calorie need
     * @param weight must be in kg
     * @return double daily calorie need for 0-3 months(kcal/day)
     */
    double zeroToThree(double weight){
        eer=89*weight-100+175;
        return eer;
    }

    /**
     * calculates daily calorie need
     * @param weight must be in kg
     * @return double daily calorie need for 4-6 months(kcal/day)
     */
    double fourToSix(double weight){
        eer=89*weight-100+56;
        return eer;
    }

    /**
     * calculates daily calorie need
     * @param weight must be in kg
     * @return double daily calorie need for 7-12 months(kcal/day)
     */
    double sevenToTwelve(double weight){
        eer=89*weight-100+22;
        return eer;
    }

    /**
     * calculates daily calorie need
     * @param weight must be in kg
     * @return double daily calorie need for 13-36 months(kcal/day)
     */
    double thirteenToThirtySix(double weight){
        eer=89*weight-100+20;
        return eer;
    }

    /**
     * calculates daily calorie need
     * @param weight must be in kg
     * @param gender String
     * @param age must be in months
     * @param pa physical activity(String)
     * @param height must be in meter
     * @return double daily calorie need for more than 36 months(kcal/day)
     */
    double up(double weight,String gender,double age,double pa,double height){
        if("Boy".equals(gender))eer=88.5-61.9*age+pa*(26.7*weight+903*height)+20;
        else eer=135.3-30.8*age+pa*(10.0*weight+934*height)+20;
        return eer;
    }

    /**
     * calculates daily protein need (applicable for all)
     * @param weight must be in kg
     * @return double daily protein need for 4-6 months(kcal/day)
     */
    double protien(double weight){
        eer=weight*1.1;
        return eer;
    }
}
