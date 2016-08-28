/**
 * Created by rishabh.garg
 */

package main.app.models;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@NodeEntity
@Setter
@Getter
@AllArgsConstructor
public class Person {

    @GraphId
    private Long id;

    private String firstName;

    private String lastName;
}