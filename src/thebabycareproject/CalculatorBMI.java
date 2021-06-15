  package thebabycareproject;

/**
 * Used in the section ' Nutritious Status ' in the ' Food &amp; Nutrition ' category.
 * Mainly a data storage according to length to calculate BMI-for-age for 24-71 months.
 * @author 2018331059(Sabiha)
 */
public class CalculatorBMI {

    /**
     * bmi-for-age status data according to bmi for boys
     * @param bmi calculated bmi
     * @param age_year age in year
     * @param age_month age in month
     * @return String - status for more than or equal 2 years old boy
     */
    String calculateBoy(double bmi,int age_year,int age_month){
        switch (age_year) {
            case 2:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=14.75)return "u";
                        else if(bmi<=18.2)return "h";
                        else if(bmi<=19.3)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=14.6)return "u";
                        else if(bmi<=18)return "h";
                        else if(bmi<=19.0)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=14.55)return "u";
                        else if(bmi<=17.7)return "h";
                        else if(bmi<=18.7)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=14.4)return "u";
                        else if(bmi<=17.58)return "h";
                        else if(bmi<=18.5)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 3:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=14.35)return "u";
                        else if(bmi<=17.38)return "h";
                        else if(bmi<=18.3)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=14.25)return "u";
                        else if(bmi<=17.2)return "h";
                        else if(bmi<=18.1)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=14.2)return "u";
                        else if(bmi<=17.1)return "h";
                        else if(bmi<=18)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=14.1)return "u";
                        else if(bmi<=17.0)return "h";
                        else if(bmi<=17.9)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 4:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=14.15)return "u";
                        else if(bmi<=16.95)return "h";
                        else if(bmi<=17.8)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=14.4)return "u";
                        else if(bmi<=16.9)return "h";
                        else if(bmi<=17.8)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=13.95)return "u";
                        else if(bmi<=16.85)return "h";
                        else if(bmi<=17.8)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=13.9)return "u";
                        else if(bmi<=16.82)return "h";
                        else if(bmi<=17.9)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 5:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=13.85)return "u";
                        else if(bmi<=16.82)return "h";
                        else if(bmi<=17.95)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=13.9)return "u";
                        else if(bmi<=16.85)return "h";
                        else if(bmi<=18.0)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=13.9)return "u";
                        else if(bmi>=16.95 && bmi<18.1)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=13.75)return "u";
                        else if(bmi<=16.95)return "h";
                        else if(bmi<=18.1)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            default:
                if(bmi<=13.7)return "u";
                else if(bmi<=17.0)return "h";
                else if(bmi<=18.2)return "o";
                else return "n";
        }         
        return null;   
}

    /**
     * bmi-for-age status data according to bmi for girls
     * @param bmi calculated bmi
     * @param age_year age in year
     * @param age_month age in month
     * @return String - status for more than or equal 2 years old boy
     * u = unhealthy
     * h = healthy
     * o = overweight
     * n = obese
     */
    String calculateGirl(double bmi,int age_year,int age_month){
        switch (age_year) {
            case 2:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=14.4)return "u";
                        else if(bmi<=18)return "h";
                        else if(bmi<=19.1)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=14.3)return "u";
                        else if(bmi<=17.8)return "h";
                        else if(bmi<=18.8)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=14.2)return "u";
                        else if(bmi<=17.59)return "h";
                        else if(bmi<=18.6)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=14.1)return "u";
                        else if(bmi<=17.4)return "h";
                        else if(bmi<=18.4)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 3:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=14)return "u";
                        else if(bmi<=17.2)return "h";
                        else if(bmi<=18.3)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=13.95)return "u";
                        else if(bmi<=17.1)return "h";
                        else if(bmi<=18.2)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=13.9)return "u";
                        else if(bmi>=16.95 && bmi<18.1)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=13.8)return "u";
                        else if(bmi<=16.9)return "h";
                        else if(bmi<=18.0)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 4:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=13.75)return "u";
                        else if(bmi<=16.8)return "h";
                        else if(bmi<=18)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=13.7)return "u";
                        else if(bmi<=16.8)return "h";
                        else if(bmi<=18.05)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=13.6)return "u";
                        else if(bmi<=16.8)return "h";
                        else if(bmi<18.1)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=13.6)return "u";
                        else if(bmi<=16.8)return "h";
                        else if(bmi<=18.18)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            case 5:
                switch (age_month) {
                    case 0:
                    case 1:
                        if(bmi<=13.55)return "u";
                        else if(bmi<=16.8)return "h";
                        else if(bmi<=18.21)return "o";
                        else return "n";
                    case 2:
                    case 3:
                    case 4:
                        if(bmi<=13.5)return "u";
                        else if(bmi<=16.82)return "h";
                        else if(bmi<=18.39)return "o";
                        else return "n";
                    case 5:
                    case 6:
                    case 7:
                        if(bmi<=13.45)return "u";
                        else if(bmi<=16.9)return "h";
                        else if(bmi<=18.5)return "o";
                        else return "n";
                    case 8:
                    case 9:
                        if(bmi<=13.43)return "u";
                        else if(bmi<=17.0)return "h";
                        else if(bmi<=18.6)return "o";
                        else return "n";
                    default:
                        break;
                }
                break;
            default:
                if(bmi<=13.4)return "u";
                else if(bmi<=17.1)return "h";
                else if(bmi<=18.8)return "o";
                else return "n";
        }         
        return null;   
    }

}
