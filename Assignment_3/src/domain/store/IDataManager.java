package domain.store;

import java.io.Serializable;

/**
 * @author umut.taherzadeh
 *
 */
public interface IDataManager extends Serializable {

    public String[][] getObjectsFromFile(String id) throws Exception;

    public void update(Object obj) throws Exception;

    public void delete(String id) throws Exception;

    public void save(Object obj) throws Exception;

    public Object select(String id) throws Exception;

}
