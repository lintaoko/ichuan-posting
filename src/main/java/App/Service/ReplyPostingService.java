package App.Service;

import App.Domain.ReplyPosting;
import App.Mapper.ReplyPostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ReplyPostingService {
    @Autowired
    ReplyPostingMapper replyPostingMapper;
    //查询自己的回复贴
    public List<ReplyPosting> queryReplyPostingByReplyUserId(Integer replyUserId){
        return replyPostingMapper.queryReplyPostingByReplyUserId(replyUserId);
    }
    //查询主题帖的回复贴
    public List<ReplyPosting> queryReplyPostingByMainPostingId(Integer mainPostingId){
        return replyPostingMapper.queryReplyPostingByMainPostingId(mainPostingId);
    }
    //查询主题帖中某人的回复贴(只看楼主)
    public List<ReplyPosting> queryReplyPostingByMainPostingIdAndReplyUserId(Integer mainPostingId,Integer replyUserId){
        return replyPostingMapper.queryReplyPostingByMainPostingIdAndReplyUserId(mainPostingId, replyUserId);
    }
    //回复主题帖
    public Integer replyPostingInsert(Integer mainPostingId, Date replyTime, Integer replyUserId, String replyContent, String replyImg, String Replier){
        return replyPostingMapper.replyPostingInsert(mainPostingId, replyTime, replyUserId, replyContent, replyImg, Replier);
    }
    //删除回复
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        return replyPostingMapper.replyPostingDeleteByReplyPostingId(replyPostingId);
    }
}
