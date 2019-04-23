package App.Service;
import App.Domain.MainPosting;
import App.Mapper.MainPostingMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class MainPostingService {
    @Autowired
    MainPostingMapper mainPostingMapper;
    //主题帖获取
    public PageInfo<MainPosting>  queryAllMainPosting(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<MainPosting> data =mainPostingMapper.queryAllMainPosting();
        return new PageInfo<>(data);
    }
    //主题帖查询byUserId(查询自己的贴子)
    public List<MainPosting> queryMainPostingByUserId(Integer userId){
        return mainPostingMapper.queryMainPostingByUserId(userId);
    }
    //主题帖搜索
    public List<MainPosting> queryMainPostingByLikePostingTitle( String postingTitle){
        return mainPostingMapper.queryMainPostingByLikePostingTitle(postingTitle);
    }
    //发表主题帖
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, Date postedTime, String postAuthor,String postImg){
        return mainPostingMapper.mainPostingInsert(userId, postingTitle, postingContent, postedTime, postAuthor, postImg);
    }
    //删除主题帖
    public Integer mainPostingDeleteByMainPostingId(Integer mainPostingId){
        return mainPostingMapper.mainPostingDeleteByMainPostingId(mainPostingId);
    }
}
