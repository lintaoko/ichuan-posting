package App.Service;

import App.Domain.MainPosting;
import App.Mapper.MainPostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MainPostingService {
    @Autowired
    MainPostingMapper mainPostingMapper;
    //主题帖获取
    public List<MainPosting> queryAllMainPosting(){
        List<MainPosting> selectResult=mainPostingMapper.queryAllMainPosting();
        return selectResult;
    }
    //主题帖查询byUserId(查询自己的贴子)
    public List<MainPosting> queryMainPostingByUserId(Integer userId){
        List<MainPosting> selectResult=mainPostingMapper.queryMainPostingByUserId(userId);
        return selectResult;
    }
    //主题帖搜索
    public List<MainPosting> queryMainPostingByLikePostingTitle( String postingTitle){
        List<MainPosting> selectResult=mainPostingMapper.queryMainPostingByLikePostingTitle(postingTitle);
        return selectResult;
    }
    //发表主题帖
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, Date postedTime, String postAuthor,String postImg){
        Integer insertResult =mainPostingMapper.mainPostingInsert(userId, postingTitle, postingContent, postedTime, postAuthor, postImg);
        return insertResult;
    }
    //删除主题帖
    public Integer mainPostingDeleteByMainPostingId(Integer mainPostingId){
        Integer deleteResult =mainPostingMapper.mainPostingDeleteByMainPostingId(mainPostingId);
        return deleteResult;
    }


}
