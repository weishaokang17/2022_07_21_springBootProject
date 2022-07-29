package per.wsk.mapper;

import org.apache.ibatis.annotations.Mapper;
import per.wsk.bean.Account;

@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
