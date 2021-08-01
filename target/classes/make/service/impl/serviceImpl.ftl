package ${serviceimpl.packageName}.service.impl;

import ${serviceimpl.packageName}.entity.${serviceimpl.entityName};
import ${serviceimpl.packageName}.mapper.${serviceimpl.entityName}Mapper;
import ${serviceimpl.packageName}.service.I${serviceimpl.entityName}Service;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
* @Description: ${serviceimpl.entityName}ServiceImpl
* @Author: ${serviceimpl.author}
* @Date:   ${.now?string["yyyy-MM-dd"]}
* @since: V1.0
*/
@Service
public class ${serviceimpl.entityName}ServiceImpl extends ServiceImpl<${serviceimpl.entityName}Mapper, ${serviceimpl.entityName}> implements I${serviceimpl.entityName}Service {

}
