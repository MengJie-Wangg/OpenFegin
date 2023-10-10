package com.example.openfeigndemo.controll;

import com.example.openfeigndemo.myannotations.ConfigEntity;
import com.example.openfeigndemo.myfeign.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.controll
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  09:35
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class TestControll {
    @Autowired
    private MyService serviceTest;
    @Autowired
    private ConfigEntity configEntity;
    @RequestMapping("/test1")
    String Test(){
       return  serviceTest.test();
    }



    @RequestMapping(value = "/test2/{id}",method = RequestMethod.POST)
    String tst(@PathVariable("id") String id, @RequestParam String dd,@RequestBody String a){
        System.out.println(configEntity);
        System.out.println(a);
        return "ssssss";
    }


}
