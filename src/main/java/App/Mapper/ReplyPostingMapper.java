package App.Mapper;

import App.Domain.ReplyPosting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ReplyPostingMapper {
    //查询自己的回复贴
    @Select("select * from reply_posting where ReplyUserId=#{ReplyUserId}")
    List<ReplyPosting> queryReplyPostingByReplyUserId(@Param("ReplyUserId")Integer replyUserId);
    //查询主题帖的回复贴
    @Select("select * from reply_posting where MainPostingId=#{MainPostingId}")
    List<ReplyPosting> queryReplyPostingByMainPostingId(@Param("MainPostingId")Integer mainPostingId);

    //回复主题帖
    @Insert("insert into reply_posting(MainPostingId,ReplyTime,ReplyUserId,ReplyContent,ReplyImg,Replier)values(#{MainPostingId},#{ReplyTime},#{ReplyUserId},#{ReplyContent},#{ReplyImg},#{Replier})")
    Integer replyPostingInsert(@Param("MainPostingId")Integer mainPostingId, @Param("ReplyTime")Date replyTime,@Param("ReplyUserId")Integer replyUserId,@Param("ReplyContent") String replyContent,@Param("ReplyImg")String replyImg,@Param("Replier")String Replier);

    //删除回复
    @Delete("delete reply_posting where ReplyPostingId=#{ReplyPostingId}")
    Integer replyPostingDeleteByReplyPostingId(@Param("ReplyPostingId") Integer replyPostingId);

}
