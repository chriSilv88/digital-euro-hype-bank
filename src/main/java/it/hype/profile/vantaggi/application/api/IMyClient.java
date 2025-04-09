package it.hype.profile.vantaggi.application.api;

import it.hype.profile.vantaggi.application.config.MyClientConfig;
import it.hype.profile.vantaggi.application.models.my.MyRequest;
import it.hype.profile.vantaggi.application.models.my.MyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "my", url = "${my.url}", configuration = MyClientConfig.class)
public interface IMyClient {

    @PostMapping(value = "${my.api.search}", produces = MediaType.APPLICATION_JSON_VALUE)
    MyResponse search(@RequestBody MyRequest request);
}
