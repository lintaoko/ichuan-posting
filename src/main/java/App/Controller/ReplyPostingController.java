package App.Controller;
import App.Domain.ReplyPosting;
import App.Service.ReplyPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
@RestController
@Slf4j
public class ReplyPostingController {
    @Autowired
    ReplyPostingService replyPostingService;
    //查询自己的回复贴
    @GetMapping("api/replyposting/{ReplyUserId}/replyuserid")
    public List<ReplyPosting> queryReplyPostingByReplyUserId(@PathVariable("ReplyUserId") Integer replyUserId){
        return replyPostingService.queryReplyPostingByReplyUserId(replyUserId);
    }
    //查询主题帖的回复贴
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid")
    public List<ReplyPosting> queryReplyPostingByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        return replyPostingService.queryReplyPostingByMainPostingId(mainPostingId);
    }
    //查询主题帖中某人的回复贴(只看楼主)
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid/{ReplyUserId}/replyuserid")
    public List<ReplyPosting> queryReplyPostingByMainPostingIdAndReplyUserId(@PathVariable("MainPostingId") Integer mainPostingId,@PathVariable("ReplyUserId") Integer replyUserId){
        return replyPostingService.queryReplyPostingByMainPostingIdAndReplyUserId(mainPostingId, replyUserId);
    }
    //回复主题帖
    @PostMapping("api/replyposting")
    public Integer replyPostingInsert(Integer mainPostingId, Integer replyUserId, String replyContent, String replyImg, String Replier){
        Date replyTime=new Date();
        return replyPostingService.replyPostingInsert(mainPostingId, replyTime, replyUserId, replyContent, replyImg, Replier);
    }
    //删除回复
    @DeleteMapping("api/replyposting/{ReplyPostingId}/replypostingid")
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        return replyPostingService.replyPostingDeleteByReplyPostingId(replyPostingId);
    }
}
