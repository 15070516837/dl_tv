package ${package.Mapper};

import ${package.Entity}.${entity};
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* ${table.comment!}${table.name}表持久层接口
*
* @author ${author}
* @since ${date}
*/
@Mapper
public interface ${table.mapperName} extends BaseMapper<${entity}> {

}

