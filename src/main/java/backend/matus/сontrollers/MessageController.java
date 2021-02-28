package backend.matus.сontrollers;


import backend.matus.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("recordings")
public class MessageController {
    private int count=4;

    public List<Map<String, String>> recordings= new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>(){{put("id", "1"); put("text","bla bal bal"); }});
        add(new HashMap<String, String>(){{put("id", "2"); put("text","bla bal bal"); }});
        add(new HashMap<String, String>(){{put("id", "3"); put("text","bla bal bal"); }});
        add(new HashMap<String, String>(){{put("id", "4"); put("text","bla bal bal"); }});
        add(new HashMap<String, String>(){{put("id", "5"); put("text","bla bal bal"); }});
        }};
    @GetMapping
    public List<Map<String, String>> recordings(){
        return recordings;
    }
    @GetMapping("{id}")
    public Map<String, String> oneRecording(@PathVariable String id){
        return getRecordFromId(id);
    }



    @PostMapping
    public Map<String, String> create (@RequestBody Map<String, String> record) {
        record.put("id", String.valueOf(count++));
        recordings.add(record);
        return record;
    }
    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id,  @RequestBody Map<String, String>  record){
        Map<String, String> recordFromDb = getRecordFromId(record.get("id"));
        recordFromDb.putAll(record);
        recordFromDb.put("id", id);
        return  recordFromDb ;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> record = getRecordFromId(id);
        recordings.remove(record);
    }
//    поиск записи по базе
    private Map<String, String> getRecordFromId(@PathVariable String id) {
        return recordings.stream()
                .filter(record->record.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
