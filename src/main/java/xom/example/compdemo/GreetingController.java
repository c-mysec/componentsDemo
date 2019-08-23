package xom.example.compdemo;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    @Resource
    FileLoaderDemo fileLoader;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) throws IOException {
    	fileLoader.startLoader();
    	String template = fileLoader.getCoverTextTemplate();
    	String conf = fileLoader.getEditorConfig();
        return new Greeting(counter.incrementAndGet(),
                            template + conf);
    }
}