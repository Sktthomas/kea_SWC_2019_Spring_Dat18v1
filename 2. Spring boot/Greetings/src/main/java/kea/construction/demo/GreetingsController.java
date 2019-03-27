package kea.construction.demo;


import org.springframework.web.bind.annotation.*;

import java.util.Random;

//Det er ligemeget hvilken mappe du ligger filen i, bare du bruger annotationen nedenunder. Alt under annotationen er en Bean.
@RestController
public class GreetingsController {

    //Value er endpointet, altså stien. Required er false hvis den requestparameter ikke er krævet
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String greetings(@RequestParam(value="name", required = false) String name){
        if(name == null){
            return "Ved sgu ikke hvem du er!";
        }
        return "hello world, "+ name;
    }

    @RequestMapping(value="/greetings/{personID}", method = RequestMethod.GET)
    public String mingleWithPerson(@PathVariable Integer personID){
        switch(personID){
            case 1: return "Noget";
            case 2: return "Noget andet";
            case 3: return "noget tredje";
            default: return "default";
        }
    }

    @RequestMapping(value = "/getBody", method = RequestMethod.POST)
    public String getBody(@RequestBody String body){
        return body;
    }

}
