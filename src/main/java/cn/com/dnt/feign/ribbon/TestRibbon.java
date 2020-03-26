package cn.com.dnt.feign.ribbon;

import cn.com.dnt.feign.config.FeignClientConfig;
import cn.com.dnt.feign.pds.ForwardedForInterceptor;
import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.ribbon.RibbonClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TestRibbon {
    public static void main(String[] args) throws IOException {
        String auth = "ZjRjZDE0ODAtNWY4NS0xMWVhLTk4ZWItNTI1NDAwNzYxOTlk:.";
        final RibbonFeign target = Feign.builder()
                .client(RibbonClient.create())
                .requestInterceptor(new ForwardedForInterceptor(auth))
                .target(RibbonFeign.class, "http://rb-provider");
        final String domains = target.domains();
        System.out.println(domains);
    }
}
