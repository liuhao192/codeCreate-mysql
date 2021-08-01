package ${mapper.packageName}.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ${mapper.packageName}.entity.${mapper.entityName};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @Description: ${mapper.entityName}
* @Author: ${mapper.author}
* @Date:   ${.now?string["yyyy-MM-dd"]}
* @since: V1.0
*/
public interface ${mapper.entityName}Mapper extends BaseMapper<${mapper.entityName}> {

}
