package training.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import training.service.lucene.LuceneService;

@RestController
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LuceneService luceneService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody  String test(){
        try {
            return "UserController.test" + luceneService.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UserController.test";
    }
}
