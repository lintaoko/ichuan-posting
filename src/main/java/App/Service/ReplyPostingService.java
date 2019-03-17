package App.Service;

import App.Mapper.ReplyPostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyPostingService {
    @Autowired
    ReplyPostingMapper replyPostingMapper;
}
