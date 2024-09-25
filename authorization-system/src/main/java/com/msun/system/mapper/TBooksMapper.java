package com.msun.system.mapper;

import com.msun.system.domain.TBooks;

import java.util.List;

/**
 * 存储书籍信息的Mapper接口
 * 
 * @author msun
 * @date 2024-09-24
 */
public interface TBooksMapper 
{
    /**
     * 查询存储书籍信息的
     * 
     * @param id 存储书籍信息的主键
     * @return 存储书籍信息的
     */
    public TBooks selectTBooksById(Long id);

    /**
     * 查询存储书籍信息的列表
     * 
     * @param tBooks 存储书籍信息的
     * @return 存储书籍信息的集合
     */
    public List<TBooks> selectTBooksList(TBooks tBooks);

    /**
     * 新增存储书籍信息的
     * 
     * @param tBooks 存储书籍信息的
     * @return 结果
     */
    public int insertTBooks(TBooks tBooks);

    /**
     * 修改存储书籍信息的
     * 
     * @param tBooks 存储书籍信息的
     * @return 结果
     */
    public int updateTBooks(TBooks tBooks);

    /**
     * 删除存储书籍信息的
     * 
     * @param id 存储书籍信息的主键
     * @return 结果
     */
    public int deleteTBooksById(Long id);

    /**
     * 批量删除存储书籍信息的
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBooksByIds(Long[] ids);
}
