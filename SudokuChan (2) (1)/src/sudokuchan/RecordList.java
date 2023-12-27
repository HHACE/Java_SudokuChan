/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuchan;

import com.sun.javafx.css.Combinator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class RecordList {

    private String inputFileE = "easy_data.txt";

    private String inputFileM = "medium_data.txt";

    private String inputFileH = "hard_data.txt";

    private String easy_data, medium_data, hard_data;
    private String easyDataList;
    private String normalDataList;
    private String hardDataList;

    public void setFile() {

        easy_data = inputFileE;
        medium_data = inputFileM;
        hard_data = inputFileH;

    }

    public void readData() {

        String name, time;
        try {

            //******************READ EASY RECORD******************//
            Scanner scEasy = new Scanner(new File(easy_data));
            for (int i = 0; i < 5; i++) {

                name = scEasy.nextLine();
                time = scEasy.nextLine();
                addNewWinnerEasy(name, time);
            }
            scEasy.close();
            //******************READ MEDIUM RECORD******************//
            Scanner scMedium = new Scanner(new File(medium_data));
            for (int i = 0; i < 5; i++) {

                name = scMedium.nextLine();
                time = scMedium.nextLine();
                addNewWinnerNormal(name, time);
            }
            scMedium.close();
            //******************READ HARD RECORD******************//
            Scanner scHard = new Scanner(new File(hard_data));
            for (int i = 0; i < 5; i++) {
                name = scHard.nextLine();
                time = scHard.nextLine();

                addNewWinnerHard(name, time);
            }
            scHard.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    ArrayList<Record> listOfEasy = new ArrayList();
    ArrayList<Record> listOfNormal = new ArrayList();
    ArrayList<Record> listOfHard = new ArrayList();

    public void addNewWinnerEasy(String name, String time) {
        listOfEasy.add(new Record(name, time));
    }

    public void addNewWinnerNormal(String name, String time) {
        listOfNormal.add(new Record(name, time));
    }

    public void addNewWinnerHard(String name, String time) {
        listOfHard.add(new Record(name, time));
    }

    public String printEasy() {

        Collections.sort(listOfEasy, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        easyDataList = "";
        for (int i = 0; i < 5; i++) {
            easyDataList += (i + 1) + "/ " + listOfEasy.get(i).getTime() + " --- " + listOfEasy.get(i).getName() + "\n\n";
//            System.out.println((i + 1) + ". " + listOfEasy.get(i).getName() + " --- " + listOfEasy.get(i).getTime());
        }
        return easyDataList.trim();
    }

    public String printNormal() {
        Collections.sort(listOfNormal, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        normalDataList = "";
        for (int i = 0; i < 5; i++) {
            normalDataList += (i + 1) + "/ " + listOfNormal.get(i).getTime() + " --- " + listOfNormal.get(i).getName() + "\n\n";
        }
        return normalDataList.trim();
    }

    public String printHard() {
        Collections.sort(listOfHard, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        hardDataList = "";
        for (int i = 0; i < 5; i++) {
            hardDataList += (i + 1) + "/ " + listOfNormal.get(i).getTime() + " --- " + listOfHard.get(i).getName() + "\n\n";
        }
        return hardDataList.trim();
    }

    public ArrayList<Record> getListOfEasy() {
        return listOfEasy;
    }

    public ArrayList<Record> getListOfMedium() {
        return listOfNormal;
    }

    public ArrayList<Record> getListOfHard() {
        return listOfHard;
    }

    public void saveData() {
        //******************SAVE EASY RECORD******************//
        Collections.sort(listOfEasy, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        try {
            FileWriter fwe = new FileWriter(easy_data);
            BufferedWriter bfe = new BufferedWriter(fwe);
            PrintWriter saveEasy = new PrintWriter(bfe);
            for (int i = 0; i < 5; i++) {
                saveEasy.println(listOfEasy.get(i).getName());
                saveEasy.println(listOfEasy.get(i).getTime());
            }
            saveEasy.flush();
            saveEasy.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        //******************SAVE MEDIUM RECORD******************//
        Collections.sort(listOfNormal, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        try {
            FileWriter fwm = new FileWriter(medium_data);
            BufferedWriter bfm = new BufferedWriter(fwm);
            PrintWriter saveMedium = new PrintWriter(bfm);
            for (int i = 0; i < 5; i++) {
                saveMedium.println(listOfNormal.get(i).getName());
                saveMedium.println(listOfNormal.get(i).getTime());
            }
            saveMedium.flush();
            saveMedium.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        //******************SAVE HARD RECORD******************//
        Collections.sort(listOfHard, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        try {
            FileWriter fwh = new FileWriter(hard_data);
            BufferedWriter bfh = new BufferedWriter(fwh);
            PrintWriter saveHard = new PrintWriter(bfh);
            for (int i = 0; i < 5; i++) {
                saveHard.println(listOfHard.get(i).getName());
                saveHard.println(listOfHard.get(i).getTime());
            }
            saveHard.flush();
            saveHard.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args) {
//        RecordList rl = new RecordList();
//        rl.setFile(args);
//        rl.readData();
//        rl.printEasy();
//        rl.printHard();
//        rl.printNormal();
//        rl.saveData();
//
//    }
    public RecordList() {
        setFile();
        readData();
        saveData();
    }

}
