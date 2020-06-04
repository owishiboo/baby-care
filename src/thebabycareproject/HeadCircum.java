package thebabycareproject;

/**
 * Used in the section ' Growth Calculator ' in the ' Growth &amp; Immunity ' category.
 * Mainly a data storage according to head circumference for 0-72 months.
 * @author 2018331022(Owishi)
 */
public class HeadCircum {
    double[] agecircum = new double[38];
    double[] circum3boy = new double[38];
    double[] circum97boy = new double[38];
    double[] circum3girl = new double[38];
    double[] circum97girl = new double[38];
    double[] agestature = new double[50];
    double[] stature5boy = new double[50];
    double[] stature95boy = new double[50];
    double[] stature5girl = new double[50];
    double[] stature95girl = new double[50];
    
    /**
     * Head circumference-for-age data according to height for both gender
     * @param gender String
     * @param area measurement of head in cm
     * @param age must be in months
     * @return String - head circumference
     */
    String circum(String gender,double area, double age){
        agecircum[0]=0;         circum3boy[0]=31.48762;     circum97boy[0]=38.85417;    circum3girl[0]=31.9302;     circum97girl[0]=38.1211;
        agecircum[1]=0.5;       circum3boy[1]=33.25006;     circum97boy[1]=40.10028;    circum3girl[1]=33.38071;    circum97girl[1]=39.27006;
        agecircum[2]=1.5;       circum3boy[2]=35.78126;     circum97boy[2]=41.94138;    circum3girl[2]=35.48627;    circum97girl[2]=40.97482;
        agecircum[3]=2.5;       circum3boy[3]=37.5588;      circum97boy[3]=43.28181;    circum3girl[3]=36.9855;     circum97girl[3]=42.22321;
        agecircum[4]=3.5;       circum3boy[4]=38.89944;     circum97boy[4]=44.32733;    circum3girl[4]=38.13114;    circum97girl[4]=43.2026;
        agecircum[5]=4.5;       circum3boy[5]=39.95673;     circum97boy[5]=45.17877;    circum3girl[5]=39.04619;    circum97girl[5]=44.00486;
        agecircum[6]=5.5;       circum3boy[6]=40.81642;     circum97boy[6]=45.893;      circum3girl[6]=39.7996;     circum97girl[6]=44.68183;
        agecircum[7]=6.5;       circum3boy[7]=41.53109;     circum97boy[7]=46.50524;    circum3girl[7]=40.43379;    circum97girl[7]=45.26563;
        agecircum[8]=7.5;       circum3boy[8]=42.13521;     circum97boy[8]=47.0388;     circum3girl[8]=40.97672;    circum97girl[8]=45.77751;
        agecircum[9]=8.5;       circum3boy[9]=42.65253;     circum97boy[9]=47.5099;     circum3girl[9]=41.44768;    circum97girl[9]=46.23224;
        agecircum[10]=9.5;      circum3boy[10]=43.10009;    circum97boy[10]=47.93027;   circum3girl[10]=41.86058;   circum97girl[10]=46.64053;
        agecircum[11]=10.5;     circum3boy[11]=43.49049;    circum97boy[11]=48.30867;   circum3girl[11]=42.22575;   circum97girl[11]=47.01035;
        agecircum[12]=11.5;     circum3boy[12]=43.83332;    circum97boy[12]=48.65181;   circum3girl[12]=42.55105;   circum97girl[12]=47.3478;
        agecircum[13]=12.5;     circum3boy[13]=44.136;      circum97boy[13]=48.96494;   circum3girl[13]=42.8426;    circum97girl[13]=47.65766;
        agecircum[14]=13.5;     circum3boy[14]=44.40441;    circum97boy[14]=49.25225;   circum3girl[14]=43.10526;   circum97girl[14]=47.94373;
        agecircum[15]=14.5;     circum3boy[15]=44.64328;    circum97boy[15]=49.51712;   circum3girl[15]=43.34294;   circum97girl[15]=48.20911;
        agecircum[16]=15.5;     circum3boy[16]=44.85646;    circum97boy[16]=49.76233;   circum3girl[16]=43.55883;   circum97girl[16]=48.4563;
        agecircum[17]=16.5;     circum3boy[17]=45.04712;    circum97boy[17]=49.99018;   circum3girl[17]=43.75558;   circum97girl[17]=48.68741;
        agecircum[18]=17.5;     circum3boy[18]=45.2179;     circum97boy[18]=50.20261;   circum3girl[18]=43.93539;   circum97girl[18]=48.90419;
        agecircum[19]=18.5;     circum3boy[19]=45.37104;    circum97boy[19]=50.40125;   circum3girl[19]=44.10013;   circum97girl[19]=49.10814;
        agecircum[20]=19.5;     circum3boy[20]=45.50843;    circum97boy[20]=50.58751;   circum3girl[20]=44.25137;   circum97girl[20]=49.30052;
        agecircum[21]=20.5;     circum3boy[21]=45.63169;    circum97boy[21]=50.76259;   circum3girl[21]=44.39047;   circum97girl[21]=49.48244;
        agecircum[22]=21.5;     circum3boy[22]=45.74221;    circum97boy[22]=50.92752;   circum3girl[22]=44.51861;   circum97girl[22]=49.65484;
        agecircum[23]=22.5;     circum3boy[23]=45.84121;    circum97boy[23]=51.08322;   circum3girl[23]=44.6368;    circum97girl[23]=49.81854;
        agecircum[24]=23.5;     circum3boy[24]=45.92974;    circum97boy[24]=51.23047;   circum3girl[24]=44.74593;   circum97girl[24]=49.97429;
        agecircum[25]=24.5;     circum3boy[25]=46.00872;    circum97boy[25]=51.36998;   circum3girl[25]=44.84678;   circum97girl[25]=50.12271;
        agecircum[26]=25.5;     circum3boy[26]=46.07898;    circum97boy[26]=51.50236;   circum3girl[26]=44.94005;   circum97girl[26]=50.26437;
        agecircum[27]=26.5;     circum3boy[27]=46.14124;    circum97boy[27]=51.62817;   circum3girl[27]=45.02634;   circum97girl[27]=50.39978;
        agecircum[28]=27.5;     circum3boy[28]=46.19614;    circum97boy[28]=51.7479;    circum3girl[28]=45.1062;    circum97girl[28]=50.5294;
        agecircum[29]=28.5;     circum3boy[29]=46.24425;    circum97boy[29]=51.86198;   circum3girl[29]=45.18011;   circum97girl[29]=50.65362;
        agecircum[30]=29.5;     circum3boy[30]=46.2861;     circum97boy[30]=51.97081;   circum3girl[30]=45.24852;   circum97girl[30]=50.77281;
        agecircum[31]=30.5;     circum3boy[31]=46.32214;    circum97boy[31]=52.07475;   circum3girl[31]=45.31181;   circum97girl[31]=50.88731;
        agecircum[32]=31.5;     circum3boy[32]=46.3528;     circum97boy[32]=52.17413;   circum3girl[32]=45.37035;   circum97girl[32]=50.99741;
        agecircum[33]=32.5;     circum3boy[33]=46.37844;    circum97boy[33]=52.26923;   circum3girl[33]=45.42444;   circum97girl[33]=51.10338;
        agecircum[34]=33.5;     circum3boy[34]=46.39942;    circum97boy[34]=52.36032;   circum3girl[34]=45.4744;    circum97girl[34]=51.20547;
        agecircum[35]=34.5;     circum3boy[35]=46.41605;    circum97boy[35]=52.44764;   circum3girl[35]=45.52047;   circum97girl[35]=51.30392;
        agecircum[36]=35.5;     circum3boy[36]=46.4286;     circum97boy[36]=52.53143;   circum3girl[36]=45.56291;   circum97girl[36]=51.39892;
        agecircum[37]=36.0;     circum3boy[37]=46.43344;    circum97boy[37]=52.57205;   circum3girl[37]=45.58284;   circum97girl[37]=51.44519;
        if("Boy".equals(gender)){
            for(int i=0;i<38;i++){
                if(age==agecircum[i]){
                    if(area<circum3boy[i])return "Microcephaly";
                    else if(area>circum97boy[i])return "Macrocephaly";
                    else return "Normal";
                }
                else if(i!=37 && age>agecircum[i] && age<agecircum[i+1]){
                    double comp3 = (circum3boy[i]+circum3boy[i+1])/2.0;
                    double comp97 = (circum97boy[i]+circum97boy[i+1])/2.0;
                    if(area<comp3)return "Microcephaly";
                    else if(area>comp97)return "Macrocephaly";
                    else return "Normal";
                }
            }
        }
        else{
           for(int i=0;i<38;i++){
                if(age==agecircum[i]){
                    if(area<circum3girl[i])return "Microcephaly";
                    else if(area>circum97girl[i])return "Macrocephaly";
                    else return "Normal";
                }
                else if(i!=37 && age>agecircum[i] && age<agecircum[i+1]){
                    double comp3 = (circum3girl[i]+circum3girl[i+1])/2.0;
                    double comp97 = (circum97girl[i]+circum97girl[i+1])/2.0;
                    if(area<comp3)return "Microcephaly";
                    else if(area>comp97)return "Macrocephaly";
                    else return "Normal";
                }
            } 
        }
        return null;
        
    }
    
