package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 存储书籍信息的对象 t_books
 * 
 * @author ruoyi
 * @date 2024-09-24
 */
public class TBooks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 书籍的唯一标识符 */
    private Long id;

    /** 书籍的标题 */
    @Excel(name = "书籍的标题")
    private String title;

    /** 书籍的作者 */
    @Excel(name = "书籍的作者")
    private String author;

    /** 书籍的出版年份 */
    @Excel(name = "书籍的出版年份")
    private Long publicationYear;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setPublicationYear(Long publicationYear) 
    {
        this.publicationYear = publicationYear;
    }

    public Long getPublicationYear() 
    {
        return publicationYear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("publicationYear", getPublicationYear())
            .toString();
    }
}
