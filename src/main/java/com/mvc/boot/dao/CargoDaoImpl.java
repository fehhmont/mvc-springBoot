import org.springframework.stereotype.Repository;

import com.mvc.boot.dao.AbstractDao;
import com.mvc.boot.domain.Cargo;
@Repository
public class CargoDaoImpl  extends AbstractDao<Cargo, Long> implements CargoDao{


}
