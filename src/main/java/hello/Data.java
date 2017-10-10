package hello;

import java.io.Serializable;
import java.util.Arrays;

public class Data implements Serializable{

    private static final Long serialVersionUID = 4606728092495115499L;
    private String id;
    private Integer[] payload;

    public Data() {
    }

    public Data(String id, Integer[] payload) {
        this.id = id;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer[] getPayload() {
        return payload;
    }

    public void setPayload(Integer[] payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (id != null ? !id.equals(data.id) : data.id != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(payload, data.payload);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(payload);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", payload=" + Arrays.toString(payload) +
                '}';
    }
}
