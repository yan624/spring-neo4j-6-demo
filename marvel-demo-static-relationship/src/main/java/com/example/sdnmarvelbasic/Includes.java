package com.example.sdnmarvelbasic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * @author 朱若尘
 * @version 0.0.1-SNAPSHOT
 * @since 2022-01-06
 */
@RelationshipProperties
public class Includes {
    @RelationshipId
    private Long id;

    @TargetNode
    @JsonIgnoreProperties("characterComics")
    private Character character;

    // 你还可以为关系实体定义一些自定义的属性，此处省略。

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
