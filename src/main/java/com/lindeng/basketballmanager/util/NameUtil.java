package com.lindeng.basketballmanager.util;

import com.lu.jsn.JNameUtilI;
import com.lu.jsn.bean.FullHoldName;
import com.lu.jsn.bean.HoldName;
import com.lu.jsn.en.JEnglishNameUtil;
import com.lu.jsn.zh.JSimpleZhNameUtil;
import kohgylw.kcnamer.core.KCNamer;
import kohgylw.kcnamer.core.NameLength;

public class NameUtil {

    private static final KCNamer KC_NAMER = new KCNamer();
    private static final JNameUtilI J_NAME_UTIL_I_EN = JEnglishNameUtil.prepare();
    private static final JNameUtilI J_NAME_UTIL_I_ZH = JSimpleZhNameUtil.prepare();

    public static String randomTeamName() {
        int n = RandomUtil.nextInt(1, 12);
        return KC_NAMER.getRandomMaleName(NameLength.THREE).substring(1);
    }

    public static String randomZHName(int n) {
        FullHoldName fullHoldName = null;
        if (n % 2 == 0) {
            fullHoldName = J_NAME_UTIL_I_ZH.getFullName();
            return fullHoldName.getFirstName().getOrigin() + fullHoldName.getLastName().getOrigin();
        } else if (n % 13 == 0) {
            return KC_NAMER.getRandomFemaleName(NameLength.FOUR);
        } else if (n % 3 == 0) {
            return KC_NAMER.getRandomFemaleName(NameLength.THREE);
        }
        return KC_NAMER.getRandomFemaleName(NameLength.TWO);
    }

    public static String randomZHName() {
        int n = RandomUtil.nextInt(1, 99);
        return randomZHName(n);
    }

    public static String randomEnName(){
       int n= RandomUtil.nextInt(1,4);
        FullHoldName fullHoldName=J_NAME_UTIL_I_EN.getFullName();
        HoldName holdName = J_NAME_UTIL_I_EN.getShortName();
       if(n==3){
           return holdName.getTranslate()+"."+J_NAME_UTIL_I_EN.getShortName().getTranslate()+"."+fullHoldName.getLastName().getTranslate();
       }
       return holdName.getTranslate()+"."+fullHoldName.getLastName().getTranslate();
    }
}
