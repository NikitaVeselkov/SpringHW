package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    public static final SideModel sideModel = SideModel.getInstance();
    public static final AtomicInteger  newId= new AtomicInteger(1);

    @PostMapping(value = "/addSide",consumes ="application/json" )
    public void addSide(@RequestBody Map<String,String> sides ){
        for (Map.Entry<String, String> entry : sides.entrySet()) {
            String[] borders = entry.getValue().split("-");
            int left = Integer.parseInt(borders[0]);
            int right = Integer.parseInt(borders[1]);
            sideModel.add(new Side(left,right,entry.getKey()), newId.getAndIncrement());
            System.out.println(left + " - " + right);

        }
    }

    @GetMapping(value = "/getSide", consumes ="application/json",produces="application/json")
    public Map<String,String> getSide (@RequestBody Map<String,Integer> degree){
        Map<String,String> result = new HashMap<String,String>();
        result.put("Side", sideModel.checkSide(degree.get("degree")));
        return result;
    }
}
