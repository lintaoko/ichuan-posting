package App.Controller;
import App.Domain.MainPosting;
import App.Service.MainPostingService;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
public class MainPostingController {
    @Autowired
    MainPostingService mainPostingService;
    //主题帖获取
    @GetMapping("api/mainposting/{pageNum}/{pageSize}")
    public Map queryAllMainPosting(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageInfo<MainPosting> postingPageInfo= mainPostingService.queryAllMainPosting(pageNum,pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("list",postingPageInfo.getList());
        map.put("size",postingPageInfo.getTotal());
        return map;
    }
    //主题帖查询byUserId(查询自己的贴子)
    @GetMapping("api/mainposting/{UserId}/userid")
    public List<MainPosting> queryMainPostingByUserId(@PathVariable("UserId") Integer userId){
        return mainPostingService.queryMainPostingByUserId(userId);
    }
    //主题帖搜索
    @GetMapping("api/mainposting/{PostingTitle}/postingtitle")
    public List<MainPosting> queryMainPostingByLikePostingTitle(@PathVariable("PostingTitle") String postingTitle){
        return mainPostingService.queryMainPostingByLikePostingTitle(postingTitle);
    }
    //发表主题帖
    @PostMapping("api/mainposting")
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, String postAuthor, String postImg) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date time=df.parse(df.format(new Date()));
        return mainPostingService.mainPostingInsert(userId, postingTitle, postingContent, time, postAuthor, postImg);
    }
    //删除主题帖
    @DeleteMapping("api/mainposting/{MainPostingId}/mainpostingid")
    public Integer mainPostingDeleteByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        return mainPostingService.mainPostingDeleteByMainPostingId(mainPostingId);
    }
}
