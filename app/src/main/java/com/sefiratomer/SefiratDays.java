package com.sefiratomer;

import android.util.Log;

import java.util.HashMap;

public class SefiratDays {
    public static String main(String[] args) {
        HashMap<Integer, String> daysInHebrew = new HashMap<>();
        HashMap<Integer, String> weeksInHebrew = new HashMap<>();
        HashMap<Integer, String> daysOftheWeekInHebrew = new HashMap<>();
        for (int weeks = 0; weeks < 7; weeks++) {
            switch (weeks) {
                case 0:
                    weeksInHebrew.put(weeks, "");
                    break;
                case 1:
                    weeksInHebrew.put(weeks, "שֶׁהֵם שָׁבוּעַ אֶחָד");
                    break;
                case 2:
                    weeksInHebrew.put(weeks, "שֶׁהֵם שְׁנֵי שָׁבוּעוֹת");
                    break;
                case 3:
                    weeksInHebrew.put(weeks, "שֶׁהֵם שְׁלֹשָׁה שָׁבוּעוֹת");
                    break;
                case 4:
                    weeksInHebrew.put(weeks, "שֶׁהֵם אַרְבָּעָה שָׁבוּעוֹת");
                    break;
                case 5:
                    weeksInHebrew.put(weeks, "ששֶׁהֵם חֲמִשָּׁה שָׁבוּעוֹת");
                    break;
                case 6:
                    weeksInHebrew.put(weeks, "שֶׁהֵם שִׁשָּׁה שָׁבוּעוֹת");
                    break;
            }

            for (int days = 0; days < 7; days++) {
                switch (days) {
                    case 0:
                        daysOftheWeekInHebrew.put(days, "לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 1:
                        daysOftheWeekInHebrew.put(days, "וְיוֹם אֶחָד לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 2:
                        daysOftheWeekInHebrew.put(days, "וּשְׁנֵי יָמִים לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 3:
                        daysOftheWeekInHebrew.put(days, "וּשְׁלֹשָׁה יָמִים לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 4:
                        daysOftheWeekInHebrew.put(days, "וְאַרְבָּעָה יָמִים לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 5:
                        daysOftheWeekInHebrew.put(days, "וַחֲמִשָּׁה יָמִים לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                    case 6:
                        daysOftheWeekInHebrew.put(days, "וְשִׁשָּׁה יָמִים לָעֹמֶר");
                        daysInHebrew.put(((weeks * 7) + days), " " + weeksInHebrew.get(weeks) + " " + daysOftheWeekInHebrew.get(days));
                        Log.i("daysInhHebrew " + (((weeks * 7) + days) + 1), daysInHebrew.get(((weeks * 7) + days)));
                        break;
                }
                // Log.i("" , daysInHebrew.get((weeks*7)+days));

            }
            //Sefirat.setText(Sefirat.getText() + (weeks + " " + weeksInHebrew.get(weeks)));
            Log.i("" + weeks, weeksInHebrew.get(weeks));
            //Log.i("daysInhHebrew", daysInHebrew.get(((weeks * 7) + days)));
        }
        return "test";
    }
}
