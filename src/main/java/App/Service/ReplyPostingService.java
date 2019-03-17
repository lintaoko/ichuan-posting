package App.Service;

import App.Domain.ReplyPosting;
import App.Mapper.ReplyPostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyPostingService {
    @Autowired
    ReplyPostingMapper replyPostingMapper;

    //查询自己的回复贴
    public List<ReplyPosting> queryReplyPostingByReplyUserId(Integer replyUserId){
        List<ReplyPosting> selectResult =replyPostingMapper.queryReplyPostingByReplyUserId(replyUserId);
        return  selectResult;
    }
    //查询主题帖的回复贴
    public List<ReplyPosting> queryReplyPostingByMainPostingId(Integer mainPostingId){
        List<ReplyPosting> selectResult =replyPostingMapper.queryReplyPostingByMainPostingId(mainPostingId);
        return selectResult;
    }
    //查询主题帖中某人的回复贴(只看楼主)
    public List<ReplyPosting> queryReplyPostingByMainPostingIdAndReplyUserId(Integer mainPostingId,Integer replyUserId){
        List<ReplyPosting> selectResult =replyPostingMapper.queryReplyPostingByMainPostingIdAndReplyUserId(mainPostingId, replyUserId);
        return selectResult;
    }

    //回复主题帖
    public Integer replyPostingInsert(Integer mainPostingId, Date replyTime, Integer replyUserId, String replyContent, String replyImg, String Replier){
        Integer insertResult=replyPostingMapper.replyPostingInsert(mainPostingId, replyTime, replyUserId, replyContent, replyImg, Replier);
        return insertResult;
    }
    //删除回复
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        Integer deleteResult=replyPostingMapper.replyPostingDeleteByReplyPostingId(replyPostingId);
        return  deleteResult;
    }
}
