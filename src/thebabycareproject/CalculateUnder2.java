package thebabycareproject;

/**
 * Used in the section ' Nutritious Status ' in the ' Food &amp; Nutrition ' category.
 * Mainly a data storage according to length to calculate weight-for-length for 0-23 months.
 * Height must be in between 45 and 100 cm.
 * @author 2018331022(Owishi)
 */
public class CalculateUnder2 {

    /**
     * weight-for-length data according to height for boys
     * @param height - must be in meter
     * @param weight - must be in 
     * @return String - weight status for under 2 years old boy
     */
    String calculateBoyUnder2(int height,double weight){
        int[] heightUnder2= new int[56];
        double[] healthyWeight= new double[56];
        double[] overWeight= new double[56];
        double[] underWeight=new double[56];
        heightUnder2[0]=45;underWeight[0]=1.9;healthyWeight[0]=3.0;overWeight[0]=3.3;
        heightUnder2[1]=46;underWeight[1]=2.1;healthyWeight[1]=3.1;overWeight[1]=3.5;
        heightUnder2[2]=47;underWeight[2]=2.2;healthyWeight[2]=3.3;overWeight[2]=3.7;
        heightUnder2[3]=48;underWeight[3]=2.4;healthyWeight[3]=3.6;overWeight[3]=3.9;
        heightUnder2[4]=49;underWeight[4]=2.5;healthyWeight[4]=3.8;overWeight[4]=4.2;
        heightUnder2[5]=50;underWeight[5]=2.7;healthyWeight[5]=4.0;overWeight[5]=4.4;
        heightUnder2[6]=51;underWeight[6]=2.9;healthyWeight[6]=4.2;overWeight[6]=4.7;
        heightUnder2[7]=52;underWeight[7]=3.1;healthyWeight[7]=4.5;overWeight[7]=5.0;
        heightUnder2[8]=53;underWeight[8]=3.3;healthyWeight[8]=4.8;overWeight[8]=5.3;
        heightUnder2[9]=54;underWeight[9]=3.5;healthyWeight[9]=5.1;overWeight[9]=5.6;
        
        heightUnder2[10]=55;underWeight[10]=3.7;healthyWeight[10]=5.4;overWeight[10]=6.0;
        heightUnder2[11]=56;underWeight[11]=4.0;healthyWeight[11]=5.8;overWeight[11]=6.3;
        heightUnder2[12]=57;underWeight[12]=4.2;healthyWeight[12]=6.1;overWeight[12]=6.7;
        heightUnder2[13]=58;underWeight[13]=4.5;healthyWeight[13]=6.4;overWeight[13]=7.1;
        heightUnder2[14]=59;underWeight[14]=4.7;healthyWeight[14]=6.8;overWeight[14]=7.4;
        heightUnder2[15]=60;underWeight[15]=5.0;healthyWeight[15]=7.1;overWeight[15]=7.8;
        heightUnder2[16]=61;underWeight[16]=5.2;healthyWeight[16]=7.4;overWeight[16]=8.1;
        heightUnder2[17]=62;underWeight[17]=5.5;healthyWeight[17]=7.7;overWeight[17]=8.5;
        heightUnder2[18]=63;underWeight[18]=5.7;healthyWeight[18]=8.0;overWeight[18]=8.8;
        heightUnder2[19]=64;underWeight[19]=5.9;healthyWeight[19]=8.3;overWeight[19]=9.1;
        
        heightUnder2[20]=65;underWeight[20]=6.1;healthyWeight[20]=8.6;overWeight[20]=9.4;
        heightUnder2[21]=66;underWeight[21]=6.3;healthyWeight[21]=8.9;overWeight[21]=9.7;
        heightUnder2[22]=67;underWeight[22]=6.5;healthyWeight[22]=9.2;overWeight[22]=10.0;
        heightUnder2[23]=68;underWeight[23]=6.7;healthyWeight[23]=9.4;overWeight[23]=10.3;
        heightUnder2[24]=69;underWeight[24]=6.9;healthyWeight[24]=9.7;overWeight[24]=10.6;
        heightUnder2[25]=70;underWeight[25]=7.1;healthyWeight[25]=10.0;overWeight[25]=10.9;
        heightUnder2[26]=71;underWeight[26]=7.3;healthyWeight[26]=10.2;overWeight[26]=11.2;
        heightUnder2[27]=72;underWeight[27]=7.5;healthyWeight[27]=10.5;overWeight[27]=11.5;
        heightUnder2[28]=73;underWeight[28]=7.6;healthyWeight[28]=10.8;overWeight[28]=11.8;
        heightUnder2[29]=74;underWeight[29]=7.8;healthyWeight[29]=11.0;overWeight[29]=12.1;
        
        heightUnder2[30]=75;underWeight[30]=8.0;healthyWeight[30]=11.3;overWeight[30]=12.3;
        heightUnder2[31]=76;underWeight[31]=8.2;healthyWeight[31]=11.5;overWeight[31]=12.6;
        heightUnder2[32]=77;underWeight[32]=8.3;healthyWeight[32]=11.7;overWeight[32]=12.8;
        heightUnder2[33]=78;underWeight[33]=8.5;healthyWeight[33]=12.0;overWeight[33]=13.1;
        heightUnder2[34]=79;underWeight[34]=8.6;healthyWeight[34]=12.2;overWeight[34]=13.3;
        heightUnder2[35]=80;underWeight[35]=8.8;healthyWeight[35]=12.4;overWeight[35]=13.6;
        heightUnder2[36]=81;underWeight[36]=9.0;healthyWeight[36]=12.6;overWeight[36]=13.8;
        heightUnder2[37]=82;underWeight[37]=9.1;healthyWeight[37]=12.8;overWeight[37]=14.0;
        heightUnder2[38]=83;underWeight[38]=9.3;healthyWeight[38]=13.1;overWeight[38]=14.3;
        heightUnder2[39]=84;underWeight[39]=9.5;healthyWeight[39]=13.3;overWeight[39]=14.6;
      
        heightUnder2[40]=85;underWeight[40]=9.7;healthyWeight[40]=13.6;overWeight[40]=14.9;
        heightUnder2[41]=86;underWeight[41]=9.9;healthyWeight[41]=13.9;overWeight[41]=15.2;//
        heightUnder2[42]=87;underWeight[42]=10.1;healthyWeight[42]=14.2;overWeight[42]=15.5;
        heightUnder2[43]=88;underWeight[43]=10.4;healthyWeight[43]=14.5;overWeight[43]=15.8;
        heightUnder2[44]=89;underWeight[44]=10.6;healthyWeight[44]=14.7;overWeight[44]=16.1;
        heightUnder2[45]=90;underWeight[45]=10.8;healthyWeight[45]=15.0;overWeight[45]=16.4;
        heightUnder2[46]=91;underWeight[46]=11.0;healthyWeight[46]=15.3;overWeight[46]=16.7;
        heightUnder2[47]=92;underWeight[47]=11.2;healthyWeight[47]=15.6;overWeight[47]=17.0;
        heightUnder2[48]=93;underWeight[48]=11.4;healthyWeight[48]=15.8;overWeight[48]=17.3;
        heightUnder2[49]=94;underWeight[49]=11.6;healthyWeight[49]=16.1;overWeight[49]=17.6;
      
        heightUnder2[50]=95;underWeight[50]=11.8;healthyWeight[50]=16.4;overWeight[50]=17.9;
        heightUnder2[51]=96;underWeight[51]=12.0;healthyWeight[51]=16.7;overWeight[51]=18.2;
        heightUnder2[52]=97;underWeight[52]=12.2;healthyWeight[52]=17.0;overWeight[52]=18.5;
        heightUnder2[53]=98;underWeight[53]=12.4;healthyWeight[53]=17.3;overWeight[53]=18.9;
        heightUnder2[54]=99;underWeight[54]=12.6;healthyWeight[54]=17.6;overWeight[54]=19.2;
        heightUnder2[55]=100;underWeight[55]=12.8;healthyWeight[55]=17.8;overWeight[55]=19.6;
        if(weight<=underWeight[height-45])return "Underweight";
        else if(weight<=healthyWeight[height-45])return "Healthy";
        else if(weight<=overWeight[height-45])return "Overweight";
        else return "Obese Catagory";
    }

