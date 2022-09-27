package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SideModel {
    private static final SideModel instance = new SideModel();
    private static final AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, Side> model ;


    public SideModel() {
        model = new HashMap<Integer, Side>();
       /* model.put(1, new Side(338,23,"Север") );
        model.put(2, new Side(24,68,"Северо-Восток") );
        model.put(3, new Side(69,113,"Восток") );
        model.put(4, new Side(114,158,"Юго-Восток") );
        model.put(5, new Side(159,203,"Юг") );
        model.put(6, new Side(204,248,"Юго-Запад") );
        model.put(7, new Side(249,293,"Запад") );
        model.put(8, new Side(294,337,"Северо-Запад") );*/
    }

    public static SideModel getInstance(){
        return instance;
    }

    public void add(Side side, Integer id){

        model.put(id,side);
    }

    public Map<Integer,Side> getAll(){
        return model;
    }

    public String checkSide(Integer degree){
        String result = "Сторона света не определилась";
        for (Map.Entry<Integer, Side> entry : model.entrySet()) {
            int left = entry.getValue().left;
            int right =entry.getValue().right;
            if (left > right){
                if (degree>=left && degree>=0 || degree>=0 && degree <=right) {
                    result = entry.getValue().side;
                }

            } else {
                if (degree >= left && degree <= right) {
                    result = entry.getValue().side;
                }
            }

        }
        return result;
    }

}
