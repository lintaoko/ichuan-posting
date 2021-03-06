package App.Domain;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
@Data
@ToString
public class MainPosting {
    private Integer mainPostingId;
    private Integer userId;
    private String postingTitle;
    private String postingContent;
    private Date postedTime;
    private String postAuthor;
    private String postImg;
}
