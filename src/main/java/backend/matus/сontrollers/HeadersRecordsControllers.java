package backend.matus.сontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/headers")
public class HeadersRecordsControllers {
    private List<Map<String, String>> headers= new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>(){{put("id", "1"); put("name","Новости города Серпухова "); put("photoURL", "http://192.168.5.133:8080/img/four.jpg") ;}});
        add(new HashMap<String, String>(){{put("id", "2"); put("name","радость, кторой еще не бывало"); put("photoURL", "http://192.168.5.133:8080/img/2.jpg"); }});
        add(new HashMap<String, String>(){{put("id", "3"); put("name","hello World  in Spring.io"); put("photoURL", "http://192.168.5.133:8080/img/one.jpg") ;}});
        add(new HashMap<String, String>(){{put("id", "4"); put("name","You hate this fucking world?"); put("photoURL", "http://192.168.5.133:8080/img/three.jpg") ;}});
        add(new HashMap<String, String>(){{put("id", "5"); put("name"," да, завтра будет солнечно"); put("photoURL", "http://192.168.5.133:8080/img/four.jpg"); }});
    }};
@GetMapping
public  List<Map<String, String>> headers(){
    return headers;
}
}