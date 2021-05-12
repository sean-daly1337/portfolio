package controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
// import jdk.incubator.jpackage.internal.IOUtils;

@RestController
@RequestMapping("/images") // http://localhost:8080/agents
public class ImagesController {


    @PostMapping(value = "/get")
    public @ResponseBody
    byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("src/main/resources/static/images/agents/2.jpg");
        return IOUtils.toByteArray(in);
    }

}
