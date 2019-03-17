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
        List<ReplyPosting> result =replyPostingService.queryReplyPostingByReplyUserId(replyUserId);
        return  result;
    }
    //查询主题帖的回复贴
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid")
    public List<ReplyPosting> queryReplyPostingByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        List<ReplyPosting> result =replyPostingService.queryReplyPostingByMainPostingId(mainPostingId);
        return result;
    }
    //查询主题帖中某人的回复贴(只看楼主)
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid/{ReplyUserId}/replyuserid")
    public List<ReplyPosting> queryReplyPostingByMainPostingIdAndReplyUserId(@PathVariable("MainPostingId") Integer mainPostingId,@PathVariable("ReplyUserId") Integer replyUserId){
        List<ReplyPosting> result =replyPostingService.queryReplyPostingByMainPostingIdAndReplyUserId(mainPostingId, replyUserId);
        return result;
    }
    //回复主题帖
    @PostMapping("api/replyposting")
    public Integer replyPostingInsert(Integer mainPostingId, Integer replyUserId, String replyContent, String replyImg, String Replier){
        Date replyTime=new Date();
        Integer result=replyPostingService.replyPostingInsert(mainPostingId, replyTime, replyUserId, replyContent, replyImg, Replier);
        return result;
    }
    //删除回复
    @DeleteMapping("api/replyposting/{ReplyUserId}/replyuserid")
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        Integer result=replyPostingService.replyPostingDeleteByReplyPostingId(replyPostingId);
        return  result;
    }

}
