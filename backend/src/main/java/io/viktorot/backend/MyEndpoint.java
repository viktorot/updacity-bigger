package io.viktorot.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import io.viktorot.jokes.Joker;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.viktorot.io",
                ownerName = "backend.viktorot.io",
                packagePath = ""
        )
)
public class MyEndpoint {

//    /** A simple endpoint method that takes a name and says Hi back */
//    @ApiMethod(name = "sayHi")
//    public MyBean sayHi(@Named("name") String name) {
//        MyBean response = new MyBean();
//        response.setData("Hi, " + name);
//
//        return response;
//    }

    @ApiMethod(name = "joker")
    public MyBean tellJoke() {
        String joke = Joker.getRandomJoke();
        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }
}

