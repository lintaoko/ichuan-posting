package App.Mapper;

import App.Domain.MainPosting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface MainPostingMapper {

    //主题帖查询byUserId(查询自己的贴子)
    @Select("select *  from main_posting where UserId=#{UserId}")
    List<MainPosting> queryMainPostingByUserId(@Param("UserId") Integer userId);
    //主题帖搜索
    @Select("select *  from main_posting where PostingTitle like '%#{PostingTitle}%'")
    List<MainPosting> queryMainPostingByLikePostingTitle(@Param("PostingTitle") String PostingTitle);
    //发表主题帖
    @Insert("insert into main_posting(UserId,PostingTitle,PostingContent,PostedTime,PostAuther,PostImg) values(#{UserId},#{PostingTitle},#{PostingContent},#{PostedTime},#{PostAuther},#{PostImg})")
    Integer mainPostingInsert(@Param("UserId") Integer userId, @Param("PostingTitle")String postingTitle, @Param("PostingContent")String postingContent, @Param("PostedTime")Date postedTime,@Param("PostAuther")String postAuther,@Param("PostImg")String postImg);
    //删除主题帖
    @Delete("delete main_posting where MainPostingId=#{MainPostingId}")
    Integer mainPostingDeleteByMainPostingId(@Param("MainPostingId")Integer mainPostingId);
}
