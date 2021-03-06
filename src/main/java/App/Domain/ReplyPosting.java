package App.Domain;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
@Data
@ToString
public class ReplyPosting {
    private Integer replyPostingId;
    private Integer mainPostingId;
    private Date replyTime;
    private Integer replyUserId;
    private String replyContent;
    private String replyImg;
    private String replier;
}
