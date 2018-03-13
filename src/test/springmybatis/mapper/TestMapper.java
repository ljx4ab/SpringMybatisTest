package test.springmybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	@Select("SELECT * FROM test")
	List<Map<String,Object>> getTests();
}