    /**
     * Stature-for-age data according to height for both gender
     * @param gender string
     * @param area height in cm
     * @param age must be in months
     * @return String - stature-for-age
     */
    String stature(String gender,double area, double age){
        agestature[0]=24;         stature5boy[0]=80.72977;     stature95boy[0]=92.19688;    stature5girl[0]=79.25982;     stature95girl[0]=90.66355;
        agestature[1]=24.5;       stature5boy[1]=81.08868;     stature95boy[1]=92.63177;    stature5girl[1]=79.64777;     stature95girl[1]=91.12707;
        agestature[2]=25.5;       stature5boy[2]=81.83445;     stature95boy[2]=93.53407;    stature5girl[2]=80.44226;     stature95girl[2]=92.12168;
        agestature[3]=26.5;       stature5boy[3]=82.56406;     stature95boy[3]=94.40885;    stature5girl[3]=81.22666;     stature95girl[3]=93.08254;
        agestature[4]=27.5;       stature5boy[4]=83.27899;     stature95boy[4]=95.25754;    stature5girl[4]=81.9954;      stature95girl[4]=94.00873;
        agestature[5]=28.5;       stature5boy[5]=83.98045;     stature95boy[5]=96.08149;    stature5girl[5]=82.74411;     stature95girl[5]=94.89974;
        agestature[6]=29.5;       stature5boy[6]=84.66948;     stature95boy[6]=96.88198;    stature5girl[6]=83.46957;     stature95girl[6]=95.75551;
        agestature[7]=30.5;       stature5boy[7]=85.34694;     stature95boy[7]=97.66027;    stature5girl[7]=84.16953;     stature95girl[7]=96.57635;
        agestature[8]=31.5;       stature5boy[8]=86.01357;     stature95boy[8]=98.41758;    stature5girl[8]=84.84264;     stature95girl[8]=97.36295;
        agestature[9]=32.5;       stature5boy[9]=86.66999;     stature95boy[9]=99.15514;    stature5girl[9]=85.4883;      stature95girl[9]=98.11632;
        agestature[10]=33.5;      stature5boy[10]=87.3168;     stature95boy[10]=99.87416;   stature5girl[10]=86.10656;    stature95girl[10]=98.83778;
        agestature[11]=34.5;      stature5boy[11]=87.95452;    stature95boy[11]=100.5759;   stature5girl[11]=86.69803;    stature95girl[11]=99.52891;
        agestature[12]=35.5;      stature5boy[12]=88.58366;    stature95boy[12]=101.2615;   stature5girl[12]=87.26379;    stature95girl[12]=100.1915;
        agestature[13]=36.5;      stature5boy[13]=89.20473;    stature95boy[13]=101.9324;   stature5girl[13]=87.80528;    stature95girl[13]=100.8276;
        agestature[14]=37.5;      stature5boy[14]=89.77301;    stature95boy[14]=102.593;    stature5girl[14]=88.34236;    stature95girl[14]=101.4726;
        agestature[15]=38.5;      stature5boy[15]=90.33306;    stature95boy[15]=103.247;    stature5girl[15]=88.87256;    stature95girl[15]=102.1129;
        agestature[16]=39.5;      stature5boy[16]=90.88532;    stature95boy[16]=103.8948;   stature5girl[16]=89.39733;    stature95girl[16]=102.7494;
        agestature[17]=40.5;      stature5boy[17]=91.43025;    stature95boy[17]=104.537;    stature5girl[17]=89.91797;    stature95girl[17]=103.383;
        agestature[18]=41.5;      stature5boy[18]=91.96832;    stature95boy[18]=105.1739;   stature5girl[18]=90.43559;    stature95girl[18]=104.0144;
        agestature[19]=42.5;      stature5boy[19]=92.49999;    stature95boy[19]=105.8061;   stature5girl[19]=90.95115;    stature95girl[19]=104.6444;
        agestature[20]=43.5;      stature5boy[20]=93.0257;     stature95boy[20]=106.434;    stature5girl[20]=91.46549;    stature95girl[20]=105.2736;
        agestature[21]=44.5;      stature5boy[21]=93.54592;    stature95boy[21]=107.0579;   stature5girl[21]=91.97932;    stature95girl[21]=105.9025;
        agestature[22]=45.5;      stature5boy[22]=94.06109;    stature95boy[22]=107.6784;   stature5girl[22]=92.49325;    stature95girl[22]=106.5316;
        agestature[23]=46.5;      stature5boy[23]=94.57166;    stature95boy[23]=108.2956;   stature5girl[23]=93.00778;    stature95girl[23]=107.1613;
        agestature[24]=47.5;      stature5boy[24]=95.07806;    stature95boy[24]=108.9101;   stature5girl[24]=93.52333;    stature95girl[24]=107.7919;
        agestature[25]=48.5;      stature5boy[25]=95.5807;     stature95boy[25]=109.522;    stature5girl[25]=94.04022;    stature95girl[25]=108.4238;
        agestature[26]=49.5;      stature5boy[26]=96.08;       stature95boy[26]=110.1317;   stature5girl[26]=94.55872;    stature95girl[26]=109.057;
        agestature[27]=50.5;      stature5boy[27]=96.57635;    stature95boy[27]=110.7394;   stature5girl[27]=95.07903;    stature95girl[27]=109.6918;
        agestature[28]=51.5;      stature5boy[28]=97.07013;    stature95boy[28]=111.3454;   stature5girl[28]=95.60128;    stature95girl[28]=110.3283;
        agestature[29]=52.5;      stature5boy[29]=97.5617;     stature95boy[29]=111.95;     stature5girl[29]=96.12555;    stature95girl[29]=110.9665;
        agestature[30]=53.5;      stature5boy[30]=98.05141;    stature95boy[30]=112.5533;   stature5girl[30]=96.65189;    stature95girl[30]=111.6066;
        agestature[31]=54.5;      stature5boy[31]=98.53958;    stature95boy[31]=113.1555;   stature5girl[31]=97.18029;    stature95girl[31]=112.2483;
        agestature[32]=55.5;      stature5boy[32]=99.02654;    stature95boy[32]=113.7568;   stature5girl[32]=97.71069;    stature95girl[32]=112.8917;
        agestature[33]=56.5;      stature5boy[33]=99.51256;    stature95boy[33]=114.3574;   stature5girl[33]=98.24303;    stature95girl[33]=113.5368;
        agestature[34]=57.5;      stature5boy[34]=99.99791;    stature95boy[34]=114.9575;   stature5girl[34]=98.77719;    stature95girl[34]=114.1833;
        agestature[35]=58.5;      stature5boy[35]=100.4828;    stature95boy[35]=115.557;    stature5girl[35]=99.31303;    stature95girl[35]=114.8312;
        agestature[36]=59.5;      stature5boy[36]=100.9676;    stature95boy[36]=115.557;    stature5girl[36]=99.85039;    stature95girl[36]=115.4802;
        agestature[37]=60.0;      stature5boy[37]=101.4523;    stature95boy[37]=116.755;    stature5girl[37]=100.3891;    stature95girl[37]=116.1301;
        agestature[38]=61.5;      stature5boy[38]=101.9372;    stature95boy[38]=117.3536;   stature5girl[38]=100.9289;    stature95girl[38]=116.7808;
        agestature[39]=62.0;      stature5boy[39]=102.4225;    stature95boy[39]=117.9521;   stature5girl[39]=101.4696;    stature95girl[39]=117.432;
        agestature[40]=63.5;      stature5boy[40]=102.9082;    stature95boy[40]=118.5505;   stature5girl[40]=102.011;     stature95girl[40]=118.0834;
        agestature[41]=64.5;      stature5boy[41]=103.3945;    stature95boy[41]=119.1487;   stature5girl[41]=102.5529;    stature95girl[41]=118.7348;
        agestature[42]=65.5;      stature5boy[42]=103.8814;    stature95boy[42]=119.7469;   stature5girl[42]=103.0948;    stature95girl[42]=119.3858;
        agestature[43]=66.5;      stature5boy[43]=104.369;     stature95boy[43]=120.345;    stature5girl[43]=103.6367;    stature95girl[43]=120.0362;
        agestature[44]=67.5;      stature5boy[44]=104.8574;    stature95boy[44]=120.943;    stature5girl[44]=104.1782;    stature95girl[44]=120.6857;
        agestature[45]=68.5;      stature5boy[45]=105.3466;    stature95boy[45]=121.5408;   stature5girl[45]=104.7191;    stature95girl[45]=121.334;
        agestature[46]=69.5;      stature5boy[46]=105.8364;    stature95boy[46]=122.1384;   stature5girl[46]=105.259;     stature95girl[46]=121.9807;
        agestature[47]=70.0;      stature5boy[47]=106.327;     stature95boy[47]=122.7359;   stature5girl[47]=105.7976;    stature95girl[47]=122.6256;
        agestature[48]=71.5;      stature5boy[48]=106.8182;    stature95boy[48]=123.333;    stature5girl[48]=106.3348;    stature95girl[48]=123.2684;
        agestature[49]=72.0;      stature5boy[49]=107.3099;    stature95boy[49]=123.9297;   stature5girl[49]=106.8701;    stature95girl[49]=123.9086;
        if("Boy".equals(gender)){
            for(int i=0;i<49;i++){
                if(age==agestature[i]){
                    if(area<stature5boy[i])return "Short Stature";
                    if(area>stature95boy[i])return "Tall Stature";
                    return "Normal Stature";
                }
                else if(i!=48 && age>agestature[i] && age<agestature[i+1]){
                    double comp5 = (stature5boy[i]+stature5boy[i+1])/2.0;
                    double comp95 = (stature95boy[i]+stature95boy[i+1])/2.0;
                    if(area<comp5)return "Short Stature";
                    else if(area>=comp95)return "Tall Stature";
                    return "Normal Stature";
                }
            }
        }
        else {
            for(int i=0;i<49;i++){
                if(age==agestature[i]){
                    if(area<stature5girl[i])return "Short Stature";
                    if(area>stature95girl[i])return "Tall Stature";
                    return "Normal Stature";
                }
                else if(i!=48 && age>agestature[i] && age<agestature[i+1]){
                    double comp5 = (stature5girl[i]+stature5girl[i+1])/2.0;
                    double comp95 = (stature95girl[i]+stature95girl[i+1])/2.0;
                    if(area<comp5)return "Short Stature";
                    if(area>=comp95)return "Tall Stature";
                    else return "Normal Stature";
                }
            }
        }
        return null;
        
    }
    
}
