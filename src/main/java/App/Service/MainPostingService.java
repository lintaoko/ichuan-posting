package App.Service;

import App.Domain.MainPosting;
import App.Mapper.MainPostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPostingService {
    @Autowired
    MainPostingMapper mainPostingMapper;

}
