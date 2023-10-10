package com.example.openfeigndemo.myfeign;

import com.example.openfeigndemo.myannotations.CustomProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.myfeign
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  09:33
 * @Description: TODO
 * @Version: 1.0
 */
@CustomProxy(servie = "",address = "http://localhost:8082")
public interface MyService {
    @RequestMapping(value = "/QuerySubselect",method = RequestMethod.GET)
    String  test();
}
