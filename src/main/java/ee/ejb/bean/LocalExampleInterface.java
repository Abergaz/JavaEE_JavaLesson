package ee.ejb.bean;

import javax.ejb.Local;
import javax.ejb.Remote;

/** @Remote - можно по сети общаться*/
@Local
public interface LocalExampleInterface {
    public String getName();
}
