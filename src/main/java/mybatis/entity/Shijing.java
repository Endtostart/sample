package mybatis.entity;

import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public class Shijing {
    private Integer id;
    private String title;
    private String chapter;
    private String section;
    private String[] content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContent() {
        return StringUtils.join(content);
    }

    public void setContent(String[] content) {
        this.content = content;
    }
}
