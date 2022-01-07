package com.example.sdnmarvelbasic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class ComicIssue {
    @Id
    @GeneratedValue
    private Long id;

    private String name, thumbnail;
    private Integer pageCount;
    private Double issueNumber;

    @Relationship(type = "INCLUDES")
    public List<Includes> includes;

    // 注：没必要定义该属性，这与 includes 重复。
    // 未删除仅为了兼容前几节的代码
    @Relationship(type = "INCLUDES")
    @JsonIgnoreProperties("characterComics")
    public List<Character> characters = new ArrayList<>();

    public ComicIssue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public List<Includes> getIncludes() {
        return includes;
    }

    public void setIncludes(List<Includes> includes) {
        this.includes = includes;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
