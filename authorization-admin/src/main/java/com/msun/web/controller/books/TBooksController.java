package com.msun.web.controller.books;

import com.msun.common.annotation.Log;
import com.msun.common.core.controller.BaseController;
import com.msun.common.core.domain.AjaxResult;
import com.msun.common.core.page.TableDataInfo;
import com.msun.common.enums.BusinessType;
import com.msun.common.utils.poi.ExcelUtil;
import com.msun.system.domain.TBooks;
import com.msun.system.service.ITBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 存储书籍信息的Controller
 * 
 * @author msun
 * @date 2024-09-24
 */
@RestController
@RequestMapping("/books/books")
public class TBooksController extends BaseController
{
    @Autowired
    private ITBooksService tBooksService;

    /**
     * 查询存储书籍信息的列表
     */
    @PreAuthorize("@ss.hasPermi('books:books:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBooks tBooks)
    {
        startPage();
        List<TBooks> list = tBooksService.selectTBooksList(tBooks);
        return getDataTable(list);
    }

    /**
     * 导出存储书籍信息的列表
     */
    @PreAuthorize("@ss.hasPermi('books:books:export')")
    @Log(title = "存储书籍信息的", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBooks tBooks)
    {
        List<TBooks> list = tBooksService.selectTBooksList(tBooks);
        ExcelUtil<TBooks> util = new ExcelUtil<TBooks>(TBooks.class);
        util.exportExcel(response, list, "存储书籍信息的数据");
    }

    /**
     * 获取存储书籍信息的详细信息
     */
    @PreAuthorize("@ss.hasPermi('books:books:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tBooksService.selectTBooksById(id));
    }

    /**
     * 新增存储书籍信息的
     */
    @PreAuthorize("@ss.hasPermi('books:books:add')")
    @Log(title = "存储书籍信息的", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBooks tBooks)
    {
        return toAjax(tBooksService.insertTBooks(tBooks));
    }

    /**
     * 修改存储书籍信息的
     */
    @PreAuthorize("@ss.hasPermi('books:books:edit')")
    @Log(title = "存储书籍信息的", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBooks tBooks)
    {
        return toAjax(tBooksService.updateTBooks(tBooks));
    }

    /**
     * 删除存储书籍信息的
     */
    @PreAuthorize("@ss.hasPermi('books:books:remove')")
    @Log(title = "存储书籍信息的", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBooksService.deleteTBooksByIds(ids));
    }
}
