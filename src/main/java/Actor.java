import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actor {

    private static int id;
    private String name;

    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Actor(String name) {
        this.name = name;
    }

    public static void addActor(Actor actor) {

    }

    public static int getId() {
        return id;
    }

    public   int getIdSelectActor(int selectActorId) {
        return id;
    }

    public static Actor getActorById(int selectActorId) {
        return new Actor(selectActorId,"Actor"+selectActorId);
    }

    public  String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  void  setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
