package cn.com.dnt.feign.ribbon;

import feign.Headers;
import feign.RequestLine;

public interface RibbonFeign {

    @RequestLine("GET /api/v3/instances/domains")
    @Headers("Content-Type: application/json")
    String domains();
}