    /**
     * weight-for-length data according to height for girls
     * @param height - must be in meter
     * @param weight - must be in kg
     * @return String  - status for under 2 years old girl
     */
    String calculateGirlUnder2(int height,double weight){
        int[] heightUnder2= new int[56];
        double[] healthyWeight= new double[56];
        double[] overWeight= new double[56];
        double[] underWeight=new double[56];
        heightUnder2[0]=45;underWeight[0]=2.0;healthyWeight[0]=3.0;overWeight[0]=3.3;
        heightUnder2[1]=46;underWeight[1]=2.1;healthyWeight[1]=3.2;overWeight[1]=3.5;
        heightUnder2[2]=47;underWeight[2]=2.3;healthyWeight[2]=3.4;overWeight[2]=3.7;
        heightUnder2[3]=48;underWeight[3]=2.4;healthyWeight[3]=3.6;overWeight[3]=4.0;
        heightUnder2[4]=49;underWeight[4]=2.5;healthyWeight[4]=3.8;overWeight[4]=4.2;
        heightUnder2[5]=50;underWeight[5]=2.7;healthyWeight[5]=4.0;overWeight[5]=4.5;
        heightUnder2[6]=51;underWeight[6]=2.9;healthyWeight[6]=4.3;overWeight[6]=4.8;
        heightUnder2[7]=52;underWeight[7]=3.1;healthyWeight[7]=4.6;overWeight[7]=5.1;
        heightUnder2[8]=53;underWeight[8]=3.3;healthyWeight[8]=4.9;overWeight[8]=5.4;
        heightUnder2[9]=54;underWeight[9]=3.5;healthyWeight[9]=5.2;overWeight[9]=5.7;
        
        heightUnder2[10]=55;underWeight[10]=3.7;healthyWeight[10]=5.5;overWeight[10]=6.1;
        heightUnder2[11]=56;underWeight[11]=3.9;healthyWeight[11]=5.8;overWeight[11]=6.4;
        heightUnder2[12]=57;underWeight[12]=4.2;healthyWeight[12]=6.1;overWeight[12]=6.6;
        heightUnder2[13]=58;underWeight[13]=4.4;healthyWeight[13]=6.5;overWeight[13]=7.1;
        heightUnder2[14]=59;underWeight[14]=4.6;healthyWeight[14]=6.8;overWeight[14]=7.5;
        heightUnder2[15]=60;underWeight[15]=4.8;healthyWeight[15]=7.1;overWeight[15]=7.8;//
        heightUnder2[16]=61;underWeight[16]=5.0;healthyWeight[16]=7.4;overWeight[16]=8.2;
        heightUnder2[17]=62;underWeight[17]=5.2;healthyWeight[17]=7.7;overWeight[17]=8.5;
        heightUnder2[18]=63;underWeight[18]=5.4;healthyWeight[18]=8.0;overWeight[18]=8.8;
        heightUnder2[19]=64;underWeight[19]=5.6;healthyWeight[19]=8.3;overWeight[19]=9.1;
        
        heightUnder2[20]=65;underWeight[20]=5.8;healthyWeight[20]=8.6;overWeight[20]=9.5;
        heightUnder2[21]=66;underWeight[21]=6.0;healthyWeight[21]=8.8;overWeight[21]=9.8;
        heightUnder2[22]=67;underWeight[22]=6.2;healthyWeight[22]=9.1;overWeight[22]=10.0;
        heightUnder2[23]=68;underWeight[23]=6.4;healthyWeight[23]=9.4;overWeight[23]=10.3;
        heightUnder2[24]=69;underWeight[24]=6.6;healthyWeight[24]=9.6;overWeight[24]=10.6;
        heightUnder2[25]=70;underWeight[25]=6.8;healthyWeight[25]=9.9;overWeight[25]=10.9;
        heightUnder2[26]=71;underWeight[26]=6.9;healthyWeight[26]=10.1;overWeight[26]=11.1;
        heightUnder2[27]=72;underWeight[27]=7.1;healthyWeight[27]=10.3;overWeight[27]=11.4;
        heightUnder2[28]=73;underWeight[28]=7.3;healthyWeight[28]=10.6;overWeight[28]=11.7;
        heightUnder2[29]=74;underWeight[29]=7.4;healthyWeight[29]=10.8;overWeight[29]=11.9;
        
        heightUnder2[30]=75;underWeight[30]=7.6;healthyWeight[30]=11.0;overWeight[30]=12.2;
        heightUnder2[31]=76;underWeight[31]=7.7;healthyWeight[31]=11.2;overWeight[31]=12.4;
        heightUnder2[32]=77;underWeight[32]=7.9;healthyWeight[32]=11.5;overWeight[32]=12.6;
        heightUnder2[33]=78;underWeight[33]=8.1;healthyWeight[33]=11.7;overWeight[33]=12.9;
        heightUnder2[34]=79;underWeight[34]=8.2;healthyWeight[34]=11.9;overWeight[34]=13.1;
        heightUnder2[35]=80;underWeight[35]=8.4;healthyWeight[35]=12.1;overWeight[35]=13.4;
        heightUnder2[36]=81;underWeight[36]=8.6;healthyWeight[36]=12.4;overWeight[36]=13.7;
        heightUnder2[37]=82;underWeight[37]=8.7;healthyWeight[37]=12.6;overWeight[37]=13.9;
        heightUnder2[38]=83;underWeight[38]=8.9;healthyWeight[38]=12.9;overWeight[38]=14.2;
        heightUnder2[39]=84;underWeight[39]=9.1;healthyWeight[39]=13.2;overWeight[39]=14.5;
      
        heightUnder2[40]=85;underWeight[40]=9.3;healthyWeight[40]=13.5;overWeight[40]=14.9;
        heightUnder2[41]=86;underWeight[41]=9.6;healthyWeight[41]=13.8;overWeight[41]=15.2;//
        heightUnder2[42]=87;underWeight[42]=9.8;healthyWeight[42]=14.1;overWeight[42]=15.5;
        heightUnder2[43]=88;underWeight[43]=10.0;healthyWeight[43]=14.4;overWeight[43]=15.9;
        heightUnder2[44]=89;underWeight[44]=10.2;healthyWeight[44]=14.7;overWeight[44]=16.2;
        heightUnder2[45]=90;underWeight[45]=10.4;healthyWeight[45]=15.0;overWeight[45]=16.5;
        heightUnder2[46]=91;underWeight[46]=10.6;healthyWeight[46]=15.3;overWeight[46]=16.9;
        heightUnder2[47]=92;underWeight[47]=10.8;healthyWeight[47]=15.6;overWeight[47]=17.2;
        heightUnder2[48]=93;underWeight[48]=11.0;healthyWeight[48]=15.8;overWeight[48]=17.5;
        heightUnder2[49]=94;underWeight[49]=11.2;healthyWeight[49]=16.2;overWeight[49]=17.9;
      
        heightUnder2[50]=95;underWeight[50]=11.4;healthyWeight[50]=16.5;overWeight[50]=18.2;
        heightUnder2[51]=96;underWeight[51]=11.6;healthyWeight[51]=16.8;overWeight[51]=18.6;
        heightUnder2[52]=97;underWeight[52]=11.9;healthyWeight[52]=17.1;overWeight[52]=18.9;
        heightUnder2[53]=98;underWeight[53]=12.1;healthyWeight[53]=17.5;overWeight[53]=19.3;
        heightUnder2[54]=99;underWeight[54]=12.3;healthyWeight[54]=17.8;overWeight[54]=19.6;
        heightUnder2[55]=100;underWeight[55]=12.5;healthyWeight[55]=18.1;overWeight[55]=20.0;
        if(weight<=underWeight[height-45])return "Underweight";
        else if(weight<=healthyWeight[height-45])return "Healthy";
        else if(weight<=overWeight[height-45])return "Overweight";
        else return "Obese Catagory";
    }
}
