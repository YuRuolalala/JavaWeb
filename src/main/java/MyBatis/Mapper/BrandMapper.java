package MyBatis.Mapper;

import MyBatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     */
     List<Brand> selectAll();

     Brand selectById(int id);

    /**
     * 条件查询
     *  参数接收：
     *      1·散装参数：如果方法中有多个参数，需要使用@Parm()
     * @param status
     * @param companyNane
     * @param brandName
     * @return
     */
     List<Brand> selectByCondition(
             @Param("status")int status,
             @Param("companyName")String companyNane,
             @Param("brandName")String brandName
     );

     List<Brand> selectByCondition(Brand brand);

    /**
     * 添加
     */
    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);

}
