package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.TBooks;
import com.ruoyi.system.mapper.TBooksMapper;
import com.ruoyi.system.service.ITBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 存储书籍信息的Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-24
 */
@Service
public class TBooksServiceImpl implements ITBooksService
{
    @Autowired
    private TBooksMapper tBooksMapper;

    /**
     * 查询存储书籍信息的
     * 
     * @param id 存储书籍信息的主键
     * @return 存储书籍信息的
     */
    @Override
    public TBooks selectTBooksById(Long id)
    {
        return tBooksMapper.selectTBooksById(id);
    }

    /**
     * 查询存储书籍信息的列表
     * 
     * @param tBooks 存储书籍信息的
     * @return 存储书籍信息的
     */
    @Override
    public List<TBooks> selectTBooksList(TBooks tBooks)
    {
        return tBooksMapper.selectTBooksList(tBooks);
    }

    /**
     * 新增存储书籍信息的
     * 
     * @param tBooks 存储书籍信息的
     * @return 结果
     */
    @Override
    public int insertTBooks(TBooks tBooks)
    {
        return tBooksMapper.insertTBooks(tBooks);
    }

    /**
     * 修改存储书籍信息的
     * 
     * @param tBooks 存储书籍信息的
     * @return 结果
     */
    @Override
    public int updateTBooks(TBooks tBooks)
    {
        return tBooksMapper.updateTBooks(tBooks);
    }

    /**
     * 批量删除存储书籍信息的
     * 
     * @param ids 需要删除的存储书籍信息的主键
     * @return 结果
     */
    @Override
    public int deleteTBooksByIds(Long[] ids)
    {
        return tBooksMapper.deleteTBooksByIds(ids);
    }

    /**
     * 删除存储书籍信息的信息
     * 
     * @param id 存储书籍信息的主键
     * @return 结果
     */
    @Override
    public int deleteTBooksById(Long id)
    {
        return tBooksMapper.deleteTBooksById(id);
    }
}
